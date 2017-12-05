package com.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.app.entity.*;

public class DAONombre extends AbstractDAO<Contrat> {

	public DAONombre(Connection connection) {
		super(connection);
	}
	public int NumClient(int nclient) {
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT MAX(Num_Client) FROM client" );
	        rs.next();
	        nclient = rs.getInt(1);      
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return nclient;
	}
	
	public int NumContrat(int NumContrat){
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT MAX(Num_Contrat) FROM contrat" );
	        rs.next();
	        NumContrat = rs.getInt(1);      
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return NumContrat;
	  }
	
	public int NombreContrat(int NbContrat){
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT COUNT(*) FROM contrat" );
	        rs.next();
	        NbContrat = rs.getInt(1);      
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return NbContrat;
	  }

	public int NombreContratActif(int NbContrat){
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT COUNT(*) FROM contrat WHERE Statut_Contrat = 'Actif'" );
	        rs.next();
	        NbContrat = rs.getInt(1);      
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return NbContrat;
	  }
	  
	public int NombreContratInactif(int NbContrat){
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT COUNT(*) FROM contrat WHERE Statut_Contrat = 'Inactif'" );
	        rs.next();
	        NbContrat = rs.getInt(1);
	     
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return NbContrat;
	  }
	
	public int NombreContratHorsForfait(int NbContrat){
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT COUNT(*) FROM contrat WHERE Statut_Contrat = 'Hors Forfait'" );
	        rs.next();
	        NbContrat = rs.getInt(1);

	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return NbContrat;
	  }
	
	public int NombreClient(int NbClient){
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT COUNT(*) FROM client" );
	        rs.next();
	        NbClient = rs.getInt(1);      
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return NbClient;
	  }
	
	 
	public int NumIntervention(int nintervention) {
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT MAX(Num_intervention) FROM intervention" );
	        rs.next();
	        nintervention = rs.getInt(1);      
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return nintervention;
	}
	
	public int NombreIntervention(int NbIntervention){
	    try
	    {
	        Statement st = connection.createStatement();
	        
	        ResultSet rs = st.executeQuery( "SELECT COUNT(*) FROM intervention" );
	        rs.next();
	        NbIntervention = rs.getInt(1);      
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return NbIntervention;
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

