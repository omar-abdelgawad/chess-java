import user_interface.ChessFrame;

public class ChessGame {
    public static void main(String[] args) throws Exception {
        ChessGame game = new ChessGame();
        game.run();
    }

    ChessGame() {
        new ChessFrame();
    }

    void run() {
        ;
    }
}