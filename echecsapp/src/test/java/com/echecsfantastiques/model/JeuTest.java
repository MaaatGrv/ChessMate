package com.echecsfantastiques.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JeuTest {

    private Jeu jeu;

    @Before
    public void setUp() {
        jeu = new Jeu(Couleur.BLANC);
    }

    @Test
    public void testIsPieceHere() {
        assertTrue("Il devrait y avoir une pièce en (0, 1)", jeu.isPieceHere(0, 1));
        assertFalse("Il ne devrait pas y avoir de pièce en (3, 3)", jeu.isPieceHere(3, 3));
    }

    @Test
    public void testIsMoveOk() {
        assertTrue("Le pion devrait pouvoir se déplacer en (0, 2)", jeu.isMoveOk(0, 1, 0, 2));
        assertFalse("Le pion ne devrait pas pouvoir se déplacer en (0, 3)", jeu.isMoveOk(0, 1, 0, 3));
    }

    @Test
    public void testMove() {
        assertTrue("Le pion devrait pouvoir se déplacer en (0, 2)", jeu.move(0, 1, 0, 2));
        assertFalse("Le pion ne devrait pas pouvoir se déplacer en (0, 3)", jeu.move(0, 1, 0, 3));
    }

    @Test
    public void testGetPieceColor() {
        assertEquals("La pièce en (0, 1) devrait être blanche", Couleur.BLANC, jeu.getPieceColor(0, 1));
        assertNull("Il ne devrait pas y avoir de pièce en (3, 3)", jeu.getPieceColor(3, 3));
    }

    @Test
    public void testGetPieceType() {
        assertEquals("La pièce en (0, 1) devrait être un pion", "Pion", jeu.getPieceType(0, 1));
        assertNull("Il ne devrait pas y avoir de pièce en (3, 3)", jeu.getPieceType(3, 3));
    }

    // Ajoutez d'autres méthodes de test pour tester différentes fonctionnalités de
    // la classe Jeu.
}
