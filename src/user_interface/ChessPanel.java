package user_interface;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * ChessPanel
 */
public class ChessPanel extends JPanel {
    public final static int rows = 8;
    public final static int cols = 8;
    private TileManager tileManager;

    public ChessPanel() {
        super();
        this.setBackground(Color.black);
        setLayout(new GridLayout(8, 8));
        tileManager = new TileManager(this);
    }
}