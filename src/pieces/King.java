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
        // Check if the new position is one of the valid moves for a king
        if ((this.row == row - 1 && this.col == col)
                || (this.row == row + 1 && this.col == col)
                || (this.col == col + 1 && this.row == row)
                || (this.col == col - 1 && this.row == row)
                || (this.row == row - 1 && this.col == col - 1)
                || (this.row == row + 1 && this.col == col + 1)
                || (this.row == row - 1 && this.col == col + 1)
                || (this.row == row + 1 && this.col == col - 1)) {
    
            // Check if other pieces are in the way
            if (isBlocked(this.row, this.col, row, col)) {
                return false;
            }
    
            return true;
        }
    
        // If none of the conditions is true, the move is invalid
        return false;
    }
    

    private boolean isBlocked(int row, int col, int targetRow, int targetCol) {
        Piece[][] board = this.boardPanel.board;
        if (board[targetCol][targetCol].type != PieceType.EMPTY || board[targetCol][targetCol].color == this.color) {
            return true;
        }
        return false;
    }
}