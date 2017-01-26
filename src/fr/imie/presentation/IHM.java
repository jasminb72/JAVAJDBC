package fr.imie.presentation;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import fr.imie.business.IEtablissementBusiness;
import fr.imie.dTO.EtablissementDTO;

public class IHM {

	IEtablissementBusiness iEB;
	Map<Integer, EtablissementDTO> listeEtablissements;

	public IHM(IEtablissementBusiness iEB) {
		this.iEB = iEB;
	}

	public void start() {

		Scanner sc = new Scanner(System.in);
		Integer id = 0;

		String choix = "";
		do {
			System.out.println(".------------------.");
			System.out.println("|      Menu        |");
			System.out.println("'------------------'");
			System.out.println("Que voulez vous faire?");
			System.out.println("1-Créer établissement");
			System.out.println("2-Modifier établissement");
			System.out.println("3-Supprimer établissement");
			System.out.println("4-Lister tous les établissements");
			System.out.println("X-Sortir");

			choix = sc.nextLine();
			// if (choix.toUpperCase().equals("X")) {
			// break;
			// }

			switch (choix) {
			case "1":
				// crée un établissement par défaut
				this.créerEtablissementDefault();
				break;
			case "2":
				// A Améliorer: ajout de possibilité de modifier champ par champ
				System.out.println(
						"Quel établissement voulez vous modifier?(N'hésitez pas à lister les établissements avant)");
				id = Integer.parseInt(sc.nextLine());
				listeEtablissements = iEB.listerTousLesEtablissements();
				if (listeEtablissements.get(id) == null) {
					System.out.println("Etablissement inexistant. Taper entrer pour continuer");
					sc.nextLine();
				} else {
					this.modifierEtablissement(listeEtablissements.get(id));
				}
				break;
			case "3":
				System.out.println(
						"Quel établissement voulez vous supprimer?(N'hésitez pas à lister les établissements avant)");
				id = Integer.parseInt(sc.nextLine());
				listeEtablissements = iEB.listerTousLesEtablissements();
				if (listeEtablissements.get(id) == null) {
					System.out.println("Etablissement inexistant. Taper entrer pour continuer");
					sc.nextLine();
				} else {
					this.supprimerEtablissement(listeEtablissements.get(id));
				}
				break;
			case "4":
				// liste tous les établissements dans la console
				this.AfficherTousLesEtablissements();
				break;
			default:
				break;
			}

		} while (!choix.toUpperCase().equals("X")); // (choix.equals("x") ==
													// false);

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

	private void AfficherTousLesEtablissements() {
		// Affiche tous les établissements
		EtablissementDTO eDTO;
		Set<Integer> set = iEB.listerTousLesEtablissements().keySet();
		for (Integer key : set) {
			eDTO = iEB.listerTousLesEtablissements().get(key);
			System.out.printf("ID:%s, nom etablissement: %s\n", eDTO.getId(), eDTO.getNom());

		}

	}

	private void supprimerEtablissement(EtablissementDTO etablissementDTO) {
		iEB.supprimerEtablissement(etablissementDTO);

	}

	private void modifierEtablissement(EtablissementDTO etablissementDTO) {
		iEB.modifierEtablissement(etablissementDTO);

	}
}
