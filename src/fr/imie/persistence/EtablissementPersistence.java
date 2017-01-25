/**
 * 
 */
package fr.imie.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.imie.dTO.EtablissementDTO;

/**
 * @author imiedev
 *
 */
public class EtablissementPersistence implements IEtablissementPersistence {

	/**
	 * 
	 */
	@Override
	public List<EtablissementDTO> listerTousLesEtablissements() {

		Connection connection = null;
		String selectAllEtabissementQuery = null;
		Statement statement = null;
		ResultSet resultSet = null;

		List<EtablissementDTO> listeEtablissements = new ArrayList<>();
		;

		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JDBC", "postgres", "postgres");
			selectAllEtabissementQuery = "Select id,nom, numrue, nomrue, codepostal, ville from etablissement";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(selectAllEtabissementQuery);
			while (resultSet.next()) {
				// 1)Créer l'établissement
				EtablissementDTO etablissement = new EtablissementDTO();
				// 2)Initialiser l'étblissement
				int id = resultSet.getInt("id");
				String nom = resultSet.getString("nom");
				String numrue = resultSet.getString("numrue");
				String nomrue = resultSet.getString("nomrue");
				String codepostal = resultSet.getString("codepostal");
				String ville = resultSet.getString("ville");
				etablissement.initialize(id, nom, numrue, nomrue, codepostal, ville);
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

	@Override
	public void creerEtablissement(EtablissementDTO etablissementDTO) {
		Connection connection = null;
		String createEtablissementQuery = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;

		Statement statement;
		try {
			// 1) Persistence en base de données
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JDBC", "postgres", "postgres");
			createEtablissementQuery = String.format(
					"insert into Etablissement (nom,numrue,nomrue,codepostal,ville) values ('%s', '%s', '%s', '%s', '%s') returning id",
					etablissementDTO.getNom(), etablissementDTO.getNumRue(), etablissementDTO.getNomRue(),
					etablissementDTO.getCodePostal(), etablissementDTO.getVille());
			statement = connection.createStatement();
			resultSet = statement.executeQuery(createEtablissementQuery);
			if (resultSet.next()) {
				etablissementDTO.setId(resultSet.getInt("id"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (pStatement != null && !pStatement.isClosed()) {
					pStatement.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void supprimerEtablissement(int id) {
		Connection connection = null;
		String deleteEtablissementQuery = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;		
		Statement statement;
		
		try {
			// 1) Persistence en base de données
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JDBC", "postgres", "postgres");
			deleteEtablissementQuery = String.format("delete from etablissement where id = %s",id);
			System.out.println(deleteEtablissementQuery);
			statement = connection.createStatement();
			statement.executeUpdate(deleteEtablissementQuery);
			//resultSet = statement.executeQuery(deleteEtablissementQuery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (pStatement != null && !pStatement.isClosed()) {
					pStatement.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void modifierEtablissement(int id) {
		Connection connection = null;
		String deleteEtablissementQuery = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;		
		Statement statement;
		
		try {
			// 1) Persistence en base de données
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JDBC", "postgres", "postgres");
			deleteEtablissementQuery = String.format("update etablissement set nom=nom where id = %s",id);			
			statement = connection.createStatement();
			statement.executeUpdate(deleteEtablissementQuery);
			//resultSet = statement.executeQuery(deleteEtablissementQuery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null && !resultSet.isClosed()) {
					resultSet.close();
				}
				if (pStatement != null && !pStatement.isClosed()) {
					pStatement.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
