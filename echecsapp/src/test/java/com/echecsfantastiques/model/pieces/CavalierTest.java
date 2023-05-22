package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.utils.Coord;
import com.echecsfantastiques.model.Couleur;
import org.junit.Test;

import static org.junit.Assert.*;

public class CavalierTest {

        @Test
        public void testDeplacement() {
                Cavalier cavalierNoir = new Cavalier(Couleur.NOIR, new Coord(1, 0));
                Cavalier cavalierBlanc = new Cavalier(Couleur.BLANC, new Coord(1, 0));

                // Test de la méthode isMoveOk() pour le cavalier noir
                assertTrue("Cavalier noir devrait pouvoir se déplacer en (3, 1)", cavalierNoir.isMoveOk(3, 1));
                assertFalse("Cavalier noir ne devrait pas pouvoir se déplacer en (4, 4)",
                                cavalierNoir.isMoveOk(4, 4));
                assertTrue("Cavalier noir devrait pouvoir se déplacer en (2, 2)", cavalierNoir.isMoveOk(2, 2));
                assertFalse("Cavalier noir ne devrait pas pouvoir se déplacer en (1, 0)",
                                cavalierNoir.isMoveOk(1, 0));

                // Test de la méthode isMoveOk() pour le cavalier blanc
                assertTrue("Cavalier blanc devrait pouvoir se déplacer en (3, 1)", cavalierBlanc.isMoveOk(3, 1));
                assertFalse("Cavalier blanc ne devrait pas pouvoir se déplacer en (4, 4)",
                                cavalierBlanc.isMoveOk(4, 4));
                assertTrue("Cavalier blanc devrait pouvoir se déplacer en (2, 2)", cavalierBlanc.isMoveOk(2, 2));
                assertFalse("Cavalier blanc ne devrait pas pouvoir se déplacer en (1, 0)",
                                cavalierBlanc.isMoveOk(1, 0));
        }
}
