package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * Pawn
 * TODO: implement En Passant
 */
public class Pawn extends Piece {
    public Pawn(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type, ImageIcon icon) {
        super(row, col, color, boardPanel, type, icon);
    }

    public boolean isValidMove(int row, int col) {
        return false;
    }

}