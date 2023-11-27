package user_interface;

import javax.swing.JFrame;

// import Board;

/**
 * ChessFrame class that extends JFrame
 */
public class ChessFrame extends JFrame {
    // private Board chessBoard;
    private BoardPanel boardPanel;

    public ChessFrame() {
        super("Chess");
        boardPanel = new BoardPanel();
        System.out.println(boardPanel.getComponents()[0]);
        add(boardPanel);
        System.out.println("boardPanel has been added");

        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}