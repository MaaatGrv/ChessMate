package com.echecsfantastiques.model;

import com.echecsfantastiques.views.PieceIHM;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EchiquierTest {

    private Echiquier echiquier;

    @Before
    public void setUp() {
        echiquier = new Echiquier();
    }

    @Test
    public void testIsMoveOk() {
        assertFalse("Aucune pièce en (0, 3), le déplacement ne devrait pas être autorisé",
                echiquier.isMoveOk(0, 3, 0, 4));
    }

    @Test
    public void testMove() {
        assertTrue("Le pion blanc en (0, 6) devrait pouvoir se déplacer en (0, 4)", echiquier.move(0, 6, 0, 4));
    }

    @Test
    public void testSwitchJoueur() {
        echiquier.switchJoueur();
        assertEquals("Le joueur courant devrait être NOIR", Couleur.NOIR, echiquier.getColorCurrentPlayer());
    }

    @Test
    public void testGetPieceColor() {
        assertEquals("La pièce en (0, 6) devrait être blanche", Couleur.BLANC, echiquier.getPieceColor(0, 6));
    }

    @Test
    public void testGetPiecesIHM() {
        List<PieceIHM> piecesIHM = echiquier.getPiecesIHM();
        assertNotNull("La liste des PieceIHM ne devrait pas être nulle", piecesIHM);
        assertEquals("Il devrait y avoir 32 pièces", 32, piecesIHM.size());
    }

}
