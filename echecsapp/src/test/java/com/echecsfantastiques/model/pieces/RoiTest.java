package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.utils.Coord;
import com.echecsfantastiques.model.Couleur;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoiTest {

    @Test
    public void testDeplacement() {
        Roi roiNoir = new Roi(Couleur.NOIR, new Coord(4, 0));
        Roi roiBlanc = new Roi(Couleur.BLANC, new Coord(4, 7));

        // Test de la méthode isMoveOk() pour le roi noir
        assertTrue("Roi noir devrait pouvoir se déplacer en (4, 1)", roiNoir.isMoveOk(4, 1));
        assertTrue("Roi noir devrait pouvoir se déplacer en (3, 1)", roiNoir.isMoveOk(3, 1));
        assertFalse("Roi noir ne devrait pas pouvoir se déplacer en (2, 2)", roiNoir.isMoveOk(2, 2));
        assertFalse("Roi noir ne devrait pas pouvoir se déplacer en (4, 2)", roiNoir.isMoveOk(4, 2));

        // Test de la méthode isMoveOk() pour le roi blanc
        assertTrue("Roi blanc devrait pouvoir se déplacer en (4, 6)", roiBlanc.isMoveOk(4, 6));
        assertTrue("Roi blanc devrait pouvoir se déplacer en (3, 6)", roiBlanc.isMoveOk(3, 6));
        assertFalse("Roi blanc ne devrait pas pouvoir se déplacer en (2, 5)", roiBlanc.isMoveOk(2, 5));
        assertFalse("Roi blanc ne devrait pas pouvoir se déplacer en (4, 5)", roiBlanc.isMoveOk(4, 5));
    }
}
