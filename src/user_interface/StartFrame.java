package user_interface;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StartFrame extends JFrame {
    private ChessFrame chessFrame;

    public StartFrame(ChessFrame chessFrame) {
        super("Chess");
        this.chessFrame = chessFrame;
        JButton button = new JButton("Start Double Player Game");
        button.setBounds(100, 100, 300, 300);
        button.addActionListener(e -> {
            dispose();
            this.chessFrame.setVisible(true);
        });
        add(button);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
