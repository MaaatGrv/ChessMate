package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.model.AbstractPiece;
import com.echecsfantastiques.model.Couleur;
import com.echecsfantastiques.utils.Coord;

public class Tour extends AbstractPiece {

    public Tour(Couleur couleur, Coord coord) {
        super("Tour", couleur, coord);
    }

    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        boolean ret = false;

        if (getCoord().x == xFinal || getCoord().y == yFinal) {
            ret = true;
        }

        return ret;
    }
}
