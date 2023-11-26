package user_interface;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * TileManager
 */
public class TileManager {

    ChessPanel chessPanel;
    Tile[] tiles;

    public TileManager(ChessPanel chessPanel) {
        this.chessPanel = chessPanel;
        tiles = new Tile[2];
        getTileImage();
        // draw();
    }

    public void getTileImage() {
        System.out.println("getTileImage method");
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(new File("res/tile/square/teez1.png"));
            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(new File("res/tile/square/teez2.png"));
        } catch (IOException e) {
            System.out.println("You have fucked up in image loading");
        }
    }

    public void draw() {
        System.out.println("draw method activated");
        for (int i = 0; i < chessPanel.rows; i++) {
            for (int j = 0; j < chessPanel.cols; j++) {
                int tilenum = (i + j) % 2;
                JLabel tile = new JLabel(new ImageIcon(tiles[tilenum].image));
                chessPanel.add(tile);
            }
        }
    }
}