package pieces;

/**
 * EmptyPiece
 */
public class EmptyPiece extends Piece {
    public EmptyPiece(int row, int col, PieceType type) {
        super(row, col, type);
    }

    public boolean isValidMove(int row, int col) {
        return false;
    }
}