package listeners;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JLabel;

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

            if (firstClickRow == -1 && firstClickCol == -1) {
                if (boardPanel.board[row][col].color != boardPanel.turn) {
                    System.out.println("It is currently " + boardPanel.turn + "'s turn " + "can't play with "
                            + boardPanel.board[row][col].color + " " + "pieces");
                    return;
                }
                firstClickRow = row;
                firstClickCol = col;
                boardPanel.setLegalMoveCoordinates(boardPanel.board[row][col].getValidMoves());
            } else {
                // if the second click is on the same color, reset the first click
                if (boardPanel.board[row][col].color == boardPanel.board[firstClickRow][firstClickCol].color) {
                    firstClickRow = row;
                    firstClickCol = col;
                    boardPanel.setLegalMoveCoordinates(boardPanel.board[row][col].getValidMoves());
                } else {
                    // make sure the move is inside the legal moves
                    if (!boardPanel.board[firstClickRow][firstClickCol].getValidMovesList()
                            .contains(new Point(row, col))) {
                        System.out.println("Illegal move, Please choose one of the highlighted moves");
                    } else {
                        boardPanel.eatPieces(firstClickRow, firstClickCol, row, col);
                    }
                    firstClickRow = -1;
                    firstClickCol = -1;
                    boardPanel.setLegalMoveCoordinates(new HashMap<>());
                }
            }
        }

    }

}