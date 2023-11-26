package user_interface;

import javax.swing.JFrame;

// import Board;

/**
 * ChessFrame class that extends JFrame
 */
public class ChessFrame extends JFrame {
    // private Board chessBoard;
    private ChessPanel chessPanel;

    public ChessFrame() {
        super("Chess");
        chessPanel = new ChessPanel();
        System.out.println(chessPanel.getComponents()[0]);
        add(chessPanel);
        System.out.println("ChessPanel has been added");

        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}