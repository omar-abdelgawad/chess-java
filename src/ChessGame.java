import user_interface.ChessFrame;
import user_interface.StartFrame;

public class ChessGame {
    private ChessFrame chessFrame;

    public static void main(String[] args) throws Exception {
        new ChessGame();
    }

    ChessGame() {
        chessFrame = new ChessFrame();
        new StartFrame(chessFrame);
    }
}
