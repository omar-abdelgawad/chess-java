package listeners;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

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

    @Override
    public void mouseClicked(MouseEvent e) {

        Component clickedComponent = boardPanel.getComponentAt(e.getPoint());

        if (clickedComponent instanceof JLabel) {
            int row = boardPanel.getComponentZOrder(clickedComponent) / boardPanel.cols;
            int col = boardPanel.getComponentZOrder(clickedComponent) % boardPanel.cols;
            System.out.println(row + " " + col);

            if (firstClickRow == -1 && firstClickCol == -1) {
                if (boardPanel.board[row][col].type == PieceType.EMPTY) {
                    return;
                }
                firstClickRow = row;
                firstClickCol = col;
            } else {
                boardPanel.eatPieces(firstClickRow, firstClickCol, row, col);
                firstClickRow = -1;
                firstClickCol = -1;
            }
        }

    }

}