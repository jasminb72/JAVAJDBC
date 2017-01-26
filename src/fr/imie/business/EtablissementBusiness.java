/**
 * 
 */
package fr.imie.business;


import java.util.Map;

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

	public Map<Integer, EtablissementDTO> listerTousLesEtablissements() {

		return iEP.listerTousLesEtablissements();
	}

	@Override
	public void creerEtablissement(EtablissementDTO etablissementDTO) {
		iEP.creerEtablissement(etablissementDTO);

	}

	@Override
	public void supprimerEtablissement(EtablissementDTO eDto) {
		iEP.supprimerEtablissement(eDto);

	}

	@Override
	public void modifierEtablissement(EtablissementDTO eDto) {
		iEP.modifierEtablissement(eDto);
		
	}
}
