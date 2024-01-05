package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import user_interface.BoardPanel;
import user_interface.ChessFrame;
import user_interface.Timer;

/**
 * TimerListener
 */
public class TimerListener extends MouseAdapter {

    BoardPanel boardPanel;
    Timer timer1;
    Timer timer2;

    public TimerListener(Timer timer1, Timer timer2, BoardPanel boardPanel) {
        this.timer1 = timer1;
        this.timer2 = timer2;
        this.boardPanel = boardPanel;
    }

    public void startTimer() {
        timer1.startTimer(600);
        timer2.startTimer(600);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        startTimer();
    }

}