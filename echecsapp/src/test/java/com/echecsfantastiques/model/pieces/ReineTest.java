package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.utils.Coord;
import com.echecsfantastiques.model.Couleur;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReineTest {

    @Test
    public void testDeplacement() {
        Reine reineNoir = new Reine(Couleur.NOIR, new Coord(3, 0));
        Reine reineBlanc = new Reine(Couleur.BLANC, new Coord(3, 7));

        // Test de la méthode isMoveOk() pour la reine noire
        assertTrue("Reine noire devrait pouvoir se déplacer en (3, 2)", reineNoir.isMoveOk(3, 2));
        assertTrue("Reine noire devrait pouvoir se déplacer en (1, 2)", reineNoir.isMoveOk(1, 2));
        assertFalse("Reine noire ne devrait pas pouvoir se déplacer en (2, 2)", reineNoir.isMoveOk(2, 2));
        assertTrue("Reine noire ne devrait pas pouvoir se déplacer en (4, 1)", reineNoir.isMoveOk(4, 1));

        // Test de la méthode isMoveOk() pour la reine blanche
        assertTrue("Reine blanche devrait pouvoir se déplacer en (3, 5)", reineBlanc.isMoveOk(3, 5));
        assertTrue("Reine blanche devrait pouvoir se déplacer en (1, 5)", reineBlanc.isMoveOk(1, 5));
        assertTrue("Reine blanche ne devrait pas pouvoir se déplacer en (2, 6)",
                reineBlanc.isMoveOk(2, 6));
        assertFalse("Reine blanche ne devrait pas pouvoir se déplacer en (4, 5)",
                reineBlanc.isMoveOk(4, 5));
    }
}