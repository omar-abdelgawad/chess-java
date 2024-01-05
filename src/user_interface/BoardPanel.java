package user_interface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieces.EmptyPiece;
import pieces.Piece;
import pieces.PieceFactory;
import pieces.Piece.MoveType;
import pieces.Piece.PieceColor;
import pieces.Piece.PieceType;

import listeners.BoardListener;

/**
 * BoardPanel
 */

public class BoardPanel extends JPanel {
    public final int rows = 8;
    public final int cols = 8;
    public final int tileSize = 100;
    public Piece[][] board;
    private JLabel[][] labels;
    private final HashMap<MoveType, ArrayList<Point>> legalMoveCoordinates = new HashMap<>();
    public PieceColor turn = PieceColor.WHITE;

    public BoardPanel() {
        setPreferredSize(new Dimension(cols * tileSize, rows * tileSize)); // size
        setBackground(Color.red);
        setLayout(new GridLayout(rows, cols));
        board = new Piece[rows][cols];
        labels = new JLabel[rows][cols];
        initialize_board();
        drawBoardLabels();
        this.addMouseListener(new BoardListener(this));
    }

    private int getLinearIndex(int row, int col) {
        return row * cols + col;
    }

    public void setLegalMoveCoordinates(HashMap<MoveType, ArrayList<Point>> legalMoveCorrdinates) {
        this.legalMoveCoordinates.clear();
        this.legalMoveCoordinates.putAll(legalMoveCorrdinates);
        repaint();
    }

    private void eatPiecesLabel(int firstIndex, int secondIndex) {
        if (firstIndex < 0 || firstIndex >= rows * cols || secondIndex < 0 || secondIndex >= rows * cols) {
            throw new IndexOutOfBoundsException();
        } else if (firstIndex == secondIndex) {
            System.out.println("Throwing exception because piece can't eat itself");
            throw new IllegalArgumentException();
        }
        Component first = getComponent(firstIndex);
        Component second = getComponent(secondIndex);
        remove(first);
        remove(second);
        if (secondIndex < firstIndex) {
            add(first, secondIndex);
            add(new JLabel(new ImageIcon()), firstIndex);
        } else {
            add(new JLabel(new ImageIcon()), firstIndex);
            add(first, secondIndex);
        }

        revalidate();
        // repaint();
    }

    /**
     * Piece at (row1, col1) eats piece at (row2, col2)
     * Also denotes a turn has passed.
     * 
     * @param row1 row of piece that is eating
     * @param col1 col of piece that is eating
     * @param row2 row of piece to be eaten
     * @param col2 col of piece to be eaten
     */
    public void eatPieces(int row1, int col1, int row2, int col2) {
        board[row2][col2] = board[row1][col1];
        board[row2][col2].row = row2;
        board[row2][col2].col = col2;
        board[row2][col2].hasMoved = true;
        // replace eaten piece with empty piece
        board[row1][col1] = new EmptyPiece(row1, col1, PieceType.EMPTY);
        eatPiecesLabel(getLinearIndex(row1, col1), getLinearIndex(row2, col2));
        this.turn = turn.toggle();
    }

    private void initialize_board() {
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

    private void drawBoardLabels() {
        // removeAll();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                ImageIcon icon = board[r][c].icon;
                if (icon != null)
                    icon = new ImageIcon(
                            icon.getImage().getScaledInstance(tileSize - 10, tileSize - 10,
                                    Image.SCALE_SMOOTH));
                labels[r][c] = new JLabel(icon);
                add(labels[r][c]);
            }
        }
        // revalidate();
        // repaint();
    }

    private void paintLegalEmptyMoves(Graphics g, Color color, ArrayList<Point> legalMoves) {
        if (legalMoves == null) {
            return;
        }
        g.setColor(color);
        for (Point point : legalMoves) {
            int row = point.x * tileSize;
            int col = point.y * tileSize;

            g.fillOval(col + tileSize / 4, row + tileSize / 4, tileSize / 2, tileSize / 2);
        }
    }

    private void paintLegalAttackMoves(Graphics g, Color color, ArrayList<Point> legalMoves) {
        if (legalMoves == null) {
            return;
        }
        g.setColor(color);
        for (Point point : legalMoves) {
            int row = point.x * tileSize;
            int col = point.y * tileSize;

            g.fillRect(col, row, tileSize, tileSize);
        }
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

        paintLegalEmptyMoves(g, Color.lightGray, legalMoveCoordinates.get(MoveType.EMPTY));
        paintLegalAttackMoves(g, Color.red, legalMoveCoordinates.get(MoveType.ATTACK));
    }
}