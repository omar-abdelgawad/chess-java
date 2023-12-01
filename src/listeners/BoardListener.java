package listeners;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    // FOR TESTING PURPOSES ONLY (HIGHLIGHTING LEGAL MOVES)
    private static HashMap<String, ArrayList<Point>> legalMoveCoordinates = new HashMap<>();

    static {
        legalMoveCoordinates.put("EMPTY", new ArrayList<>());
        legalMoveCoordinates.put("ATTACK", new ArrayList<>());
        legalMoveCoordinates.get("EMPTY").add(new Point(0, 0));
        legalMoveCoordinates.get("EMPTY").add(new Point(1, 1));
        legalMoveCoordinates.get("EMPTY").add(new Point(2, 2));
        legalMoveCoordinates.get("ATTACK").add(new Point(3, 3));
        legalMoveCoordinates.get("ATTACK").add(new Point(4, 4));
        legalMoveCoordinates.get("ATTACK").add(new Point(5, 5));
    }

    // FOR TESTING PURPOSES ONLY (HIGHLIGH)

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
                // FOR TESTING PURPOSES ONLY (HIGHLIGHTING LEGAL MOVES)
                boardPanel.setLegalMoveCoordinates(legalMoveCoordinates);
            } else {
                boardPanel.eatPieces(firstClickRow, firstClickCol, row, col);
                firstClickRow = -1;
                firstClickCol = -1;
                boardPanel.setLegalMoveCoordinates(new HashMap<>());
            }
        }

    }

}