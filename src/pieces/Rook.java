package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * Rook
 * TODO: implement short castling
 * TODO: implement long castling
 */
public class Rook extends Piece {
    public Rook(int row, int col, PieceColor color, BoardPanel boardPanel, ImageIcon icon) {
        super(row, col, color, boardPanel, icon);
    }

    @Override
    public boolean isValidMove(int targetRow, int targetCol) {
        if (!commonIsValid(targetRow, targetCol)) {
            return false;
        }
        if (targetRow != this.row && targetCol != this.col) {
            return false;
        }
        if (isBlocked(targetRow, targetCol)) {
            return false;
        }
        return true;
    }

    private boolean isBlocked(int targetRow, int targetCol) {
        Piece[][] board = this.boardPanel.board;
        if (targetRow == this.row) {
            if (targetCol < this.col) {
                for (int i = this.col - 1; i > targetCol; i--) {
                    if (!(board[targetRow][i] instanceof EmptyPiece)) {
                        return true;
                    }
                }
            } else if (targetCol > this.col) {
                for (int i = this.col + 1; i < targetCol; i++) {
                    if (!(board[targetRow][i] instanceof EmptyPiece)) {
                        return true;
                    }
                }
            }
        } else {
            if (targetRow < this.row) {
                for (int i = this.row - 1; i > targetRow; i--) {
                    if (!(board[i][targetCol] instanceof EmptyPiece)) {
                        return true;
                    }
                }
            } else if (targetRow > this.row) {
                for (int i = this.row + 1; i < targetRow; i++) {
                    if (!(board[i][targetCol] instanceof EmptyPiece)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}