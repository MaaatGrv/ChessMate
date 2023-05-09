package com.echecsfantastiques.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JeuTest {

    private Jeu jeuBlanc;

    @Before
    public void setUp() {
        jeuBlanc = new Jeu(Couleur.BLANC);
    }

    @Test
    public void testIsPieceHere() {
        assertTrue("Il devrait y avoir une pièce en (0, 6)", jeuBlanc.isPieceHere(0, 6));
    }

    @Test
    public void testIsMoveOk() {
        assertTrue("Le pion devrait pouvoir se déplacer en (0, 4)", jeuBlanc.isMoveOk(0, 6, 0, 4));
    }

    @Test
    public void testMove() {
        assertTrue("Le pion devrait pouvoir se déplacer en (0, 4)", jeuBlanc.move(0, 6, 0, 4));
    }

    @Test
    public void testGetPieceColor() {
        assertEquals("La pièce en (0, 6) devrait être blanche", Couleur.BLANC, jeuBlanc.getPieceColor(0, 6));
    }

    @Test
    public void testGetPieceType() {
        assertEquals("La pièce en (0, 6) devrait être un pion", "Pion", jeuBlanc.getPieceType(0, 6));
    }

    // Ajoutez d'autres méthodes de test pour tester différentes fonctionnalités de
    // la classe Jeu.
}
