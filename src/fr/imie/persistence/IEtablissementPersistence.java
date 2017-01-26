package fr.imie.persistence;

import java.util.Map;

import fr.imie.dTO.EtablissementDTO;

public interface IEtablissementPersistence {
	public Map<Integer, EtablissementDTO> listerTousLesEtablissements();

	public void creerEtablissement(EtablissementDTO etablissementDTO);

	public void modifierEtablissement(EtablissementDTO eDto);

	public void supprimerEtablissement(EtablissementDTO eDto);
}
