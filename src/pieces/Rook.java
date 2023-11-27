package pieces;

/**
 * Rook
 */
public class Rook extends Piece {

    public boolean isValidMove(int row, int col) {
        if (this.row == row || this.col == col) {
            return true;
        }
        return false;
    }

}