package fr.imie.presentation;

import fr.imie.business.IEtablissementBusiness;
import fr.imie.dTO.EtablissementDTO;

public class IHM {

	IEtablissementBusiness iEB;

	public IHM(IEtablissementBusiness iEB) {
		this.iEB = iEB;
	}

	public void init() {
		// crée un établissement par défaut
		this.créerEtablissementDefault();

		// liste tous les établissements dans la console
		this.listerTousLesEtablissements();

	}

	private EtablissementDTO créerEtablissementDefault() {

		// 1)Créer l'objet DTO établissement
		EtablissementDTO etablissementDTO = new EtablissementDTO();
		
		// 2)Renseigner les attributs de l'établissement par défaut
		String nom = "Nom etablissement";
		String numrue = "num rue";
		String nomrue = "nom rue";
		String codepostal = "code postal";
		String ville = "ville";
		etablissementDTO.initialize(nom, numrue, nomrue, codepostal, ville);
		
		//3)Persister le DTO en BDD
		iEB.creerEtablissement(etablissementDTO);
		
		
		return etablissementDTO;
	}

	private void listerTousLesEtablissements() {
		// Affiche tous les établissements
		for (EtablissementDTO eDTO : iEB.listerTousLesEtablissements()) {
			System.out.printf("Nom etablissement:%s\n", eDTO.getNom());
		}

	}
}
