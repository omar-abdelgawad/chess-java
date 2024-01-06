package pieces;

import javax.swing.ImageIcon;

import user_interface.BoardPanel;

/**
 * PieceFactory
 */

public class PieceFactory {
    private static ImageIcon w_bishop = new ImageIcon("res/tile/white/w_bishop_1x_ns.png");
    private static ImageIcon w_king = new ImageIcon("res/tile/white/w_king_1x_ns.png");
    private static ImageIcon w_knight = new ImageIcon("res/tile/white/w_knight_1x_ns.png");
    private static ImageIcon w_pawn = new ImageIcon("res/tile/white/w_pawn_1x_ns.png");
    private static ImageIcon w_queen = new ImageIcon("res/tile/white/w_queen_1x_ns.png");
    private static ImageIcon w_rook = new ImageIcon("res/tile/white/w_rook_1x_ns.png");
    private static ImageIcon b_bishop = new ImageIcon("res/tile/black/b_bishop_1x_ns.png");
    private static ImageIcon b_king = new ImageIcon("res/tile/black/b_king_1x_ns.png");
    private static ImageIcon b_knight = new ImageIcon("res/tile/black/b_knight_1x_ns.png");
    private static ImageIcon b_pawn = new ImageIcon("res/tile/black/b_pawn_1x_ns.png");
    private static ImageIcon b_queen = new ImageIcon("res/tile/black/b_queen_1x_ns.png");
    private static ImageIcon b_rook = new ImageIcon("res/tile/black/b_rook_1x_ns.png");

    public static Piece createPiece(int row, int col, Piece.PieceColor color, BoardPanel boardPanel,
            Piece.PieceType type) {
        switch (type) {
            case PAWN:
                ImageIcon b_or_w_pawn = color == Piece.PieceColor.WHITE ? w_pawn : b_pawn;
                return new Pawn(row, col, color, boardPanel, type, b_or_w_pawn);
            case ROOK:
                ImageIcon b_or_w_rook = color == Piece.PieceColor.WHITE ? w_rook : b_rook;
                return new Rook(row, col, color, boardPanel, type, b_or_w_rook);
            case KNIGHT:
                ImageIcon b_or_w_knight = color == Piece.PieceColor.WHITE ? w_knight : b_knight;
                return new Knight(row, col, color, boardPanel, type, b_or_w_knight);
            case BISHOP:
                ImageIcon b_or_w_bishop = color == Piece.PieceColor.WHITE ? w_bishop : b_bishop;
                return new Bishop(row, col, color, boardPanel, type, b_or_w_bishop);
            case QUEEN:
                ImageIcon b_or_w_queen = color == Piece.PieceColor.WHITE ? w_queen : b_queen;
                return new Queen(row, col, color, boardPanel, type, b_or_w_queen);
            case KING:
                ImageIcon b_or_w_king = color == Piece.PieceColor.WHITE ? w_king : b_king;
                return new King(row, col, color, boardPanel, type, b_or_w_king);
            case EMPTY:
                return new EmptyPiece(row, col, type);
            default:
                throw new IllegalArgumentException("Invalid PieceType");

        }
    }
}