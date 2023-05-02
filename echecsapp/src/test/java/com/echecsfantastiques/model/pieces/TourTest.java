package com.echecsfantastiques.model.pieces;

import com.echecsfantastiques.utils.Coord;
import com.echecsfantastiques.model.Couleur;
import com.echecsfantastiques.model.Echiquier;
import com.echecsfantastiques.model.Pieces;
import org.junit.Test;

public class TourTest {

    @Test
    public void testDeplacement() {
        Echiquier echiquier = new Echiquier();
        Pieces tourNoire = new Tour(Couleur.NOIR, new Coord(0, 0));
        Pieces tourBlanche = new Tour(Couleur.BLANC, new Coord(7, 7));

        // Test de la méthode getCouleur()
        System.out.println("Couleur de la tour noire : " + tourNoire.getCouleur()); // doit afficher NOIR
        System.out.println("Couleur de la tour blanche : " + tourBlanche.getCouleur()); // doit afficher BLANC

        // Test de la méthode getName()
        System.out.println("Nom de la tour noire : " + tourNoire.getName()); // doit afficher Tour
        System.out.println("Nom de la tour blanche : " + tourBlanche.getName()); // doit afficher Tour

        // Test de la méthode getCoord()
        System.out.println("Coordonnées de la tour noire : " + tourNoire.getCoord()); // doit afficher (0,0)
        System.out.println("Coordonnées de la tour blanche : " + tourBlanche.getCoord()); // doit afficher (7,7)

        // Test de la méthode move()
        tourNoire.move(new Coord(2, 0));
        System.out.println("Nouvelles coordonnées de la tour noire : " + tourNoire.getCoord()); // doit afficher (2,0)

        // Test de la méthode isMoveOk()
        System.out.println(
                "Déplacement de la tour noire en (5,0) est possible : " + tourNoire.isMoveOk(5, 0, false, false)); // doit
                                                                                                                   // afficher
                                                                                                                   // true
        System.out.println(
                "Déplacement de la tour noire en (5,5) est possible : " + tourNoire.isMoveOk(5, 5, false, false)); // doit
                                                                                                                   // afficher
                                                                                                                   // false
                                                                                                                   // //
                                                                                                                   // false
    }
}
