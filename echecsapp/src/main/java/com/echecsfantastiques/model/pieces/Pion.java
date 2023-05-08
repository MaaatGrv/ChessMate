package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.model.AbstractPiece;
import com.echecsfantastiques.model.Couleur;
import com.echecsfantastiques.utils.Coord;

public class Pion extends AbstractPiece {

    public Pion(Couleur couleur, Coord coord) {
        super("Pion", couleur, coord);
    }

    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        int xInit = getCoord().x;
        int yInit = getCoord().y;

        // Si le pion est noir
        if (getCouleur() == Couleur.NOIR) {
            if (yInit == 1) { // Premier déplacement du pion noir
                return (xFinal == xInit && (yFinal == yInit + 1 || yFinal == yInit + 2));
            } else { // Déplacements suivants du pion noir
                return (xFinal == xInit && yFinal == yInit + 1);
            }
        }

        // Si le pion est blanc
        if (getCouleur() == Couleur.BLANC) {
            if (yInit == 6) { // Premier déplacement du pion blanc
                return (xFinal == xInit && (yFinal == yInit - 1 || yFinal == yInit - 2));
            } else { // Déplacements suivants du pion blanc
                return (xFinal == xInit && yFinal == yInit - 1);
            }
        }

        return false;
    }
}
