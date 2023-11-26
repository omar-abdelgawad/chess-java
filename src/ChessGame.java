import javax.swing.JFrame;
import user_interface.ChessFrame;

public class ChessGame {
    private ChessFrame chessFrame;

    public static void main(String[] args) throws Exception {
        ChessGame game = new ChessGame();
    }

    ChessGame() {
        chessFrame = new ChessFrame();
    }
}
