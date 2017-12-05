package com.app.dao;

import java.awt.BorderLayout;
import java.awt.Point;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import com.app.entity.*;
import com.app.view.ResultSetTableModel;
import com.app.view.TablePanel;

public class DAOListeClient extends AbstractDAO<Client> {

	public DAOListeClient(Connection connection) {
		super(connection);
	}

	public void ListeClient(){
	    try
	    {
	        Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
	                								   ResultSet.CONCUR_READ_ONLY );
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM client ORDER BY Nom_Client" );
	        ResultSetTableModel rtm = new ResultSetTableModel( rs );
	        
	        TablePanel tablePanel = new TablePanel( rtm );
	        
	        JDialog Lcontrat = new JDialog();
	        Lcontrat.add( tablePanel, BorderLayout.CENTER );
	        Point p = new Point(200, 200);
	        Lcontrat.setLocation(p.x, p.y);
	        Lcontrat.setTitle("Liste Client");
	        Lcontrat.setSize( 940, 480 );
	        Lcontrat.setVisible( true );
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
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

		@Override
		public void create(Client obj) {
			// TODO Auto-generated method stub
			
		}
	}

