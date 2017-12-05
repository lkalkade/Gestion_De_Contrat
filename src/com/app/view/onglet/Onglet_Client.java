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

import com.app.controller.Controller_Client;
import com.app.dao.DAOListeClient;
import com.app.dao.DAONombre;
import com.app.dao.JDBC;

 
	 public class Onglet_Client extends JPanel {
			/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
			private  int row1,row2,row3,row4;
			private JTextField text1,text3,text2,text4;
	 	public Onglet_Client(){

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
				
				JButton cli = new JButton("Nouveau client");
				cli.setPreferredSize(new Dimension(200, 20));
				cli.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent arg0) {
					
							new Controller_Client();
					
					}
					
				});
				
				JButton modifcli = new JButton("Modifier client");
				modifcli.setPreferredSize(new Dimension(200, 20));
				
				JButton suppcli = new JButton("Supprimer client");
				suppcli.setPreferredSize(new Dimension(200, 20));
				
				
				
				 JButton actualiser = new JButton("Actualiser");
				 actualiser.setPreferredSize(new Dimension(200, 20));
				 actualiser.addActionListener(new ActionListener(){

					 	public void actionPerformed(ActionEvent arg0) {
					 		
					 			DAONombre NbClient=new DAONombre(JDBC.getConnection());
					 			row1=NbClient.NombreClient(row1);
					 			text1.setText(""+row1);
					 			
					 			/*row2=NbContrat.NombreContratActif(row2);
					 			text2.setText(""+row2);
					 			
					 			row3=NbContrat.NombreContratInactif(row3);
					 			text3.setText(""+row3);
					 			
					 			row4=NbContrat.NombreContratHorsForfait(row4);
					 			text4.setText(""+row4);*/
					 			
					 			// System.out.println(row1);
					 	}
					 	
					 });
				 
				 
				
				JLabel lib1 = new JLabel("Nombre de clients:" );
				JLabel lib2 = new JLabel("Clients en contrat:" );
				JLabel lib3 = new JLabel("Clients Hors Forfaits:" );
				JLabel lib4 = new JLabel("Clients inactif:" );
		
				
				JPanel panlib1 = new JPanel();
				lib1.setPreferredSize(new Dimension(160, 20));
				panlib1.setBorder(listBorder[0]);
				lib2.setAlignmentX(JLabel.CENTER);
				text1 =  new JTextField(""+row1);
				text1.setPreferredSize(new Dimension(50, 20));
				JLabel iconlib1 = new JLabel(new ImageIcon("images/cli.png"));
				JButton boutonlib1 = new JButton("Voir");
				panlib1.add(iconlib1);
				panlib1.add(lib1);
				panlib1.add(text1);
				panlib1.add(boutonlib1);
				boutonlib1.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent arg0) {
					
						DAOListeClient LClient =new DAOListeClient(JDBC.getConnection());
						LClient.ListeClient();
					
					}
					
				});
				panlib1.setBackground(Color.white);
				
				JPanel panlib2 = new JPanel();
				lib2.setPreferredSize(new Dimension(160, 20));
				panlib2.setBorder(listBorder[1]);
				lib2.setAlignmentX(JLabel.CENTER);
				text2 =  new JTextField(""+row2);
				text2.setPreferredSize(new Dimension(50, 20));
				JLabel iconlib2 = new JLabel(new ImageIcon("images/client-vert.png"));
				JButton boutonlib2 = new JButton("Voir");
				panlib2.add(iconlib2);
				panlib2.add(lib2);
				panlib2.add(text2);
				panlib2.add(boutonlib2);
				panlib2.setBackground(Color.white);
				
				JPanel panlib3 = new JPanel();
				lib3.setPreferredSize(new Dimension(160, 20));
				panlib3.setBorder(listBorder[3]);
				text3 =  new JTextField(""+row3);
				text3.setPreferredSize(new Dimension(50, 20));
				lib3.setAlignmentX(JLabel.CENTER);
				JLabel iconlib3 = new JLabel(new ImageIcon("images/client-rouge.png"));
				JButton boutonlib3 = new JButton("Voir");
				panlib3.add(iconlib3);
				panlib3.add(lib3);
				panlib3.add(text3);
				panlib3.add(boutonlib3);
				panlib3.setBackground(Color.white);
				
				JPanel panlib4 = new JPanel();
				lib4.setPreferredSize(new Dimension(160, 20));
				panlib4.setBorder(listBorder[2]);
				text4 =  new JTextField(""+row4);
				text4.setPreferredSize(new Dimension(50, 20));
				lib4.setAlignmentX(JLabel.CENTER);
				JLabel iconlib4 = new JLabel(new ImageIcon("images/client-gris.png"));
				JButton boutonlib4 = new JButton("Voir");
				panlib4.add(iconlib4);
				panlib4.add(lib4);
				panlib4.add(text4);
				panlib4.add(boutonlib4);
				panlib4.setBackground(Color.white);
			
			
				JPanel premiere_couche = new JPanel();
			JLabel vide = new JLabel("                                    ");
			premiere_couche.setPreferredSize(new Dimension(350, 320));
			premiere_couche.setBackground(Color.white);
	



	vide.setPreferredSize(new Dimension(600, 10));
	premiere_couche.add(vide);
	premiere_couche.add(cli);
	premiere_couche.add(modifcli);
	//premiere_couche.add(suppcli);
	premiere_couche.add(actualiser);
	premiere_couche.add(panlib1);
	/*premiere_couche.add(panlib2);
	premiere_couche.add(panlib4);
	premiere_couche.add(panlib3);*/

			
			
			
		
			//premiere_couche.add(imprimer);
		
			
		  
	






		
			
			JLabel jlb = new JLabel(new ImageIcon("images/reservation_cls.jpg"));
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