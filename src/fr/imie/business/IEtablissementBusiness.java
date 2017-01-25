

package fr.imie.business;

import java.util.List;

import fr.imie.dTO.EtablissementDTO;

public interface IEtablissementBusiness {
	public List<EtablissementDTO> listerTousLesEtablissements() ;

	public void creerEtablissement(EtablissementDTO etablissement);
}
