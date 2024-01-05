package listeners;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JLabel;

import pieces.Piece;
import pieces.Piece.PieceType;
import user_interface.BoardPanel;

/**
 * BoardListener
 */
public class BoardListener extends MouseAdapter {
    private final BoardPanel boardPanel;
    private int firstClickRow = -1;
    private int firstClickCol = -1;

    public BoardListener(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    private Piece getPieceObject(int row, int col) {
        return boardPanel.board[row][col];
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Component clickedComponent = boardPanel.getComponentAt(e.getPoint());

        if (clickedComponent instanceof JLabel) {
            int row = boardPanel.getComponentZOrder(clickedComponent) / boardPanel.cols;
            int col = boardPanel.getComponentZOrder(clickedComponent) % boardPanel.cols;
            // System.out.println(row + " " + col);

            if (firstClickRow == -1 && firstClickCol == -1) {
                if (boardPanel.board[row][col].type == PieceType.EMPTY) {
                    return;
                }
                firstClickRow = row;
                firstClickCol = col;
                // FOR TESTING PURPOSES ONLY (HIGHLIGHTING LEGAL MOVES)
                // boardPanel.setLegalMoveCoordinates(legalMoveCoordinates);
                // for (Point point : getPieceName(row, col).getValidMovesList()) {
                // // System.out.println(point);
                // }
                boardPanel.setLegalMoveCoordinates(getPieceObject(row, col).getValidMoves());
            } else {
                boardPanel.eatPieces(firstClickRow, firstClickCol, row, col);
                firstClickRow = -1;
                firstClickCol = -1;
                boardPanel.setLegalMoveCoordinates(new HashMap<>());
            }
        }

    }

}