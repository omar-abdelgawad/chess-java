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
        WHITE, BLACK
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
    public PieceType type;
    public BoardPanel boardPanel;
    public boolean hasMoved = false;
    public ImageIcon icon;

    public Piece(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type, ImageIcon icon) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.boardPanel = boardPanel;
        this.type = type;
        this.icon = icon;
    }

    public Piece(int row, int col, PieceType type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public HashMap<MoveType, ArrayList<Point>> getValidMoves() {
        HashMap<MoveType, ArrayList<Point>> validMoves = new HashMap<>();
        ArrayList<Point> validMovesList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isValidMove(i, j)) {
                    validMovesList.add(new Point(i, j));
                }
            }
        }
        // validMoves.put(this.toMoveType(), validMovesList);
        validMoves.put(MoveType.EMPTY, validMovesList);
        return validMoves;

    }

    public abstract boolean isValidMove(int row, int col);
}