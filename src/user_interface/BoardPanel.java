package user_interface;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * BoardPanel
 */
public class BoardPanel extends JPanel {
    public final static int rows = 8;
    public final static int cols = 8;
    private TileManager tileManager;

    public BoardPanel() {
        super();
        // this.setBackground(Color.red);
        setLayout(new GridLayout(rows, cols));
        tileManager = new TileManager(this);
    }
}