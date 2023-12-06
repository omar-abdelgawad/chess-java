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
        Piece[][] board = this.boardPanel.board;

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
                if (board[i][j].color == this.color && board[i][j].type != PieceType.EMPTY) {
                    if (this.row == row) {
                        if (this.col < col) {
                            for (int k = 0; k < col; k++) {
                                if (this.col == k) {
                                    continue;
                                }
                                if (board[i][k].type != PieceType.EMPTY) {
                                    return false;
                                }
                            }
                        }

                    } else {
                        if (this.row < row) {
                            for (int k = 0; k < row; k++) {
                                if (this.row == k) {
                                    continue;

                                }
                                if (board[k][j].type != PieceType.EMPTY) {
                                    return false;
                                }
                            }
                        }

                    }

                }

            }

        }
        return true;
    }
}