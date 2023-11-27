package pieces;

/**
 * Bishop
 */
public class Bishop extends Piece {
    // public Bishop(int row, int col, PieceColor color) {
    // super(row, col, color);
    // }
    public boolean isValidMove(int row, int col) {
        if (this.row + this.col == row + col || this.row - this.col == row - col) {
            return true;
        }
        return false;
    }
}