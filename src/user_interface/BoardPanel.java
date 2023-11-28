package user_interface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;
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
    private JLabel[][] labels;
    // private PieceColor turn;
    // private Piece selectedPiece;
    // private TileManager tileManager;

    public BoardPanel() {
        setPreferredSize(new Dimension(cols * tileSize, rows * tileSize));
        setBackground(Color.red);
        setLayout(new GridLayout(rows, cols));
        // tileManager = new TileManager(this);
        board = new Piece[rows][cols];
        labels = new JLabel[rows][cols];
        initialize_board();
        drawBoard();
    }

    public void swapTwoPieces(int firstRow, int firstCol, int secondRow, int secondCol) {
        Piece first = board[firstRow][firstCol];
        Piece second = board[secondRow][secondCol];
        board[firstRow][firstCol] = second;
        board[secondRow][secondCol] = first;
        swapTwoLabelsInPanel(getLinearIndex(firstRow, firstCol), getLinearIndex(secondRow, secondCol));
    }

    private int getLinearIndex(int row, int col) {
        return row * cols + col;
    }

    private void swapTwoLabelsInPanel(int firstIndex, int secondIndex) {
        if (firstIndex < 0 || firstIndex >= rows * cols || secondIndex < 0 || secondIndex >= rows * cols) {
            throw new IndexOutOfBoundsException();
        } else if (firstIndex == secondIndex) {
            System.out.println("firstIndex == secondIndex");
            throw new IllegalArgumentException();
        }
        Component first = getComponent(firstIndex);
        Component second = getComponent(secondIndex);
        remove(first);
        remove(second);
        add(second, firstIndex);
        add(first, secondIndex);
        // revalidate();
        // repaint();
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
        pieceMap.put(" ", PieceType.EMPTY);
        assert mockBoard.length == rows;
        assert mockBoard[0].length == cols;
        for (int i = 0; i < mockBoard.length; i++) {
            for (int j = 0; j < mockBoard[i].length; j++) {
                PieceColor color = Character.isUpperCase(mockBoard[i][j].charAt(0)) ? PieceColor.BLACK
                        : PieceColor.WHITE;
                board[i][j] = PieceFactory.createPiece(i, j, color, this, pieceMap.get(mockBoard[i][j].toUpperCase()));
            }
        }

    }

    public void drawBoard() {
        // removeAll();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                ImageIcon icon = board[r][c].icon;
                if (icon != null)
                    icon = new ImageIcon(
                            icon.getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH));
                labels[r][c] = new JLabel(icon);
                add(labels[r][c]);
            }
        }
        // revalidate();
        // repaint();
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