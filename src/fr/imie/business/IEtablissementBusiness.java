

package fr.imie.business;


import java.util.Map;

import fr.imie.dTO.EtablissementDTO;

public interface IEtablissementBusiness {
	public Map<Integer, EtablissementDTO> listerTousLesEtablissements() ;

	public void creerEtablissement(EtablissementDTO etablissement);

	public void modifierEtablissement(EtablissementDTO etablissementDTO);

	public void supprimerEtablissement(EtablissementDTO eDto);
}
