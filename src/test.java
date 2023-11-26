import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import user_interface.DisplayBufferedImage;

/**
 * test
 */
public class test {
    static BufferedImage img;
    DisplayBufferedImage disp;

    public static void main(String[] args) {
        try {
            img = ImageIO.read(new FileInputStream("res/tile/square/zby.jpeg"));
            System.out.println(img.getData());

        } catch (Exception e) {
            System.out.println(e);
        }
        test t = new test();
    }

    test() {
        disp = new DisplayBufferedImage(img);
    }
}