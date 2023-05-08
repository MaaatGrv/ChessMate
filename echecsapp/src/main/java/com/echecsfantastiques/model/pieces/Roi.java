package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.model.AbstractPiece;
import com.echecsfantastiques.model.Couleur;
import com.echecsfantastiques.utils.Coord;

public class Roi extends AbstractPiece {

    public Roi(Couleur couleur, Coord coord) {
        super("Roi", couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        int xInit = getCoord().x;
        int yInit = getCoord().y;
        int dx = Math.abs(xFinal - xInit);
        int dy = Math.abs(yFinal - yInit);

        // Le roi peut se déplacer d'une case dans n'importe quelle direction
        return (dx <= 1) && (dy <= 1);
    }
}
