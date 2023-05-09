package com.echecsfantastiques.model;

import com.echecsfantastiques.utils.BoardGames;
import com.echecsfantastiques.utils.Coord;
import com.echecsfantastiques.views.PieceIHM;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Echiquier implements BoardGames {

    private Jeu jeuBlanc;
    private Jeu jeuNoir;
    private Jeu jeuCourant;
    private Jeu jeuNonCourant;
    private String message;

    public Echiquier() {
        jeuBlanc = new Jeu(Couleur.BLANC);
        jeuNoir = new Jeu(Couleur.NOIR);
        jeuCourant = jeuBlanc;
        jeuNonCourant = jeuNoir;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
        if (!jeuCourant.isPieceHere(xInit, yInit)) {
            setMessage("Aucune pièce du joueur courant à cette position");
            return false;
        }

        Couleur pieceColor = jeuCourant.getPieceColor(xInit, yInit);
        if (pieceColor != jeuCourant.getCouleur()) {
            setMessage("La pièce sélectionnée n'appartient pas au joueur courant");
            return false;
        }

        if (jeuCourant.isPieceHere(xFinal, yFinal) || jeuNonCourant.isPieceHere(xFinal, yFinal)) {
            setMessage("Une pièce se trouve déjà à la position finale");
            return false;
        }

        Pieces piece = jeuCourant.findPiece(xInit, yInit);
        boolean isMoveValid = piece.isMoveOk(xFinal, yFinal, false, false); // Les deux derniers arguments sont pour
                                                                            // l'instant fixés à false.
        if (!isMoveValid) {
            setMessage("Le mouvement n'est pas valide pour cette pièce");
        }
        return isMoveValid;
    }

    @Override
    public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
        boolean moved = jeuCourant.move(xInit, yInit, xFinal, yFinal);
        if (moved) {
            switchJoueur();
        }
        return moved;
    }

    public void switchJoueur() {
        Jeu temp = jeuCourant;
        jeuCourant = jeuNonCourant;
        jeuNonCourant = temp;
    }

    @Override
    public boolean isEnd() {
        // Implémentez la logique pour déterminer si le jeu est terminé
        return false;
    }

    @Override
    public Couleur getColorCurrentPlayer() {
        return jeuCourant.getCouleur();
    }

    @Override
    public Couleur getPieceColor(int x, int y) {
        if (jeuCourant.isPieceHere(x, y)) {
            return jeuCourant.getPieceColor(x, y);
        } else if (jeuNonCourant.isPieceHere(x, y)) {
            return jeuNonCourant.getPieceColor(x, y);
        }
        return null;
    }

    public List<PieceIHM> getPiecesIHM() {
        List<PieceIHM> list = new LinkedList<PieceIHM>();

        // Combine les listes de pièces des jeux blanc et noir
        List<Pieces> pieces = new ArrayList<>(jeuBlanc.getPieces());
        pieces.addAll(jeuNoir.getPieces());

        for (Pieces piece : pieces) {
            if (piece.getX() != -1) {
                PieceIHM newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(), piece.getCouleur());
                newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
                list.add(newPieceIHM);
            }
        }

        return list;
    }

    @Override
    public String toString() {
        return "Echiquier:\n" + jeuBlanc.toString() + "\n" + jeuNoir.toString();
    }

    public static void main(String[] args) {
        Echiquier echiquier = new Echiquier();
        System.out.println(echiquier);
    }
}
