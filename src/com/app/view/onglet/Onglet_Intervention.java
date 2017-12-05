package com.app.view.onglet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.app.controller.Controller_Intervention;
import com.app.dao.DAOListeIntervention;
import com.app.dao.DAONombre;
import com.app.dao.JDBC;

 
	 public class Onglet_Intervention extends JPanel {
			/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
			private  int row1;
			private JTextField text1;
	 	public Onglet_Intervention(){

			try {
				Border[] listBorder = {	
						BorderFactory.createEtchedBorder(Color.blue, Color.GRAY),
						BorderFactory.createLineBorder(Color.green),
						BorderFactory.createLineBorder(Color.orange),
						BorderFactory.createLineBorder(Color.red),
						BorderFactory.createMatteBorder(5, 2, 5, 2, Color.black),
						BorderFactory.createRaisedBevelBorder(),
						BorderFactory.createTitledBorder("Titre")
						
							
					};
				 JButton actualiser = new JButton("Actualiser");
				 actualiser.setPreferredSize(new Dimension(200, 20));
				 actualiser.addActionListener(new ActionListener(){

					 	public void actionPerformed(ActionEvent arg0) {
					 		
					 			DAONombre NbIntervention=new DAONombre(JDBC.getConnection());
					 			row1=NbIntervention.NombreIntervention(row1);
					 			text1.setText(""+row1);
					 			
					 			
					 			// System.out.println(row1);
					 	}
					 	
					 });
				 
				
			
			
				
	
				JLabel lib = new JLabel("Nombre d'intervention:");
			
		
		
			JButton facture = new JButton("Nouvelle intervention");
			facture.setPreferredSize(new Dimension(200, 20));
			facture.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
					new Controller_Intervention();	
				}
				
			});
			
			

			JPanel panlib = new JPanel();
			lib.setPreferredSize(new Dimension(160, 20));
			panlib.setBorder(listBorder[0]);
			lib.setAlignmentX(JLabel.CENTER);
			text1 =  new JTextField(""+row1);
			text1.setPreferredSize(new Dimension(50, 20));
			JLabel iconlib = new JLabel(new ImageIcon("images/inter.png"));
			JButton boutonlib = new JButton("Voir");
			panlib.add(iconlib);
			panlib.add(lib);
			panlib.add(text1);
			panlib.add(boutonlib);
			boutonlib.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
					DAOListeIntervention LIntervention =new DAOListeIntervention(JDBC.getConnection());
					LIntervention.ListeIntervention();
				
				}
				
			});
			panlib.setBackground(Color.white);
			
			
	
		
			
			JPanel premiere_couche = new JPanel();
			premiere_couche.setPreferredSize(new Dimension(350, 320));
			premiere_couche.setBackground(Color.white);
			
		
			JLabel vide = new JLabel("                                    ");
			vide.setPreferredSize(new Dimension(600, 20));
			premiere_couche.add(vide);
			premiere_couche.add(facture);
			premiere_couche.add(actualiser);
			premiere_couche.add(panlib);
		
			
			
		
			
		
			//premiere_couche.add(imprimer);
		
			
		  
			
			
		
			
			JLabel jlb = new JLabel(new ImageIcon("images/facture_cls.png"));
			jlb.setPreferredSize(new Dimension(300, 320));
			this.setBackground(Color.white);
			JPanel doubl = new JPanel();
			doubl.add(jlb);
			doubl.add(premiere_couche);
			doubl.setBackground(Color.white);
		//	initToolBar();
			this.add(doubl,  BorderLayout.CENTER);
			this.setBackground(Color.white);

		
			  
	 
			
	 	
	 	
	 	  }catch(Exception e){}
	 	}
	 	  public void paintComponent(Graphics g){
	            try {
	                    Image img = ImageIO.read(new File("images/fond.jpg"));
	                     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	            } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	            }
	            
	    } 
	 	  


	 }