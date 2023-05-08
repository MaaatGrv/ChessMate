package com.echecsfantastiques.model;

import com.echecsfantastiques.utils.ChessPiecesFactory;
import com.echecsfantastiques.utils.Coord;

import java.util.List;

public class Jeu {

    private List<Pieces> pieces;

    public Jeu(Couleur couleur) {
        pieces = ChessPiecesFactory.newPieces(couleur);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pieces piece : pieces) {
            sb.append(piece.toString()).append("\n");
        }
        return sb.toString();
    }

    private Pieces findPiece(int x, int y) {
        for (Pieces piece : pieces) {
            if (piece.getCoord().x == x && piece.getCoord().y == y) {
                return piece;
            }
        }
        return null;
    }

    public boolean isPieceHere(int x, int y) {
        return findPiece(x, y) != null;
    }

    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
        Pieces piece = findPiece(xInit, yInit);
        if (piece == null) {
            return false;
        }
        return piece.isMoveOk(xFinal, yFinal, false, false); // Les deux derniers arguments sont pour l'instant fixés à
                                                             // false.
    }

    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        Pieces piece = findPiece(xInit, yInit);
        if (piece == null) {
            return false;
        }
        if (piece.isMoveOk(xFinal, yFinal, false, false)) {
            piece.move(new Coord(xFinal, yFinal)); // Corrigez l'appel à la méthode move().
            return true;
        }
        return false;
    }

    public Couleur getPieceColor(int x, int y) {
        Pieces piece = findPiece(x, y);
        if (piece == null) {
            return null;
        }
        return piece.getCouleur();
    }

    public String getPieceType(int x, int y) {
        Pieces piece = findPiece(x, y);
        if (piece == null) {
            return null;
        }
        return piece.getClass().getSimpleName();
    }

    public Couleur getCouleur() {
        return pieces.get(0).getCouleur();
    }

    public static void main(String[] args) {
        Jeu jeuBlanc = new Jeu(Couleur.BLANC);
        Jeu jeuNoir = new Jeu(Couleur.NOIR);

        System.out.println("Pièces blanches:");
        System.out.println(jeuBlanc.toString());

        System.out.println("Pièces noires:");
        System.out.println(jeuNoir.toString());
    }
}
