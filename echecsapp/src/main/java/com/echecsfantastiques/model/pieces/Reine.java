package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.model.AbstractPiece;
import com.echecsfantastiques.model.Couleur;
import com.echecsfantastiques.utils.Coord;

public class Reine extends AbstractPiece {

    public Reine(Couleur couleur, Coord coord) {
        super("Reine", couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        int xInit = getCoord().x;
        int yInit = getCoord().y;
        int dx = Math.abs(xFinal - xInit);
        int dy = Math.abs(yFinal - yInit);

        // Déplacement en ligne droite ou en diagonale
        return (dx == dy) || (xInit == xFinal) || (yInit == yFinal);
    }
}
