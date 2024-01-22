package pieces;

/**
 * EmptyPiece
 */
public class EmptyPiece extends Piece {
    public EmptyPiece(int row, int col) {
        super(row, col);
    }

    @Override
    public boolean isValidMove(int row, int col) {
        return false;
    }
}