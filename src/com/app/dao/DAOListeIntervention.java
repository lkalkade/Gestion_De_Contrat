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
import com.app.entity.*;

public class DAOListeIntervention extends AbstractDAO<Intervention> {

	public DAOListeIntervention(Connection connection) {
		super(connection);
	}

	public void ListeIntervention(){
	    try
	    {
	        Statement st = connection.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
	                								   ResultSet.CONCUR_READ_ONLY );
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM intervention" );
	        ResultSetTableModel rtm = new ResultSetTableModel( rs );
	        
	        
	        TablePanel tablePanel = new TablePanel( rtm );
	        
	        JDialog Lclient = new JDialog();
	        Lclient.add( tablePanel, BorderLayout.CENTER );
	        Point p = new Point(200, 200);
	        Lclient.setLocation(p.x, p.y);
	        Lclient.setTitle("Liste Intervention");
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
		public void create(Intervention obj) {
			// TODO Auto-generated method stub
			
		}
	}

