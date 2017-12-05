package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import com.app.entity.Client;
import com.app.entity.Contrat;

public class DAOContrat extends AbstractDAO<Contrat> {

	private String query;
	private PreparedStatement prepstat;
	private Object[] tableau;
	private Statement statement;
	private ResultSet rset = null;

	public DAOContrat(Connection connection) {
		super(connection);
	}

	@Override
	public void find(int numcontrat) {
		try {
			int id = 0;
			query = "SELECT *  FROM contrat";
			statement = connection.createStatement();
			rset = statement.executeQuery(query);
			while (rset.next()) {
				id = rset.getInt("Num_Contrat");
				if (numcontrat == id) {
					tableau = new Object[] { rset.getInt("Num_Contrat"), rset.getString("Nom_Client"),rset.getString("Date_Contrat"),
							rset.getString("Type_Contrat"), rset.getString("Forfait"),
							rset.getString("Deplacement")};
					break;
				}
			}
		} catch (SQLException e) {
			// Etape 6 : libérer ressources de la mémoire.
			try {
				statement.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	
	public Object[] getTableau() {
		return tableau;
	}
	
	private String request;
	private Statement state;
	private ResultSet resultset;

	public void findClient(Contrat contrat, Client client) {
		String nom = null;
		try {
			request = "SELECT Nom_Client FROM client";
			state = connection.createStatement();
			resultset = state.executeQuery(request);
			while (resultset.next()) {
				nom = resultset.getString("Nom_Client");
			}
			
			contrat.setNomclient(nom);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void create(Contrat contrat) {
		try {
			contrat.AddContrat(contrat);
			query = "INSERT INTO contrat VALUES(?,?,?,?,?,?,?,?,?,?)";
			prepstat = connection.prepareStatement(query);
			prepstat.setInt(1, contrat.getId());
			prepstat.setString(2, contrat.getNomclient());
			prepstat.setString(3, contrat.getDateContrat());
			prepstat.setString(4, contrat.getTypeContrat());
			prepstat.setString(5, contrat.getForfaits());
			prepstat.setString(6, contrat.getDeplacement());
			prepstat.setString(7, contrat.getForfaits());
			prepstat.setString(8, "00:00:00");
			prepstat.setString(9, "00:00:00");
			prepstat.setString(10, contrat.getStatut());
			prepstat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfull Add", "Message d’avertissement",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR ADD INTO DB", "Message d’avertissement",
					JOptionPane.ERROR_MESSAGE);

		}
		/*
		 * finally { try { if (connection != null) connection.close(); } catch
		 * (SQLException e) { e.printStackTrace(); } }
		 */
	}

	@Override
	public void remove(int contrat) {
		try {

			query = "DELETE FROM contrat WHERE Num_Contrat=?";
			prepstat = connection.prepareStatement(query);
			prepstat.setInt(1, contrat);
			prepstat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfull DELETE", "Message d’avertissement",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR", "Message d’avertissement", JOptionPane.ERROR_MESSAGE);
		}
	}


	@Override
	public void modify(int contrat, String[] tabContenu) {
		try {
			query = "UPDATE contrat SET  Date_Contrat=?, Type_Contrat=?, Forfait=?, Deplacement=? WHERE Num_Contrat=?";
			prepstat = connection.prepareStatement(query);
			prepstat.setString(1, tabContenu[1]);
			prepstat.setString(2, tabContenu[2]);
			prepstat.setString(3, tabContenu[3]);
			prepstat.setString(4, tabContenu[4]);
			prepstat.setString(5, tabContenu[5]);
			prepstat.setInt(6, contrat);
			prepstat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfull Alter", "Message d’avertissement",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR", "Message d’avertissement", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void modifytemps(int contrat, String total, String restant, String report, String statut) {
		try {
			query = "UPDATE contrat SET  Temps_Restant=?, Temps_Total=?, Report=?, Statut_Contrat=? WHERE Num_Contrat=?";
			prepstat = connection.prepareStatement(query);
			prepstat.setString(1, restant);
			prepstat.setString(2, total);
			prepstat.setString(3, report);
			prepstat.setString(4, statut);
			prepstat.setInt(5, contrat);
			prepstat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfull Alter", "Message d’avertissement",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR", "Message d’avertissement", JOptionPane.ERROR_MESSAGE);

		}
	}
}
