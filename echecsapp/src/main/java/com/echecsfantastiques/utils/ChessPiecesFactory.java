package com.echecsfantastiques.utils;

import java.util.LinkedList;
import java.util.List;

import com.echecsfantastiques.model.Couleur;
import com.echecsfantastiques.model.Pieces;

/**
 * @author francoise.perrin
 *         Inspiration Jacques SARAYDARYAN, Adrien GUENARD
 * 
 *         Classe qui fabrique une liste de pieces de jeu d'echec
 *         de la couleur pass�e en param�tre
 *
 */
public class ChessPiecesFactory {

	/**
	 * private pour ne pas instancier d'objets
	 */
	private ChessPiecesFactory() {

	}

	/**
	 * @param pieceCouleur
	 * @return liste de pi�ces de jeu d'�chec
	 */
	public static List<Pieces> newPieces(Couleur pieceCouleur) {

		List<Pieces> pieces = null;
		pieces = new LinkedList<Pieces>();
		String initCouleur = (Couleur.BLANC == pieceCouleur ? "B_" : "N_");

		if (pieceCouleur != null) {
			for (int i = 0; i < ChessPiecePos.values().length; i++) {

				if (pieceCouleur.equals(ChessPiecePos.values()[i].couleur)) {
					for (int j = 0; j < (ChessPiecePos.values()[i].coords).length; j++) {
						String className = "com.echecsfantastiques.model.pieces." + ChessPiecePos.values()[i].nom; // attention
																													// au
																													// chemin
						Coord pieceCoord = ChessPiecePos.values()[i].coords[j];
						pieces.add((Pieces) Introspection.newInstance(className,
								new Object[] { pieceCouleur, pieceCoord }));
					}
				}
			}
		}
		return pieces;
	}

	public static void displayPieces(List<Pieces> pieces) {
		for (Pieces piece : pieces) {
			System.out.println(piece.getClass().getSimpleName() + " - " + piece.getCoord().toString());
		}
	}

	/**
	 * Tests unitaires
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ChessPiecesFactory.newPieces(Couleur.BLANC));
	}
}
