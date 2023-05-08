package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.model.AbstractPiece;
import com.echecsfantastiques.model.Couleur;
import com.echecsfantastiques.utils.Coord;

public class Cavalier extends AbstractPiece {

    public Cavalier(Couleur couleur, Coord coord) {
        super("Cavalier", couleur, coord);
    }

    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        boolean ret = false;
        int xInit = getCoord().x;
        int yInit = getCoord().y;
        int dx = Math.abs(xFinal - xInit);
        int dy = Math.abs(yFinal - yInit);

        // Déplacement en L (2 cases en diagonale puis 1 case à gauche ou à droite)
        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
            ret = true;
        }

        return ret;
    }
}
