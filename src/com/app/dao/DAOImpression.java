package com.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import com.app.entity.*;

public class DAOImpression extends AbstractDAO<Contrat> {
	public DAOImpression(Connection connection) {
		super(connection);
	}
	
	public String Impression(String nom) {
		String nomcli = null;
		int num;
		String str="";
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM contrat,intervention" );
	        while (rs.next()) {
				nomcli = rs.getString("Nom_Client");
				num = rs.getInt("Num_Contrat");
				if(nomcli.equals(nom) && num==rs.getInt("Num_Contrat"))
				{
					str += "	N°CONTRAT :	  " + rs.getInt("Num_Contrat") + "\n";
					str += "	CLIENT :	  " + rs.getString("Nom_Client")  + "\n";
					str += "	PERIODE :	  " + rs.getString("Date_Contrat")+ "\n";
					str += "	TYPE CONTRAT :   " +rs.getString("Forfait")+" H" +"\t"+ rs.getString("Type_Contrat")+ "\n";
					str += "	DEPLACEMENT :    " + rs.getString("Deplacement")+ "\n\n";
					str += "		INTERVENTION \t\t TECHNICIEN \t\t BLM \t\t DUREE\n\n";
					str +=rs.getString("Date_Intervention")+"\t"+rs.getString("Nom_Technicien")+
					 "\t"+rs.getInt("Num_Intervention")+ "\t"+rs.getString("Duree_Intervention")+"\n\n";
					 
					
					 
								
					
					
					str += "	TEMPS TOTAL :    " + rs.getString("Temps_Total")+ "\n";
					str += "	TEMPS RESTANT :    " + rs.getString("Temps_Restant")+ "\n";
					break;
				}
			}    
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
		return str;
	}
	
	
	
		@Override
		public void create(Contrat obj) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void find(int searchIntred) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void remove(int stagiaire) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void modify(int stagiaire, String[] tabContenu) {
			// TODO Auto-generated method stub
			
		}

		
	}

