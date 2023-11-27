package user_interface;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * TileManager
 */
public class TileManager {

    BoardPanel boardPanel;
    Tile[] tiles;

    public TileManager(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
        tiles = new Tile[2];
        getTileImage();
        draw();
    }

    public void getTileImage() {
        System.out.println("getTileImage method");
        try {
            tiles[0] = new Tile();
            tiles[0].path = "res/tile/square/square gray light _svg.png";
            tiles[1] = new Tile();
            tiles[1].path = "res/tile/square/square gray dark _svg.png";
        } catch (Exception e) {
            System.out.println("You have fucked up in image loading");
        }
    }

    public void draw() {
        System.out.println("draw method activated");
        for (int i = 0; i < boardPanel.rows; i++) {
            for (int j = 0; j < boardPanel.cols; j++) {
                int tilenum = (i + j) % 2;
                // add the image at tiles[tilenum] to the boardPanel grid layout
                ImageIcon icon = new ImageIcon(tiles[tilenum].path);
                boardPanel.add(new JLabel(icon));
            }
        }
    }
}