package fr.imie.persistence;

import java.util.List;

import fr.imie.dTO.EtablissementDTO;

public interface IEtablissementPersistence {
	public List<EtablissementDTO> listerTousLesEtablissements();

	public void creerEtablissement(EtablissementDTO etablissementDTO);
}
