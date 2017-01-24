/**
 * 
 */
package fr.imie.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.business.Etablissement;

/**
 * @author imiedev
 *
 */
public class EtablissementPersistence implements IEtablissementPersistence {

	/**
	 * 
	 */
	@Override
	public List<Etablissement> listerTousLesEtablissements() {

		Connection connection = null;
		String selectAllEtabissementQuery = null;
		Statement statement = null;
		ResultSet resultSet = null;

		List<Etablissement> listeEtablissements = new ArrayList<>();
		;

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JDBC", "postgres", "postgres");
			selectAllEtabissementQuery = "Select nom, numrue, nomrue, codepostal, ville from etablissement";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectAllEtabissementQuery);
			while (resultSet.next()) {
				// 1)Créer l'établissement
				Etablissement etablissement = new Etablissement();
				// 2)Initialiser l'étblissement
				String nom = resultSet.getString("nom");
				String numrue = resultSet.getString("numrue");
				String nomrue = resultSet.getString("nomrue");
				String codepostal = resultSet.getString("codepostal");
				String ville = resultSet.getString("ville");
				etablissement.initialize(nom, numrue, nomrue, codepostal, ville);
				// 3 Ajouter établissement à la liste
				listeEtablissements.add(etablissement);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (statement != null && !statement.isClosed()) {
					statement.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listeEtablissements;

	}
}
