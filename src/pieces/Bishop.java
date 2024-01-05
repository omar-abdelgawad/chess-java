package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * Bishop class
 */
public class Bishop extends Piece {
    public Bishop(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type, ImageIcon icon) {
        super(row, col, color, boardPanel, type, icon);
    }

    public boolean isValidMove(int targetRow, int targetCol) {
        Piece[][] board = this.boardPanel.board;
        if (!commonIsValid(targetRow, targetCol)) {
            return false;
        }
        // can't move to a spot that is not on the same diagonal
        if (this.row + this.col != targetRow + targetCol && this.row - this.col != targetRow - targetCol) {
            return false;
        }
        // can't move to a spot that is blocked by another piece
        if (isBlocked(targetRow, targetCol)) {
            return false;
        }
        return true;
    }

    private Boolean isBlocked(int targetRow, int targetCol) {
        Piece[][] board = this.boardPanel.board;
        if (targetRow < this.row) {
            if (targetCol < this.col) {
                for (int i = this.row - 1, j = this.col - 1; i > targetRow && j > targetCol; i--, j--) {
                    if (board[i][j].type != PieceType.EMPTY) {
                        return true;
                    }
                }
            } else if (targetCol > this.col) {
                for (int i = this.row - 1, j = this.col + 1; i > targetRow && j < targetCol; i--, j++) {
                    if (board[i][j].type != PieceType.EMPTY) {
                        return true;
                    }
                }
            }
        } else {
            if (targetCol < this.col) {
                for (int i = this.row + 1, j = this.col - 1; i < targetRow && j > targetCol; i++, j--) {
                    if (board[i][j].type != PieceType.EMPTY) {
                        return true;
                    }
                }
            } else if (targetCol > this.col) {
                for (int i = this.row + 1, j = this.col + 1; i < targetRow && j < targetCol; i++, j++) {
                    if (board[i][j].type != PieceType.EMPTY) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}