package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.app.entity.Client;

public class DAOClient extends AbstractDAO<Client> {

	private String query;
	private PreparedStatement prepstat;
	private Object[] tableau;
	private Statement statement;
	private ResultSet rset = null;

	public DAOClient(Connection connection) {
		super(connection);
	}

	@Override
	public void find(int client) {
		try {
			int cin = 0;
			query = "SELECT *  FROM client,contrat";
			statement = connection.createStatement();
			rset = statement.executeQuery(query);
			while (rset.next()) {
				cin = rset.getInt("Num_Client");
				if (client == cin) {
					tableau = new Object[] { rset.getInt("Num_Client"), rset.getString("Nom_Client"),rset.getInt("Num_Contrat"), rset.getString("Nom_Client"),rset.getString("Date_Contrat"),
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

	public void find1(String client) {
		try {
			String nom = null;
			query = "SELECT *  FROM client,contrat";
			statement = connection.createStatement();
			rset = statement.executeQuery(query);
			while (rset.next()) {
				nom = rset.getString("Nom_Client");
				if (client.equals(nom)) {
					tableau = new Object[] { rset.getInt("Num_Client"), rset.getString("Nom_Client"),rset.getInt("Num_Contrat"), rset.getString("Nom_Client"),rset.getString("Date_Contrat"),
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
	
	@Override
	public void create(Client client) {
		try {
			client.AddClient(client);
			query = "INSERT INTO client VALUE(?,?)";
			prepstat = connection.prepareStatement(query);
			prepstat.setString(1, client.getNom());
			prepstat.setInt(2, client.getNum());
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

			query = "DELETE FROM client WHERE Num_Client=?";
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
	public void modify(int client, String[] tabContenu) {
		try {
			query = "UPDATE client SET  Nom_Client=? WHERE Num_Client=?";
			prepstat = connection.prepareStatement(query);
			prepstat.setString(1, tabContenu[1]);
			prepstat.setInt(2, client);
			prepstat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfull Alter", "Message d’avertissement",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR", "Message d’avertissement", JOptionPane.ERROR_MESSAGE);

		}
	}

}
