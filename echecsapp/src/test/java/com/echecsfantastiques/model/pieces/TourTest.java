package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.utils.Coord;
import com.echecsfantastiques.model.Couleur;
import org.junit.Test;

import static org.junit.Assert.*;

public class TourTest {

    @Test
    public void testDeplacement() {
        Tour tourNoir = new Tour(Couleur.NOIR, new Coord(0, 0));
        Tour tourBlanc = new Tour(Couleur.BLANC, new Coord(7, 7));

        // Test de la méthode isMoveOk()
        assertTrue(tourNoir.isMoveOk(0, 5, false, false));
        assertTrue(tourNoir.isMoveOk(5, 0, false, false));
        assertFalse(tourNoir.isMoveOk(3, 3, false, false));

        assertTrue(tourBlanc.isMoveOk(7, 2, false, false));
        assertTrue(tourBlanc.isMoveOk(2, 7, false, false));
        assertFalse(tourBlanc.isMoveOk(5, 5, false, false));
    }
}
