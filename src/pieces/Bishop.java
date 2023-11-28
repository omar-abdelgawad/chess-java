package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * Bishop
 */
public class Bishop extends Piece {
    public Bishop(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type, ImageIcon icon) {
        super(row, col, color, boardPanel, type, icon);
    }

    public boolean isValidMove(int row, int col) {
        if (this.row + this.col == row + col || this.row - this.col == row - col) {
            return true;
        }
        return false;
    }
}