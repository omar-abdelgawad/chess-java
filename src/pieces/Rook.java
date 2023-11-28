package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * Rook
 */
public class Rook extends Piece {
    public Rook(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type, ImageIcon icon) {
        super(row, col, color, boardPanel, type, icon);
    }

    public boolean isValidMove(int row, int col) {
        if (this.row == row || this.col == col) {
            return true;
        }
        return false;
    }

}