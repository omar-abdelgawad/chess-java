package user_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import utils.MoveSoundPlayer;

/**
 * ChessFrame class that extends JFrame
 */
public class ChessFrame extends JFrame {
        private static final int width = 1500;
        private static final int height = 1000;
        private BoardPanel boardPanel;
        private Clock gameClock;
        private MoveSoundPlayer moveSoundPlayer;

        public ChessFrame() {
                super("Chess");
                setLayout(new GridBagLayout());
                getContentPane().setBackground(Color.gray);

                moveSoundPlayer = MoveSoundPlayer.getInstance();
                this.gameClock = new Clock();
                add(gameClock.timer1);
                boardPanel = new BoardPanel(gameClock, moveSoundPlayer);
                add(boardPanel);
                add(gameClock.timer2);

                setMinimumSize(new Dimension(width, height));
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public void close() {
                moveSoundPlayer.close();
                dispose();
        }
}