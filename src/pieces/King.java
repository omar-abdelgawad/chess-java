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

    public boolean isValidMove(int targetRow, int targetCol) {
        if (!commonIsValid(targetRow, targetCol)) {
            return false;
        }
        if (Math.abs(targetRow - this.row) > 1 || Math.abs(targetCol - this.col) > 1) {
            return false;
        }
        return true;
    }
}