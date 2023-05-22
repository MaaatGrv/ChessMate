package com.echecsfantastiques.views;

import javax.swing.*;

import com.echecsfantastiques.controllers.ChessGameControler;
import com.echecsfantastiques.controllers.ChessGameControlers;
import com.echecsfantastiques.model.Echiquier;
import com.echecsfantastiques.utils.ChessGame;
import com.echecsfantastiques.utils.Coord;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Console;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener, Observer {
    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
    Echiquier echiquier;
    ChessGameControlers chessGameControler;
    private static final int SQUARE_SIZE = 700 / 8;
    int startX;
    int startY;

    public ChessGameGUI(String name, ChessGameControlers chessGameControler, Dimension boardSize) {
        this.setTitle(name);
        this.chessGameControler = chessGameControler;

        // Use a Layered Pane for this application
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        // Add a chess board to the Layered Pane
        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));

        // Calculate the window's insets
        Insets insets = this.getInsets();
        int boardWidth = boardSize.width - insets.left - insets.right;
        int boardHeight = boardSize.height - insets.top - insets.bottom;

        chessBoard.setPreferredSize(new Dimension(boardWidth, boardHeight));
        chessBoard.setBounds(0, 0, boardWidth, boardHeight);

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel(new BorderLayout());
            chessBoard.add(square);

            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground(i % 2 == 0 ? Color.gray : Color.white);
            else
                square.setBackground(i % 2 == 0 ? Color.white : Color.gray);
        }

        echiquier = new Echiquier();
        List<PieceIHM> piecesIHM = echiquier.getPiecesIHM();
        for (PieceIHM pieceIHM : piecesIHM) {
            for (Coord coord : pieceIHM.getList()) {
                String imgPath = ChessImageProvider.getImageFile(pieceIHM.getTypePiece(), pieceIHM.getCouleur());
                ImageIcon icon = new ImageIcon(imgPath);
                JLabel piece = new JLabel(icon);
                JPanel panel = (JPanel) chessBoard.getComponent(coord.y * 8 + coord.x);
                panel.add(piece);
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (chessPiece == null)
            return;

        chessPiece.setVisible(false);
        Point releasePoint = SwingUtilities.convertPoint(layeredPane, e.getPoint(), chessBoard);
        Component c = chessBoard.findComponentAt(releasePoint);

        if (c instanceof JLabel) {
            Container parent = c.getParent();
            parent.remove(0);
            parent.add(chessPiece);
        } else {
            Container parent = (Container) c;
            parent.add(chessPiece);
        }

        // Put this piece at the bottom of the list
        chessPiece.setVisible(true);

        int endX = releasePoint.x / SQUARE_SIZE;
        int endY = releasePoint.y / SQUARE_SIZE;

        if (echiquier.isMoveOk(startX, startY, endX, endY)) {
            // If the move is valid, make it
            this.chessGameControler.move(new Coord(startX, startY), new Coord(endX, endY));
            // Print the message from the Echiquier to the console
            System.out.println("Le mouvement est valide");
        } else {
            Container parent = (Container) chessBoard.getComponent(startY * 8 + startX);
            parent.add(chessPiece);
            // Print the game state to the console
            System.out.println(echiquier.getMessage());
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        // Remove all pieces from the board
        for (Component square : chessBoard.getComponents()) {
            ((JPanel) square).removeAll();
        }

        // Add pieces to the board at their new positions
        List<PieceIHM> piecesIHM = echiquier.getPiecesIHM();
        for (PieceIHM pieceIHM : piecesIHM) {
            for (Coord coord : pieceIHM.getList()) {
                String imgPath = ChessImageProvider.getImageFile(pieceIHM.getTypePiece(), pieceIHM.getCouleur());
                ImageIcon icon = new ImageIcon(imgPath);
                JLabel piece = new JLabel(icon);
                JPanel panel = (JPanel) chessBoard.getComponent(coord.y * 8 + coord.x);
                panel.add(piece);
            }
        }

        // Redraw the board
        chessBoard.revalidate();
        chessBoard.repaint();
    }

    public void mousePressed(MouseEvent e) {
        chessPiece = null;
        Point relativePoint = SwingUtilities.convertPoint(layeredPane, e.getPoint(), chessBoard);
        Component c = chessBoard.findComponentAt(relativePoint);

        if (c instanceof JPanel)
            return;

        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - relativePoint.x;
        yAdjustment = parentLocation.y - relativePoint.y;
        chessPiece = (JLabel) c;

        // Get piece coordinates
        int x = relativePoint.x / SQUARE_SIZE;
        int y = relativePoint.y / SQUARE_SIZE;

        // Initialise startX et startY ici
        startX = x;
        startY = y;

        // Check if the piece belongs to the current player
        if (echiquier.getPieceColor(x, y) != echiquier.getColorCurrentPlayer()) {
            chessPiece = null; // This will prevent the piece from being moved
            return;
        }

        chessPiece.setLocation(relativePoint.x + xAdjustment, relativePoint.y + yAdjustment);
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
    }

    public void mouseDragged(MouseEvent e) {
        if (chessPiece == null)
            return;

        Point dragPoint = SwingUtilities.convertPoint(layeredPane, e.getPoint(), chessBoard);
        chessPiece.setLocation(dragPoint.x + xAdjustment, dragPoint.y + yAdjustment);
    }

    // Empty implementations of unused event methods
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {

        ChessGame chessGame;
        ChessGameControlers chessGameControler;
        JFrame frame;
        Dimension dim;

        dim = new Dimension(700, 700);

        chessGame = new ChessGame();
        chessGameControler = new ChessGameControler(chessGame);

        frame = new ChessGameGUI("Jeu d'échec", chessGameControler, dim);

        frame.pack();

        chessGame.addObserver((Observer) frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(600, 10);
        frame.setPreferredSize(dim);
        frame.setVisible(true);
    }
}
