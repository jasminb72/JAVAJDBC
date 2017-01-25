/**
 * 
 */
package fr.imie.running;


import fr.imie.business.EtablissementBusiness;
import fr.imie.business.IEtablissementBusiness;

import fr.imie.persistence.EtablissementPersistence;
import fr.imie.persistence.IEtablissementPersistence;

import fr.imie.presentation.IHM;

/**
 * @author imiedev
 *
 */
public class Main {

	public static void main(String[] args) {
		
		IEtablissementPersistence iEP = new EtablissementPersistence();
		IEtablissementBusiness iEB = new EtablissementBusiness(iEP);
		IHM iHM = new IHM(iEB);
		
		iHM.init();

	}
}
