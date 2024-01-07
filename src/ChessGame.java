import user_interface.ChessFrame;
import user_interface.StartFrame;

public class ChessGame {
    private ChessFrame chessFrame;
    private StartFrame startFrame;

    public static void main(String[] args) throws Exception {
        ChessGame game = new ChessGame();
    }

    ChessGame() {
        chessFrame = new ChessFrame();
        startFrame = new StartFrame(chessFrame);
    }

}
