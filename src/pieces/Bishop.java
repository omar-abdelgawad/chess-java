package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * Bishop
 */
public class Bishop extends Piece {
    public Bishop(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type, ImageIcon icon) {
        super(row, col, color, boardPanel, type, icon);
    }

    public boolean isValidMove(int targetRow, int targetCol) {
        // Piece[][] board = this.boardPanel.board;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // // if same row or same or same col return false
                // if (this.row == targetRow || this.col == targetCol)
                // return false;
                // // if same color return false
                // if (board[targetRow][targetCol].color == this.color) {
                // return false;
                // }

                // if not in same diagonal return false
                if (this.row + this.col != targetRow + targetCol && this.row - this.col != targetRow - targetCol) {
                    return false;
                }
                // if no movement return false
                if (this.row == targetRow && this.col == targetCol) {
                    return false;
                }
                // if there is a piece in the way return false
                if (isBlocked(this.row, this.col, targetRow, targetCol)) {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean isBlocked(int row, int col, int targetRow, int targetCol) {
        Piece[][] board = this.boardPanel.board;
        // moving up the board
        if (targetRow > row) {
            // towards uuper left corner
            if (targetCol > col) {
                for (int i = row + 1, j = col - 1; i < targetRow && j > targetCol; i++, j--) {
                    if (board[row][i].type != PieceType.EMPTY) {
                        return true;
                    }
                }
            }
            // towards upper right corner
            else if (targetCol < col) {
                for (int i = row + 1, j = col + 1; i < targetRow && j < targetCol; i++, j++) {
                    if (board[row][i].type != PieceType.EMPTY) {
                        return true;
                    }
                }
            }
        }
        // moving down the board
        else if (targetRow < row) {
            // towards lower left corner
            if (targetCol < col) {
                for (int i = row - 1, j = col - 1; i > targetRow && j > targetCol; i--, j--) {
                    if (board[row][i].type != PieceType.EMPTY) {
                        return true;
                    }
                }
            }
            // twoards lower right corner
            else if (targetCol > col) {
                for (int i = row - 1, j = col + 1; i > targetRow && j < targetCol; i--, j++) {
                    if (board[row][i].type != PieceType.EMPTY) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}