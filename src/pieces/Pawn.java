package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * Pawn
 * TODO: implement En Passant
 * TODO: upgrading upon reaching 8th rank
 */

public class Pawn extends Piece {
    public Pawn(int row, int col, PieceColor color, BoardPanel boardPanel, PieceType type, ImageIcon icon) {
        super(row, col, color, boardPanel, type, icon);
    }

    public boolean isValidMove(int targetRow, int targetCol) {
        Piece[][] board = this.boardPanel.board;
        if (!commonIsValid(targetRow, targetCol)) {
            return false;
        }
        if (this.color == PieceColor.WHITE) {
            // if its first move, can move 2 spaces
            if (!hasMoved && targetRow == (this.row - 2) && targetCol == this.col) {
                if (board[this.row - 1][this.col].type == PieceType.EMPTY
                        && board[this.row - 2][this.col].type == PieceType.EMPTY) {
                    return true;
                }
                return false;
            }
            // can't move backwards
            if (targetRow != this.row - 1) {
                return false;
            }
            // leave only three cases: move forward 1, capture left, capture right
            if (Math.abs(targetCol - this.col) > 1) {
                return false;
            }
            // if changing column, must be capturing
            if (targetCol != this.col && board[targetRow][targetCol].type == PieceType.EMPTY) {
                return false;
            }
            // else must be non capturing
            if (targetCol == this.col && board[targetRow][targetCol].type != PieceType.EMPTY) {
                return false;
            }
        } else {
            // if its first move, can move 2 spaces
            if (!hasMoved && targetRow == (this.row + 2) && targetCol == this.col) {
                if (board[this.row + 1][this.col].type == PieceType.EMPTY
                        && board[this.row + 2][this.col].type == PieceType.EMPTY) {
                    return true;
                }
                return false;
            }
            // can't move backwards
            if (targetRow != this.row + 1) {
                return false;
            }
            // leave only three cases: move forward 1, capture left, capture right
            if (Math.abs(targetCol - this.col) > 1) {
                return false;
            }
            // if changing column, must be capturing
            if (targetCol != this.col && board[targetRow][targetCol].type == PieceType.EMPTY) {
                return false;
            }
            // else must be non capturing
            if (targetCol == this.col && board[targetRow][targetCol].type != PieceType.EMPTY) {
                return false;
            }
        }
        return true;
    }

}