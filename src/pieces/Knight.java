package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * Knight
 */
public class Knight extends Piece {
    public Knight(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type, ImageIcon icon) {
        super(row, col, color, boardPanel, type, icon);
    }

    public boolean isValidMove(int row, int col) {
        if ((this.row == row + 2 || this.row == row - 2) && (this.col == col + 1 || this.col == col - 1)) {
            return true;
        }
        if ((this.col == col + 2 || this.col == col - 2) && (this.row == row + 1 || this.row == row - 1)) {
            return true;
        }
        return false;
    }
}