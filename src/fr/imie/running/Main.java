/**
 * 
 */
package fr.imie.running;

import fr.imie.business.Etablissement;
import fr.imie.business.EtablissementBusiness;
import fr.imie.business.IEtablissementBusiness;

/**
 * @author imiedev
 *
 */
public class Main {

	public static void main(String[] args) {
		IEtablissementBusiness dTO = new EtablissementBusiness();
		for (Etablissement etablissement : dTO.listerTousLesEtablissements()) {
			System.out.printf("Nom etablissement:%s\n", etablissement.getNom());
		}

	}
}
