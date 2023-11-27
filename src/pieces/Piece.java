package pieces;

/**
 * Piece
 */
public abstract class Piece {
    public enum PieceColor {
        WHITE, BLACK
    }

    public int row;
    public int col;
    public PieceColor color;
    public boolean hasMoved;
    public Piece(){
    }

    public Piece(int row, int col, PieceColor color) {
        this.row = row;
        this.col = col;
        this.color = color;
        hasMoved = false;
    }

    public abstract boolean isValidMove(int row, int col);
}