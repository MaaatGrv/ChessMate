package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.model.AbstractPiece;
import com.echecsfantastiques.model.Couleur;
import com.echecsfantastiques.utils.Coord;

public class Fou extends AbstractPiece {

    public Fou(Couleur couleur, Coord coord) {
        super("Fou", couleur, coord);
    }

    @Override
    public boolean isMoveOk(int xFinal, int yFinal, boolean isCatchOk, boolean isCastlingPossible) {
        int xInit = getCoord().x;
        int yInit = getCoord().y;
        int dx = Math.abs(xFinal - xInit);
        int dy = Math.abs(yFinal - yInit);

        // Déplacement en diagonale
        return dx == dy;
    }
}
