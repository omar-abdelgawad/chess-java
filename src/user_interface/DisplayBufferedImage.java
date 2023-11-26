package user_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DisplayBufferedImage extends JFrame {

    private BufferedImage image;

    public DisplayBufferedImage(BufferedImage image) {
        super("titiles");
        this.image = image;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }

    public static void main(String[] args) {
        // Create a BufferedImage (replace this with your actual image loading logic)
        BufferedImage bufferedImage = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 300, 200);
        g2d.setColor(Color.BLUE);
        g2d.drawString("Hello, BufferedImage!", 50, 100);
        g2d.dispose();

        // Display the BufferedImage
        SwingUtilities.invokeLater(() -> new DisplayBufferedImage(bufferedImage));
    }
}