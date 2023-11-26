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
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        chessPanel = new ChessPanel();
        add(chessPanel);
        System.out.println("ChessPanel has been added");
    }
}