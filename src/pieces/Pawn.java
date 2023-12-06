package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * Pawn
 * TODO: implement En Passant
 * TODO: upgrading upon reaching 8th rank
 */

public class Pawn extends Piece {
    public Pawn(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type, ImageIcon icon) {
        super(row, col, color, boardPanel, type, icon);
    }

    public boolean isValidMove(int row, int col) {
        if (color == PieceColor.WHITE) {

            if (this.hasMoved == true) {
                if (this.row + 1 == row || this.row + 2 == row) {
                    return true;
                }

            } else {
                if (row == this.row + 1) {
                    return true;
                }

            }
            return false;
        } else {
            if (this.hasMoved == true) {
                if (this.row - 1 == row || this.row - 2 == row) {
                    return true;
                }

            } else if (row == this.row - 1) {
                return true;

            }
            return false;

        }
    }

}