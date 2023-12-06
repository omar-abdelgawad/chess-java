package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * King
 * TODO: implement castling
 */
public class King extends Piece {
    public King(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type, ImageIcon icon) {
        super(row, col, color, boardPanel, type, icon);
    }

    public boolean isValidMove(int row, int col) {
        if ((this.row == row - 1 && this.col == col)
                || (this.row == row + 1 && this.col == col)
                || (this.col == col + 1 && this.row == row)
                || (this.col == col - 1 && this.row == row)
                || (this.row == row - 1 && this.col == col - 1)
                || (this.row == row + 1 && this.col == col + 1)
                || (this.row == row - 1 && this.col == col + 1)
                || (this.row == row + 1 && this.col == col - 1)) {
            return true;
        }
        return false;
    }
}