package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.utils.Coord;
import com.echecsfantastiques.model.Couleur;
import org.junit.Test;

import static org.junit.Assert.*;

public class FouTest {

    @Test
    public void testDeplacement() {
        Fou fouNoir = new Fou(Couleur.NOIR, new Coord(2, 0));
        Fou fouBlanc = new Fou(Couleur.BLANC, new Coord(5, 7));

        // Test de la méthode isMoveOk() pour le fou noir
        assertTrue("Fou noir devrait pouvoir se déplacer en (4, 2)", fouNoir.isMoveOk(4, 2));
        assertFalse("Fou noir ne devrait pas pouvoir se déplacer en (4, 1)", fouNoir.isMoveOk(4, 1));
        assertTrue("Fou noir devrait pouvoir se déplacer en (0, 2)", fouNoir.isMoveOk(0, 2));
        assertTrue("Fou noir ne devrait pas pouvoir se déplacer en (2, 0)", fouNoir.isMoveOk(2, 0));

        // Test de la méthode isMoveOk() pour le fou blanc
        assertTrue("Fou blanc devrait pouvoir se déplacer en (3, 5)", fouBlanc.isMoveOk(3, 5));
        assertFalse("Fou blanc ne devrait pas pouvoir se déplacer en (3, 6)", fouBlanc.isMoveOk(3, 6));
        assertFalse("Fou blanc devrait pouvoir se déplacer en (7, 3)", fouBlanc.isMoveOk(7, 3));
        assertTrue("Fou blanc ne devrait pas pouvoir se déplacer en (5, 7)", fouBlanc.isMoveOk(5, 7));
    }
}
