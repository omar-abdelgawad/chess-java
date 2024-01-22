package pieces;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;
import java.awt.Point;

/**
 * abstract Piece class that all pieces will extend
 * includes empty piece
 */
public abstract class Piece {
    public enum PieceColor {
        WHITE, BLACK;

        public PieceColor toggle() {
            if (this == WHITE) {
                return BLACK;
            } else {
                return WHITE;
            }
        }
    }

    public enum PieceType {
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING, EMPTY
    }

    public enum MoveType {
        EMPTY, ATTACK
    }

    public int row;
    public int col;
    public PieceColor color;
    public BoardPanel boardPanel;
    public boolean hasMoved = false;
    public ImageIcon icon;

    public Piece(int row, int col, PieceColor color, BoardPanel boardPanel, ImageIcon icon) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.boardPanel = boardPanel;
        this.icon = icon;
    }

    public Piece(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public ArrayList<Point> getValidMovesList() {
        ArrayList<Point> validMovesList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isValidMove(i, j)) {
                    validMovesList.add(new Point(i, j));
                }
            }
        }

        return validMovesList;
    }

    public HashMap<MoveType, ArrayList<Point>> getValidMoves() {
        HashMap<MoveType, ArrayList<Point>> validMoves = new HashMap<>();
        Piece[][] board = this.boardPanel.board;
        ArrayList<Point> emptymoves = new ArrayList<>();
        ArrayList<Point> attackmoves = new ArrayList<>();

        for (Point Move : getValidMovesList()) {
            if (!(board[Move.x][Move.y] instanceof EmptyPiece) && board[Move.x][Move.y].color != this.color) {
                attackmoves.add(Move);
                System.out.println("Attack Move: " + Move.x + ", " + Move.y);
            } else {
                emptymoves.add(Move);
                System.out.println("Empty Move: " + Move.x + ", " + Move.y);
            }
        }

        validMoves.put(MoveType.EMPTY, emptymoves);
        validMoves.put(MoveType.ATTACK, attackmoves);
        return validMoves;

    }

    public HashMap<MoveType, ArrayList<Point>> getValidMoves(ArrayList<Point> validMoves) {
        HashMap<MoveType, ArrayList<Point>> validMovesMap = new HashMap<>();
        ArrayList<Point> emptyMoves = new ArrayList<>();
        ArrayList<Point> attackMoves = new ArrayList<>();
        Piece[][] board = this.boardPanel.board;
        for (Point move : validMoves) {
            if (!(board[move.x][move.y] instanceof EmptyPiece) && board[move.x][move.y].color != this.color) {
                attackMoves.add(move);
            } else {
                emptyMoves.add(move);
            }
        }
        validMovesMap.put(MoveType.EMPTY, emptyMoves);
        validMovesMap.put(MoveType.ATTACK, attackMoves);
        return validMovesMap;
    }

    protected boolean commonIsValid(int targetRow, int targetCol) {
        Piece[][] board = this.boardPanel.board;
        if (this.row == targetRow && this.col == targetCol) {
            return false;
        }
        if (!(board[targetRow][targetCol] instanceof EmptyPiece) && board[targetRow][targetCol].color == this.color) {
            return false;
        }
        return true;
    }

    public abstract boolean isValidMove(int row, int col);
}