package user_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

// import Board;

/**
 * ChessFrame class that extends JFrame
 */
public class ChessFrame extends JFrame {
    private static final int width = 1000;
    private static final int height = width;
    private BoardPanel boardPanel;

    public ChessFrame() {
        super("Chess");
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.gray);
        boardPanel = new BoardPanel();
        add(boardPanel);
        System.out.println("boardPanel has been added");

        setMinimumSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}