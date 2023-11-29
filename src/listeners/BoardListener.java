package listeners;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import user_interface.BoardPanel;

/**
 * BoardListener
 */
public class BoardListener extends MouseAdapter {
    private final BoardPanel boardPanel;

    public BoardListener(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Component clickedComponent = boardPanel.getComponentAt(e.getPoint());

        if (clickedComponent instanceof JLabel) {
            int row = boardPanel.getComponentZOrder(clickedComponent) / boardPanel.cols;
            int col = boardPanel.getComponentZOrder(clickedComponent) % boardPanel.cols;

            boardPanel.eatPieces(0, 0, row, col);
        }

        // You can use clickedLabel or extract more information as needed

    }

}