package com.echecsfantastiques.model;

import com.echecsfantastiques.utils.Coord;

/**
 * @author MaaatGrv
 *         from COO CPE Class
 *         Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 */
public interface Pieces {
    String getName();

    Couleur getCouleur();

    Coord getCoord();

    void move(Coord coord);

    boolean isMoveOk(int xFinal, int yFinal);

    String toString();

    int getY();

    int getX();
}
