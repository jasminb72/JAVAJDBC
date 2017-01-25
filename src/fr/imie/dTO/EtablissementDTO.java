/**
 * 
 */
package fr.imie.dTO;

/**
 * @author imiedev
 *
 */
public class EtablissementDTO {

	private String nom;
	private String numRue;
	private String nomRue;
	private String codePostal;
	private String ville;

	/**
	 * @return
	 * 
	 */
	public void initialize(String nom, String numRue, String nomRue, String codePostal, String ville) {
		this.nom = nom;
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumRue() {
		return numRue;
	}

	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
