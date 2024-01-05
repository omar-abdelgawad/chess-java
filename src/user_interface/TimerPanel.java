package user_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.BorderLayout;

/**
 * Timer
 */
public class TimerPanel extends JPanel {

    private JLabel timerLabel;
    private Timer countdownTimer;
    private int startTimeInSeconds;
    public boolean started = false;
    public String name;

    public TimerPanel(String name, int startTimeInSeconds) {
        this.name = name;
        this.startTimeInSeconds = startTimeInSeconds;
        configureTimer();
        createTimer();
    }

    public void configureTimer() {
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        timerLabel = new JLabel(formatTime(startTimeInSeconds));
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.add(timerLabel);
    }

    public void createTimer() {
        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimeInSeconds--;
                if (startTimeInSeconds >= 0) {
                    timerLabel.setText(formatTime(startTimeInSeconds));
                } else {
                    ((Timer) e.getSource()).stop();
                    timerLabel.setText("Time's up!");
                }
            }
        });
    }

    public void startTimer() {
        if (!started) {
            started = true;
            countdownTimer.start();
        }
    }

    public void stopTimer() {
        if (countdownTimer.isRunning()) {
            countdownTimer.stop();
            started = false;
        }
    }

    public void continueTimer() {
        if (!started) {
            started = true;
            countdownTimer.start();
        }
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainderSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainderSeconds);
    }
}
