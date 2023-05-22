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
        boolean res = true;

        // Bonne exemple SRP
        if (!(0 <= xFinal && xFinal <= 7 && 0 <= yFinal && yFinal <= 7) || // Si position pas dans le plateau
                (this.jeuCourant.findPiece(xFinal, yFinal) != null) || // ou une pièce est déjà sur la position finale
                (xFinal == xInit && yFinal == yInit) // Si la position finale est la même qu'initialement
        ) {
            res = false;
        }

        // if (this.jeuNonCourant.findPiece(xFinal, yFinal) != null) { // Si il n'y a
        // pas de pièce du jeu non courant
        // setMessage("Il y a une pièce du jeu non courant sur la position finale");
        // res = false;

        // } else {
        // setMessage("Déplacement impossible1");
        // res = false;
        // }

        if ((this.jeuCourant.isMoveOk(xInit, yInit, xFinal, yFinal))) { // Si le mouvement est autorisé par le jeu
            res = true;
        } else {
            setMessage("Mouvement illégal de la pièce");
            res = false;
        }

        return res;

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
