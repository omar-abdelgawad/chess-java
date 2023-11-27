package pieces;

/**
 * King
 * TODO: implement castling
 */
public class King extends Piece {
    public boolean isValidMove(int row, int col) {
        if (this.row == row - 1 || this.row == row + 1 || this.col == col + 1 || this.col == col - 1
                || this.col + this.row - (row + col) == 2
                || this.col + this.row - (row + col) == -2) {
            return true;
        }
        return false;
    }
}