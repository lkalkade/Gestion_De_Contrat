package com.app.dao;

import java.awt.BorderLayout;
import java.awt.Point;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import com.app.view.ResultSetTableModel;
import com.app.view.TablePanel;
import com.app.entity.Contrat;

public class DAOListeContrat extends AbstractDAO<Contrat> {

	public DAOListeContrat(Connection connection) {
		super(connection);
	}

	public void ListeContrat(){
	    try
	    {
	        Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
	                								   ResultSet.CONCUR_READ_ONLY );
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM contrat ORDER BY Nom_Client" );
	        ResultSetTableModel rtm = new ResultSetTableModel( rs );
	        
	        
	        TablePanel tablePanel = new TablePanel( rtm );
	        
	        JDialog Lclient = new JDialog();
	        Lclient.add( tablePanel, BorderLayout.CENTER );
	        Point p = new Point(200, 200);
	        Lclient.setLocation(p.x, p.y);
	        Lclient.setTitle("Liste Contrat");
	        Lclient.setSize( 940, 480 );
	        Lclient.setVisible( true );
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  }
	
	public void ListeContratActif(){
	    try
	    {
	        Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
	                								   ResultSet.CONCUR_READ_ONLY );
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM contrat WHERE Statut_Contrat='Actif'" );
	        ResultSetTableModel rtm = new ResultSetTableModel( rs );
	        
	        
	        TablePanel tablePanel = new TablePanel( rtm );
	        
	        JDialog Lclient = new JDialog();
	        Lclient.add( tablePanel, BorderLayout.CENTER );
	        Point p = new Point(200, 200);
	        Lclient.setLocation(p.x, p.y);
	        Lclient.setTitle("Liste Contrat Actif");
	        Lclient.setSize( 940, 480 );
	        Lclient.setVisible( true );
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  }
	
	public void ListeContratInactif(){
	    try
	    {
	        Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
	                								   ResultSet.CONCUR_READ_ONLY );
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM contrat WHERE Statut_Contrat='Inactif'" );
	        ResultSetTableModel rtm = new ResultSetTableModel( rs );
	        
	        
	        TablePanel tablePanel = new TablePanel( rtm );
	        
	        JDialog Lclient = new JDialog();
	        Lclient.add( tablePanel, BorderLayout.CENTER );
	        Point p = new Point(200, 200);
	        Lclient.setLocation(p.x, p.y);
	        Lclient.setTitle("Liste Contrat Inactif");
	        Lclient.setSize( 940, 480 );
	        Lclient.setVisible( true );
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  }
	
	public void ListeContratHorsForfait(){
	    try
	    {
	        Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
	                								   ResultSet.CONCUR_READ_ONLY );
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM contrat WHERE Statut_Contrat='Hors Forfait'" );
	        ResultSetTableModel rtm = new ResultSetTableModel( rs );
	        
	        
	        TablePanel tablePanel = new TablePanel( rtm );
	        
	        JDialog Lclient = new JDialog();
	        Lclient.add( tablePanel, BorderLayout.CENTER );
	        Point p = new Point(200, 200);
	        Lclient.setLocation(p.x, p.y);
	        Lclient.setTitle("Liste Contrat Hors Forfait");
	        Lclient.setSize( 940, 480 );
	        Lclient.setVisible( true );
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
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

