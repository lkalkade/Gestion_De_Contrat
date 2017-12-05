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

import com.app.controller.Controller_Contrat;
import com.app.dao.DAOListeContrat;
import com.app.dao.DAONombre;
import com.app.dao.JDBC;

 
	 public class Onglet_Contrat extends JPanel {
			/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
			private  int row1, row2, row3, row4;
			private JTextField text1, text2, text3, text4;
	 	public Onglet_Contrat(){

			try {
				Border[] listBorder = {	
						BorderFactory.createEtchedBorder(Color.blue, Color.GRAY),
						BorderFactory.createEtchedBorder(Color.green, Color.GRAY),
						BorderFactory.createEtchedBorder(Color.gray, Color.GRAY),
						BorderFactory.createEtchedBorder(Color.red, Color.GRAY),
						BorderFactory.createMatteBorder(5, 2, 5, 2, Color.black),
						BorderFactory.createRaisedBevelBorder(),
						BorderFactory.createTitledBorder("Titre")
						
							
					};
				 JButton actualiser = new JButton("Actualiser");
				 actualiser.setPreferredSize(new Dimension(200, 20));
				 actualiser.addActionListener(new ActionListener(){

					 	public void actionPerformed(ActionEvent arg0) {
					 		
					 		DAONombre NbContrat=new DAONombre(JDBC.getConnection());
				 			row1=NbContrat.NombreContrat(row1);
				 			text1.setText(""+row1);
				 			
				 			row2=NbContrat.NombreContratActif(row2);
				 			text2.setText(""+row2);
				 			
				 			row3=NbContrat.NombreContratHorsForfait(row3);
				 			text3.setText(""+row3);
				 			
				 			row4=NbContrat.NombreContratInactif(row4);
				 			text4.setText(""+row4);
					 			
					 			// System.out.println(row1);
					 	}
					 	
					 });
				 
				
	
				JLabel lib = new JLabel("Nombre de contrat:");
				JLabel lib2 = new JLabel("Contrat actif:");
				JLabel lib4 = new JLabel("Contrat terminé:");
				JLabel lib3 = new JLabel("Hors forfait:" );
		
		
			JButton contra = new JButton("Nouveau contrat");
			contra.setPreferredSize(new Dimension(200, 20));
			
			contra.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
					
					
					new Controller_Contrat();
					
				
					
				
				}
				
	});

			JButton modifcontrat = new JButton("Modifier contrat");
			modifcontrat.setPreferredSize(new Dimension(200, 20));
			
			JButton suppcontrat = new JButton("Supprimer contrat");
			suppcontrat.setPreferredSize(new Dimension(200, 20));
			
			
		

			JPanel panlib = new JPanel();
			lib.setPreferredSize(new Dimension(160, 20));
			panlib.setBorder(listBorder[0]);
			lib.setAlignmentX(JLabel.CENTER);
			text1 =  new JTextField(""+row1);
			text1.setPreferredSize(new Dimension(50, 20));
			JLabel iconlib = new JLabel(new ImageIcon("images/connecte.jpg"));
			JButton boutonlib = new JButton("Voir");
			panlib.add(iconlib);
			panlib.add(lib);
			panlib.add(text1);
			panlib.add(boutonlib);
			boutonlib.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
					DAOListeContrat LContrat =new DAOListeContrat(JDBC.getConnection());
					LContrat.ListeContrat();
				
				}
				
			});
			panlib.setBackground(Color.white);



			JPanel panlib2 = new JPanel();
			lib2.setPreferredSize(new Dimension(160, 20));
			panlib2.setBorder(listBorder[1]);
			lib2.setAlignmentX(JLabel.CENTER);
			text2 =  new JTextField(""+row2);
			text2.setPreferredSize(new Dimension(50, 20));
			JLabel iconlib2 = new JLabel(new ImageIcon("images/vert.png"));
			JButton boutonlib2 = new JButton("Voir");
			panlib2.add(iconlib2);
			panlib2.add(lib2);
			panlib2.add(text2);
			panlib2.add(boutonlib2);
			boutonlib2.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
					DAOListeContrat LContratA =new DAOListeContrat(JDBC.getConnection());
					LContratA.ListeContratActif();
				
				}
				
			});
			panlib2.setBackground(Color.white);


			JPanel panlib3 = new JPanel();
			lib3.setPreferredSize(new Dimension(160, 20));
			panlib3.setBorder(listBorder[3]);
			lib3.setAlignmentX(JLabel.CENTER);
			text3 =  new JTextField(""+row3);
			text3.setPreferredSize(new Dimension(50, 20));
			JLabel iconlib3 = new JLabel(new ImageIcon("images/rouge.png"));
			JButton boutonlib3 = new JButton("Voir");
			panlib3.add(iconlib3);
			panlib3.add(lib3);
			panlib3.add(text3);
			panlib3.add(boutonlib3);
			boutonlib3.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
					DAOListeContrat LContratHF =new DAOListeContrat(JDBC.getConnection());
					LContratHF.ListeContratHorsForfait();
				
				}
				
			});
			panlib3.setBackground(Color.white);

			JPanel panlib4 = new JPanel();
			lib4.setPreferredSize(new Dimension(160, 20));
			panlib4.setBorder(listBorder[2]);
			lib4.setAlignmentX(JLabel.CENTER);
			text4 =  new JTextField(""+row4);
			text4.setPreferredSize(new Dimension(50, 20));
			JLabel iconlib4 = new JLabel(new ImageIcon("images/gris.png"));
			JButton boutonlib4 = new JButton("Voir");
			panlib4.add(iconlib4);
			panlib4.add(lib4);
			panlib4.add(text4);
			panlib4.add(boutonlib4);
			boutonlib4.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
					DAOListeContrat LContratI =new DAOListeContrat(JDBC.getConnection());
					LContratI.ListeContratInactif();
				
				}
				
			});
			panlib4.setBackground(Color.white);
			
			
	
		
			
			JPanel premiere_couche = new JPanel();
			premiere_couche.setPreferredSize(new Dimension(350, 320));
			premiere_couche.setBackground(Color.white);
		
			JLabel vide = new JLabel("                                    ");
			vide.setPreferredSize(new Dimension(600, 10));
			premiere_couche.add(vide);
			premiere_couche.add(contra);
			premiere_couche.add(modifcontrat);
			premiere_couche.add(suppcontrat);
			premiere_couche.add(actualiser);
			premiere_couche.add(panlib);
			premiere_couche.add(panlib2);
			premiere_couche.add(panlib4);
			//premiere_couche.add(panlib3);
		
			
			
		
			
		
			//premiere_couche.add(imprimer);
		
			
		  
			
			
		
			
			JLabel jlb = new JLabel(new ImageIcon("images/contra_cls.jpg"));
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