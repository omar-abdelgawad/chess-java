package user_interface;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import listeners.TimerListener;

/**
 * Timer
 */
public class Timer extends JPanel {

    private ChessFrame chessFrame;
    private JLabel timerLabel;
    private CountdownTimer countdownTimer;
    private int id;

    public Timer(ChessFrame chessFrame, int id) {
        this.chessFrame = chessFrame;
        this.id = id;
        configureTimer();
        createTimer();

        chessFrame.add(this);
    }

    public void configureTimer() {
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.white);
        // this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setLayout(new BorderLayout());
    }

    public void createTimer() {
        timerLabel = new JLabel("10:00");
        timerLabel.setFont(timerLabel.getFont().deriveFont(25.0f));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.add(timerLabel);
    }

    // public void startTimer() {
    // for (int i = 0; i < 100; i++) {
    // System.out.println(i);
    // timerLabel.setText("00:0" + i);
    // System.out.println(i);
    // try {
    // Thread.sleep(1000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }

    // revalidate();
    // repaint();
    // }
    // }

    public void startTimer(int durationInSeconds) {
        countdownTimer = new CountdownTimer(durationInSeconds);
        countdownTimer.execute();
    }

    public void stopTimer() {
        if (countdownTimer != null && !countdownTimer.isDone()) {
            countdownTimer.cancel(true);
        }
    }

    public void continueTimer() {
        if (countdownTimer != null && countdownTimer.isCancelled()) {
            countdownTimer = new CountdownTimer(countdownTimer.getRemainingTime());
            countdownTimer.execute();
        }
    }

    private void updateTimerLabel(int seconds) {
        int minutes = seconds / 60;
        int remainderSeconds = seconds % 60;
        String time = String.format("%02d:%02d", minutes, remainderSeconds);
        timerLabel.setText(time);
    }

    private class CountdownTimer extends SwingWorker<Void, Integer> {
        private int remainingTime;

        public CountdownTimer(int durationInSeconds) {
            this.remainingTime = durationInSeconds;
        }

        public int getRemainingTime() {
            return remainingTime;
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (int i = remainingTime; i >= 0; i--) {
                Thread.sleep(1000);
                publish(i);
            }
            return null;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            int latestValue = chunks.get(chunks.size() - 1);
            updateTimerLabel(latestValue);
        }

        @Override
        protected void done() {
            // Handle completion, e.g., display a message
            System.out.println("Countdown complete!");
        }
    }

}