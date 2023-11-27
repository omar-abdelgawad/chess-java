package user_interface;

import java.awt.Dimension;

import javax.swing.JFrame;

// import Board;

/**
 * ChessFrame class that extends JFrame
 */
public class ChessFrame extends JFrame {
    // private Board chessBoard;
    private static final int width = 800;
    private static final int height = width;
    private BoardPanel boardPanel;

    public ChessFrame() {
        super("Chess");
        boardPanel = new BoardPanel();
        System.out.println(boardPanel.getComponents()[0]);
        add(boardPanel);
        System.out.println("boardPanel has been added");

        setMinimumSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}