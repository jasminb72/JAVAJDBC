package fr.imie.persistence;

import java.util.List;

import fr.imie.business.Etablissement;

public interface IEtablissementPersistence {
	public List<Etablissement> listerTousLesEtablissements();
}
