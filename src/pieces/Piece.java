package pieces;

import user_interface.BoardPanel;

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

    public int row;
    public int col;
    public PieceColor color;
    public PieceType type;
    public BoardPanel boardPanel;
    public boolean hasMoved = false;

    public Piece(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type) {
        this.row = row;
        this.col = col;
        this.color = color;
        this.boardPanel = boardPanel;
        this.type = type;
    }

    public Piece(int row, int col, PieceType type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public abstract boolean isValidMove(int row, int col);
}