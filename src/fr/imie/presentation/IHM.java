package fr.imie.presentation;

import java.util.Scanner;

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

		Scanner sc=new Scanner(System.in);
		
		/*
		 * //Suppression établissement Scanner sc = new Scanner(System.in);
		 * System.out.println("Quel établissement voulez vous supprimer? (indiquez n°ID)");
		 * this.supprimerEtablissement(Integer.parseInt(sc.nextLine()));
		 * 
		 * 
		 * // liste tous les établissements dans la console
		 * this.listerTousLesEtablissements();
		 */
		
		System.out.println("Quel établissement voulez mettre à jour? (indiquez n°ID)");
		Integer id = Integer.parseInt(sc.nextLine());
		
		this.modifierEtablissement(id);
		
		
		

		// liste tous les établissements dans la console
		this.listerTousLesEtablissements();
		sc.close();
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

		// 3)Persister le DTO en BDD
		iEB.creerEtablissement(etablissementDTO);

		return etablissementDTO;
	}

	private void listerTousLesEtablissements() {
		// Affiche tous les établissements
		// for (EtablissementDTO eDTO : iEB.listerTousLesEtablissements()) {
		int i = 0;
		for (EtablissementDTO eDTO : iEB.listerTousLesEtablissements()) {
			i++;
			System.out.printf("Numéro:%s |;ID:%s, nom etablissement: %s\n", i, eDTO.getId(), eDTO.getNom());

		}

	}

	private void supprimerEtablissement(int id) {
		iEB.supprimerEtablissement(id);

	}

	private void modifierEtablissement(int id) {
		iEB.modifierEtablissement(id);

	}
}
