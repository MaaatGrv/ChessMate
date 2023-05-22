package com.echecsfantastiques.model;

import com.echecsfantastiques.utils.Coord;

public abstract class AbstractPiece implements Pieces {

    protected Echiquier echiquier;
    protected String name;
    protected Couleur couleur;
    protected Coord coord;

    public void setEchiquier(Echiquier echiquier) {
        this.echiquier = echiquier;
    }

    public Echiquier getEchiquier() {
        return this.echiquier;
    }

    public AbstractPiece(String name, Couleur couleur, Coord coord) {
        this.name = name;
        this.couleur = couleur;
        this.coord = coord;
    }

    public String getName() {
        return name;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Coord getCoord() {
        return coord;
    }

    public int getX() {
        return coord.x;
    }

    public int getY() {
        return coord.y;
    }

    public void move(Coord coord) {
        this.coord = coord;
    }

    public abstract boolean isMoveOk(int xFinal, int yFinal);

    public String toString() {
        return name + " en " + coord.x + "," + coord.y;
    }
}
