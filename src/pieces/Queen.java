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

    public boolean isValidMove(int targetRow, int targetCol) {
        Piece[][] board = this.boardPanel.board;
        if (!commonIsValid(targetRow, targetCol)) {
            return false;
        }
        // if its not a straight line or diagonal line return false
        if ((targetRow != this.row && targetCol != this.col)
                && (targetRow + targetCol != this.row + this.col && targetRow - targetCol != this.row - this.col)) {
            return false;
        }
        // if its blocked return false
        if (isBlocked(targetRow, targetCol)) {
            return false;
        }
        return true;
    }

    private Boolean isBlocked(int targetRow, int targetCol) {
        Piece[][] board = this.boardPanel.board;
        int rowIncrement = (targetRow - this.row) > 0 ? 1 : -1;
        int colIncrement = (targetCol - this.col) > 0 ? 1 : -1;
        if (targetRow == this.row) {
            for (int i = this.col + colIncrement; i != targetCol; i += colIncrement) {
                if (board[targetRow][i].type != PieceType.EMPTY) {
                    return true;
                }
            }
        } else if (targetCol == this.col) {
            for (int i = this.row + rowIncrement; i != targetRow; i += rowIncrement) {
                if (board[i][targetCol].type != PieceType.EMPTY) {
                    return true;
                }
            }
        } else {
            for (int i = this.row + rowIncrement, j = this.col + colIncrement; i != targetRow
                    && j != targetCol; i += rowIncrement, j += colIncrement) {
                if (board[i][j].type != PieceType.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }
}