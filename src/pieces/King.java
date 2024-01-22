package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * King
 * TODO: implement castling
 */
public class King extends Piece {
    public King(int row, int col, PieceColor color, BoardPanel boardPanel, ImageIcon icon) {
        super(row, col, color, boardPanel, icon);
    }

    @Override
    public boolean isValidMove(int targetRow, int targetCol) {
        Piece[][] board = this.boardPanel.board;
        if (!commonIsValid(targetRow, targetCol)) {
            return false;
        }
        // implement castling
        if (!hasMoved) {
            if (color == PieceColor.WHITE) {
                // short castling
                if (targetRow == this.row && targetCol - this.col == 2) {
                    Piece lowerRightPiece = board[board.length - 1][board[0].length - 1];
                    Piece temPiece = board[board.length - 1][board[0].length - 2];
                    Piece temPiece2 = board[board.length - 1][board[0].length - 3];
                    if (lowerRightPiece instanceof Rook
                            && lowerRightPiece.color == PieceColor.WHITE && !lowerRightPiece.hasMoved
                            && temPiece instanceof EmptyPiece && temPiece2 instanceof EmptyPiece) {
                        return true;
                    }
                }
                // long castling
                else if (targetRow == this.row && targetCol - this.col == -2) {
                    Piece lowerLeftPiece = board[board.length - 1][0];
                    Piece temPiece3 = board[board.length - 1][1];
                    Piece temPiece4 = board[board.length - 1][2];
                    Piece temPiece5 = board[board.length - 1][3];
                    if (lowerLeftPiece instanceof Rook
                            && lowerLeftPiece.color == PieceColor.WHITE && !lowerLeftPiece.hasMoved
                            && temPiece3 instanceof EmptyPiece && temPiece4 instanceof EmptyPiece
                            && temPiece5 instanceof EmptyPiece) {
                        return true;
                    }
                }

            } else {
                if (targetRow == this.row && targetCol - this.col == 2) {
                    Piece upperRightPiece = board[0][board[0].length - 1];
                    Piece temPiece = board[0][board[0].length - 2];
                    Piece temPiece2 = board[0][board[0].length - 3];
                    if (upperRightPiece instanceof Rook
                            && upperRightPiece.color == PieceColor.BLACK && !upperRightPiece.hasMoved
                            && temPiece instanceof EmptyPiece && temPiece2 instanceof EmptyPiece) {
                        return true;
                    }
                } else if (targetRow == this.row && targetCol - this.col == -2) {
                    Piece upperLeftPiece = board[0][0];
                    Piece temPiece3 = board[0][1];
                    Piece temPiece4 = board[0][2];
                    Piece temPiece5 = board[0][3];
                    if (upperLeftPiece instanceof Rook
                            && upperLeftPiece.color == PieceColor.BLACK && !upperLeftPiece.hasMoved
                            && temPiece3 instanceof EmptyPiece && temPiece4 instanceof EmptyPiece
                            && temPiece5 instanceof EmptyPiece) {
                        return true;
                    }
                }
            }
        }
        if (Math.abs(targetRow - this.row) > 1 || Math.abs(targetCol - this.col) > 1) {
            return false;
        }
        return true;
    }
}