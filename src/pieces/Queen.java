package pieces;

/**
 * Queen
 */
public class Queen extends Piece {
    public boolean isValidMove(int row, int col) {
        if (this.row == row || this.col == col || this.col + this.row == row + col
                || this.row - this.col == row - col) {
            return true;
        }
        return false;
    }

}