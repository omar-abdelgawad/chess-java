package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * Knight
 */
public class Knight extends Piece {
    public Knight(int row, int col, PieceColor color, BoardPanel boardPanel, ImageIcon icon) {
        super(row, col, color, boardPanel, icon);
    }

    @Override
    public boolean isValidMove(int row, int col) {
        if (!commonIsValid(row, col)) {
            return false;
        }
        // check that landing square is not filled with friendly piece
        if ((this.row == row + 2 || this.row == row - 2) && (this.col == col + 1 || this.col == col - 1)
                && this.boardPanel.board[row][col].color != this.color) {
            return true;
        }
        if ((this.col == col + 2 || this.col == col - 2) && (this.row == row + 1 || this.row == row - 1)
                && this.boardPanel.board[row][col].color != this.color) {
            return true;
        }
        return false;
    }
}