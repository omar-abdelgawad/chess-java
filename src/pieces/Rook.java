package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * Rook
 * TODO: impliment short castling
 * TODO: impliment long castling
 */
public class Rook extends Piece {
    public Rook(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type, ImageIcon icon) {
        super(row, col, color, boardPanel, type, icon);
    }

    public boolean isValidMove(int row, int col) {
        // Piece[][] board = this.boardPanel.board;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.row != row && this.col != col)
                    return false;

                // ckeck if other pieces are in the way
                if (isBlocked(this.row, this.col, row, col)) {
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