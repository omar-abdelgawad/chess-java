import user_interface.ChessFrame;

public class ChessGame {
    private ChessFrame chessFrame;

    public static void main(String[] args) throws Exception {
        ChessGame game = new ChessGame();
        game.run();
    }

    ChessGame() {
        chessFrame = new ChessFrame();
    }

    void run() {
        ;
    }
}