/**
 * 
 */
package fr.imie.business;

import java.util.List;

import fr.imie.dTO.EtablissementDTO;
import fr.imie.persistence.IEtablissementPersistence;

/**
 * @author imiedev
 *
 */
public class EtablissementBusiness implements IEtablissementBusiness {
	IEtablissementPersistence iEP;

	public EtablissementBusiness(IEtablissementPersistence iEP) {
		this.iEP = iEP;
	}

	/**
	 * 
	 * 
	 */

	public List<EtablissementDTO> listerTousLesEtablissements() {

		return iEP.listerTousLesEtablissements();
	}

	@Override
	public void creerEtablissement(EtablissementDTO etablissementDTO) {
		iEP.creerEtablissement(etablissementDTO);

	}

	@Override
	public void supprimerEtablissement(int id) {
		iEP.supprimerEtablissement(id);

	}

	@Override
	public void modifierEtablissement(int id) {
		iEP.modifierEtablissement(id);
		
	}
}
