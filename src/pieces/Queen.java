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

    public boolean isValidMove(int row, int col) {
        // Piece[][] board = this.boardPanel.board;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.row != row && this.col != col)
                    return false;
                if (this.row != row
                        && this.col != col
                        && this.col + this.row != row + col
                        && this.row - this.col != row - col) {
                    return false;
                }

                // ckeck if other pieces are in the way
                if (isBlocked(this.row, this.col, row, col)) {
                    return false;
                }

            }

        }
        return true;
    }

    private boolean isBlocked(int row, int col, int targetRow, int targetCol) {
        // if(Bishop.isBlocked(row, col, targetRow, targetCol) || Rook.isBlocked(row,
        // col, targetRow, targetCol)){
        // return true;
        // }
        Piece[][] board = this.boardPanel.board;
        // diganol movement
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

        // straight movement
        // moving up the board
        if (targetRow > row) {
            for (int i = row + 1; i < targetRow; i++) {
                if (board[i][col].type != PieceType.EMPTY) {
                    return true;
                }
            }
        }
        // moving down the board
        else if (targetRow < row) {
            for (int i = row - 1; i > targetRow; i--) {
                if (board[i][col].type != PieceType.EMPTY) {
                    return true;
                }
            }
        }
        // moving right
        else if (targetCol > col) {
            for (int i = col + 1; i < targetCol; i++) {
                if (board[row][i].type != PieceType.EMPTY) {
                    return true;
                }
            }
        }
        // moving left
        else if (targetCol < col) {
            for (int i = col - 1; i > targetCol; i--) {
                if (board[row][i].type != PieceType.EMPTY) {
                    return true;
                }
            }
        }
        return false;

    }

}