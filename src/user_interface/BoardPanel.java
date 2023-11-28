package user_interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import pieces.Piece;
import pieces.PieceFactory;
import pieces.Piece.PieceColor;
import pieces.Piece.PieceType;

/**
 * BoardPanel
 */
public class BoardPanel extends JPanel {
    public final int rows = 8;
    public final int cols = 8;
    public final int tileSize = 100;
    private Piece[][] board;
    private TileManager tileManager;

    public BoardPanel() {
        setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));
        setBackground(Color.red);
        setLayout(new GridLayout(rows, cols));
        // tileManager = new TileManager(this);
        board = new Piece[rows][cols];
        initialize_board();
        drawBoard();
    }

    public void initialize_board() {
        String[][] mockBoard = {
                { "R", "N", "B", "Q", "K", "B", "N", "R" },
                { "P", "P", "P", "P", "P", "P", "P", "P" },
                { " ", " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " " },
                { "p", "p", "p", "p", "p", "p", "p", "p" },
                { "r", "n", "b", "q", "k", "b", "n", "r" } };
        HashMap<String, PieceType> pieceMap = new HashMap<String, PieceType>();
        pieceMap.put("R", PieceType.ROOK);
        pieceMap.put("N", PieceType.KNIGHT);
        pieceMap.put("B", PieceType.BISHOP);
        pieceMap.put("Q", PieceType.QUEEN);
        pieceMap.put("K", PieceType.KING);
        pieceMap.put("P", PieceType.PAWN);
        assert mockBoard.length == rows;
        assert mockBoard[0].length == cols;
        for (int i = 0; i < mockBoard.length; i++) {
            for (int j = 0; j < mockBoard[i].length; j++) {
                PieceColor color = Character.isUpperCase(mockBoard[i][j].charAt(0)) ? PieceColor.BLACK
                        : PieceColor.WHITE;
                board[i][j] = PieceFactory.createPiece(i, j, color, this, pieceMap.get(mockBoard[i][j]));
            }
        }

    }

    public void drawBoard() {
        removeAll();
        // JLabel label = new JLabel();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                JLabel label = new JLabel(board[r][c].icon);
                add(label);
            }
        }
        revalidate();
        repaint();
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(Piece piece, int row, int col) {
        board[row][col] = piece;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                g2.setColor((i + j) % 2 == 0 ? Color.white : Color.black);
                g2.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
            }
        }
    }
}