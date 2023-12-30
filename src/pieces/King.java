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
        // Piece[][] board = this.boardPanel.board;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.row != row && this.col != col)
                    return false;
                if (!((this.row == row - 1 && this.col == col)
                        || (this.row == row + 1 && this.col == col)
                        || (this.col == col + 1 && this.row == row)
                        || (this.col == col - 1 && this.row == row)
                        || (this.row == row - 1 && this.col == col - 1)
                        || (this.row == row + 1 && this.col == col + 1)
                        || (this.row == row - 1 && this.col == col + 1)
                        || (this.row == row + 1 && this.col == col - 1)))

                    return false;

                // ckeck if other pieces are in the way
                if (isBlocked(this.row, this.col, row, col)) {
                    return false;
                }

            }

        }
        return true;
    }

    private boolean isBlocked(int row, int col, int targetRow, int targetCol) {
        Piece[][] board = this.boardPanel.board;
        if (board[targetCol][targetCol].type != PieceType.EMPTY) {
            return true;
        }
        return false;
    }
}