package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.app.entity.Intervention;

public class DAOIntervention extends AbstractDAO<Intervention> {

	private String query;
	private PreparedStatement prepstat;
	private Object[] tableau;
	private Statement statement;
	private ResultSet rset = null;

	public DAOIntervention(Connection connection) {
		super(connection);
	}

	@Override
	public void find(int num) {
		try {
			int blm = 0;
			query = "SELECT *  FROM intervention";
			statement = connection.createStatement();
			rset = statement.executeQuery(query);
			while (rset.next()) {
				blm = rset.getInt("Num_Intervention");
				if (num == blm) {
					tableau = new Object[] { rset.getInt("Num_Intervention"), rset.getString("Nom_Technicien"),rset.getString("Date_Intervention"),
							rset.getString("Heure_Debut"), rset.getString("Heure_Fin"),
							rset.getString("Duree_Intervention"), rset.getInt("Num_Contrat")};
					break;
				}
			}
		} catch (SQLException e) {
			
			// Etape 6 : libérer ressources de la mémoire.
			try {
				statement.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
	}

	public Object[] getTableau() {
		return tableau;
	}
	
	

	@Override
	public void create(Intervention intervention) {
		try {
			intervention.AddFacture(intervention);
			query = "INSERT INTO intervention VALUES(?,?,?,?,?,?,?)";
			prepstat = connection.prepareStatement(query);
			prepstat.setInt(1, intervention.getIdintervention());
			prepstat.setString(2, intervention.getDateintervention());
			prepstat.setString(3, intervention.getTechnicien());
			prepstat.setString(4, intervention.getHdebut());
			prepstat.setString(5, intervention.getHfin());
			prepstat.setString(6, intervention.getDuree());
			prepstat.setInt(7, intervention.getNumcontrat());
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
	public void remove(int facture) {
		try {

			query = "DELETE FROM facture WHERE Num_Intervention=?";
			prepstat = connection.prepareStatement(query);
			prepstat.setInt(1, facture);
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
		/*try {
			query = "UPDATE facture SET  Nom_Technicien=?, Date_Intervention=?, Heure_Debut=?, Heure_Fin=?, Duree_Intervention=? WHERE Num_Intervention=?";
			prepstat = connection.prepareStatement(query);
			prepstat.setString(1, tabContenu[1]);
			prepstat.setString(2, tabContenu[2]);
			prepstat.setString(3, tabContenu[3]);
			prepstat.setString(4, tabContenu[4]);
			prepstat.setString(5, tabContenu[5]);
			prepstat.setString(6, contrat);
			prepstat.executeUpdate();
			JOptionPane.showMessageDialog(null, "Successfull Alter", "Message d’avertissement",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "ERROR", "Message d’avertissement", JOptionPane.ERROR_MESSAGE);

		}*/
	}


	

}
