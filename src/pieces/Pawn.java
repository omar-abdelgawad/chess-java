package pieces;

import user_interface.BoardPanel;

/**
 * Pawn
 * TODO: implement En Passant
 */
public class Pawn extends Piece {
    public Pawn(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type) {
        super(row, col, color, boardPanel, type);
    }

    public boolean isValidMove(int row, int col) {
        return false;
    }

}