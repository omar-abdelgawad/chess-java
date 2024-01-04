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
    private static final int width = 1500;
    private static final int height = 1000;
    private BoardPanel boardPanel;
    private Timer timer1;
    private Timer timer2;

    public ChessFrame() {
        super("Chess");
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.gray);
        boardPanel = new BoardPanel();
        this.timer1 = new Timer(this);
        add(boardPanel);
        System.out.println("boardPanel has been added");
        this.timer2 = new Timer(this);

        setMinimumSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}