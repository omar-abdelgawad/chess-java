package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * Queen
 */
public class Queen extends Piece {
    public Queen(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type, ImageIcon icon) {
        super(row, col, color, boardPanel, type, icon);
    }

    public boolean isValidMove(int row, int col) {
        if (this.row == row || this.col == col || this.col + this.row == row + col
                || this.row - this.col == row - col) {
            return true;
        }
        return false;
    }

}