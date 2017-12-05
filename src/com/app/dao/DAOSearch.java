package com.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

import com.app.entity.*;

public class DAOSearch extends AbstractDAO<Contrat> {
	private JComboBox<String> comboclient;
	private JComboBox<String> lclient;
	public DAOSearch(Connection connection) {
		super(connection);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JComboBox<String> listeClient() {
		lclient = new JComboBox();
		try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT Nom_Client FROM contrat WHERE  Statut_Contrat='Inactif' OR Statut_Contrat='Hors Forfait'" );
	        while (rs.next()) {
	        	
	        	String nom = rs.getString("Nom_Client");
	        	lclient.addItem(nom);
	        	}
	        
		    
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	    return lclient;
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JComboBox<String> findClient() {
		comboclient = new JComboBox();
		try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT Nom_Client FROM contrat WHERE Deplacement ='Oui' AND Statut_Contrat='Actif'" );
	        while (rs.next()) {
	        	
	        	String nom = rs.getString("Nom_Client");
	        	comboclient.addItem(nom);
	        	}
	        
		    
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	    return comboclient;
	}
	
	
	public int findContrat(String nom) {
		String nomcli = null;
		int num =0;
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM contrat" );
	        while (rs.next()) {
				nomcli = rs.getString("Nom_Client");
				if(nomcli.equals(nom))
				{
					num = rs.getInt("Num_Contrat");
					break;
				}
			}
	    }
	    
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return num;
	}
	
	public String TempsRestant(String nom, int numcont) {
		String nomcli = null;
		String tpsrestant =null;
		int num =0;
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM contrat" );
	        while (rs.next()) {
				nomcli = rs.getString("Nom_Client");
				num = rs.getInt("Num_Contrat");
				if(nomcli.equals(nom) && num==numcont)
				{
					tpsrestant = rs.getString("Temps_Restant");
					System.out.println("tps restant: "+tpsrestant);
					break;
				}
			}    
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return tpsrestant;
	}

	public String TempsTotal(String nom, int numcont) {
		String nomcli = null;
		String forfait =null;
		int num =0;
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM contrat" );
	        while (rs.next()) {
				nomcli = rs.getString("Nom_Client");
				num = rs.getInt("Num_Contrat");
				if(nomcli.equals(nom) && num==numcont)
				{
					forfait = rs.getString("Forfait");
					System.out.println("forfait: "+forfait);
					break;
				}
			}    
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return forfait;
	}
	/*public String TempsTotal(String nom) {
		String nomcli = null;
		String forfait =null;
		int num =0;
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM contrat" );
	        while (rs.next()) {
				nomcli = rs.getString("Nom_Client");
				if(nomcli.equals(nom))
				{
					forfait = rs.getString("Forfait");
					num = rs.getInt("Num_Contrat");
					System.out.println("num: "+num);
					System.out.println("Forfait: "+forfait);
					//facture.setNumcontrat(num);
					break;
				}
			}    
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return forfait;
	}
	
	public String Report(String nom) {
		String nomcli = null;
		String forfait =null;
		int num =0;
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM contrat" );
	        while (rs.next()) {
				nomcli = rs.getString("Nom_Client");
				if(nomcli.equals(nom))
				{
					forfait = rs.getString("Forfait");
					num = rs.getInt("Num_Contrat");
					System.out.println("num: "+num);
					System.out.println("Forfait: "+forfait);
					//facture.setNumcontrat(num);
					break;
				}
			}    
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return forfait;
	}*/
	
	public String Statut(String nom) {
		String nomcli = null;
		String forfait =null;
		int num =0;
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM contrat" );
	        while (rs.next()) {
				nomcli = rs.getString("Nom_Client");
				if(nomcli.equals(nom))
				{
					forfait = rs.getString("Forfait");
					num = rs.getInt("Num_Contrat");
					System.out.println("num: "+num);
					System.out.println("Forfait: "+forfait);
					//facture.setNumcontrat(num);
					break;
				}
			}    
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return forfait;
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

