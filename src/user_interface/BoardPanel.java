package user_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * BoardPanel
 */
public class BoardPanel extends JPanel {
    public final int rows = 8;
    public final int cols = 8;
    public final int tileSize = 100;
    private TileManager tileManager;

    public BoardPanel() {
        setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));
        setBackground(Color.red);
        setLayout(new GridLayout(rows, cols));
        // tileManager = new TileManager(this);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                g2.setColor((i + j) % 2 == 0 ? Color.white : Color.black);
                g2.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
            }
        }
    }
}