package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.utils.Coord;
import com.echecsfantastiques.model.Couleur;
import org.junit.Test;

import static org.junit.Assert.*;

public class PionTest {

    @Test
    public void testDeplacement() {
        Pion pionNoir = new Pion(Couleur.NOIR, new Coord(1, 1));
        Pion pionBlanc = new Pion(Couleur.BLANC, new Coord(1, 6));

        // Test de la méthode isMoveOk() pour le pion noir
        assertTrue("Pion noir devrait pouvoir se déplacer en (1, 2)", pionNoir.isMoveOk(1, 2, false, false));
        assertTrue("Pion noir devrait pouvoir se déplacer en (1, 3)", pionNoir.isMoveOk(1, 3, false, false));
        assertFalse("Pion noir ne devrait pas pouvoir se déplacer en (1, 4)", pionNoir.isMoveOk(1, 4, false, false));

        // Test de la méthode isMoveOk() pour le pion blanc
        assertTrue("Pion blanc devrait pouvoir se déplacer en (1, 5)", pionBlanc.isMoveOk(1, 5, false, false));
        assertTrue("Pion blanc devrait pouvoir se déplacer en (1, 4)", pionBlanc.isMoveOk(1, 4, false, false));
        assertFalse("Pion blanc ne devrait pas pouvoir se déplacer en (1, 3)", pionBlanc.isMoveOk(1, 3, false, false));
    }
}