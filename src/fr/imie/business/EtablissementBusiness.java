/**
 * 
 */
package fr.imie.business;

import java.util.List;

import fr.imie.persistence.EtablissementPersistence;
import fr.imie.persistence.IEtablissementPersistence;

/**
 * @author imiedev
 *
 */
public class EtablissementBusiness implements IEtablissementBusiness{

	/**
	 * 
	 */

	public List<Etablissement> listerTousLesEtablissements() {
		IEtablissementPersistence ep=new EtablissementPersistence();
		return ep.listerTousLesEtablissements();
	}
}
