package com.app.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.border.Border;

import com.app.controller.Controller_Client;
import com.app.controller.Controller_Contrat;
import com.app.controller.Controller_Intervention;
import com.app.controller.Controller_Modif;
import com.app.controller.Controller_Recherche;
import com.app.dao.DAOListeClient;
import com.app.dao.DAOListeContrat;
import com.app.dao.DAOListeIntervention;
import com.app.dao.DAONombre;
import com.app.dao.DAORecapitulatif;
import com.app.dao.JDBC;
import com.app.impression.Imprimante;
import com.app.view.onglet.Onglet_Client;
import com.app.view.onglet.Onglet_Contrat;
import com.app.view.onglet.Onglet_Intervention;

public class Accueil extends JFrame {


	private static final long serialVersionUID = 1L;
	private JTextField horloge;
	//Menu
	private JMenuBar menuBar = new JMenuBar();

	public JMenu Fichier = new JMenu("Fichier");
	public JMenu Editer = new JMenu("Editer");
	private JMenu Edition = new JMenu("Edition");
	public JMenu Aide = new JMenu("?");
	
	//Fichier
	private JMenuItem miseenpage = new JMenuItem("Mise en page");
	private JMenuItem imprimer = new JMenuItem("Imprimer");
	private JMenuItem fermer = new JMenuItem("Fermer");
	
	//Edition
	private JMenu clie = new JMenu("Client");
	private JMenuItem ajouter_client = new JMenuItem("Créer");
	private JMenuItem modifier_client = new JMenuItem("Modifier");
	private JMenuItem supprimer_client = new JMenuItem("Supprimer");
	
	private JMenu cont = new JMenu("Contrat");
	private JMenuItem ajouter_contrat = new JMenuItem("Créer");
	private JMenuItem modifier_contrat = new JMenuItem("Modifier");
	private JMenuItem supprimer_contrat = new JMenuItem("Supprimer");
	
	private JMenu fact = new JMenu("Intervention");
	private JMenuItem ajouter_facture = new JMenuItem("Créer");
	private JMenuItem modifier_facture = new JMenuItem("Modifier");
	private JMenuItem supprimer_facture = new JMenuItem("Supprimer");
	
	//Aide
	private JMenuItem help  = new JMenuItem("Afficher l'aide");
	private JMenuItem info = new JMenuItem("A propos de");
	
	
	
	final Background contient= new Background();
	final Background2 contient2= new Background2();
	
	private static JSplitPane split;
	
	private static JPanel menu = new JPanel();
	
	private JTabbedPane p;
	
	private static boolean gauche=true, droite=false,haut=false,bas=false;
	
	private  int row1,row2,row3,row4;
	
	private JTextField text3,text1,text2,text4;
	
	public static int onglet = JTabbedPane.LEFT;
	
	public Accueil(boolean ok){
		
	}
	public Accueil(){
		
		this.setTitle("Gestion Contrat ");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	
		fermer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}				
		});
		this.Fichier.add(miseenpage);
		this.Fichier.add(imprimer);
		this.Fichier.addSeparator();
		this.Fichier.add(fermer);
		
	
		///////////////////////////////////////////////
	
		Fichier.setBackground(Color.white);
		Edition.setBackground(Color.white);
		Aide.setBackground(Color.white);
	
		
		
		
		Fichier.setMnemonic('F');
		menuBar.add(Fichier);
		Edition.setMnemonic('E');
		menuBar.add(Edition);
		Aide.setMnemonic('?');
		menuBar.add(Aide);
		
	
		this.setVisible(true);	
		
		
		
		
		// /////////////////////////////////////////////////////
	
		
		
		ajouter_client.setIcon(new ImageIcon("images/new_cli.png"));
		ajouter_contrat.setIcon(new ImageIcon("images/new_cont.png"));
		ajouter_facture.setIcon(new ImageIcon("images/new_inter.png"));

		modifier_client.setIcon(new ImageIcon("images/modif.png"));
		modifier_contrat.setIcon(new ImageIcon("images/modif.png"));
		modifier_facture.setIcon(new ImageIcon("images/modif.png"));
		
		clie.setBackground(Color.white);
		//clie.add(consulter_client);
		clie.add(ajouter_client);
		//clie.add(modifier_client);
		//clie.add(supprimer_client);
	
		//consulter_client.setBackground(Color.white);
		modifier_client.setBackground(Color.white);
		ajouter_client.setBackground(Color.white);
		supprimer_client.setBackground(Color.white);
		
		cont.setBackground(Color.white);
		//cont.add(consulter_contrat);
		cont.add(ajouter_contrat);
		//cont.add(modifier_contrat);
		//cont.add(supprimer_contrat);
	
		//consulter_contrat.setBackground(Color.white);
		modifier_contrat.setBackground(Color.white);
		ajouter_contrat.setBackground(Color.white);
		supprimer_contrat.setBackground(Color.white);
		
		fact.setBackground(Color.white);
		//fact.add(consulter_facture);
		fact.add(ajouter_facture);
		//fact.add(modifier_facture);
		//fact.add(supprimer_facture);
	
		//consulter_facture.setBackground(Color.white);
		modifier_facture.setBackground(Color.white);
		ajouter_facture.setBackground(Color.white);
		supprimer_facture.setBackground(Color.white);
		miseenpage.setBackground(Color.white);
		imprimer.setBackground(Color.white);
		fermer.setBackground(Color.white);
		
		
		
		miseenpage.setIcon(new ImageIcon("images/mise_page.png"));
		imprimer.setIcon(new ImageIcon("images/imprimer.png"));
		fermer.setIcon(new ImageIcon("images/fermer.png"));
		
		
		
		
		
		
		ajouter_client.addActionListener(new ActionListener(){

    		public void actionPerformed(ActionEvent arg0) {
    		
    				new Controller_Client();
    		
    		}
    		
    	});
		
		ajouter_contrat.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
			
				new Controller_Contrat();
				
			}
			
		});
		
		ajouter_facture.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
			
				new Controller_Intervention();
				
			}
			
		});


		
		miseenpage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		imprimer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                KeyEvent.CTRL_DOWN_MASK));
		fermer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
                KeyEvent.CTRL_DOWN_MASK));
		
		/*consulter_vehicule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		ajouter_vehicule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		modifier_vehicule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		supprimer_vehicule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		
		consulter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));
		ajouter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));
		modifier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));
		supprimer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK));
		
		//this.clients.add(liste_client);
		//this.clients.add(liste_client_attente);
		//this.clients.add(liste_client_cours);*/
		
		clie.setIcon(new ImageIcon("images/cli.png"));
		cont.setIcon(new ImageIcon("images/icone_contra.jpg"));
		fact.setIcon(new ImageIcon("images/intervention.png"));
		
		info.setIcon(new ImageIcon("images/info.png"));
		help.setIcon(new ImageIcon("images/aide.png"));
				
		

		
		this.Edition.add(clie);
		this.Edition.add(cont);
		this.Edition.add(fact);
		
		//this.Aide.add(help);
		this.Aide.add(info);
		
		info.addActionListener(new ActionListener(){
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent ev) {
				JOptionPane aPropos = new JOptionPane();
				
				aPropos.showMessageDialog(null," Gestion de Contrat \n"
						+ " Gestion de Contrat est un editeur de contrat prépayer, très léger. \n"
						+ " 2016 \n"
						+ "\n Ce programme est fourni sans AUCUNE GARANTIE. ","A propos de", JOptionPane.INFORMATION_MESSAGE);
			}
    	});
        
	    help.addActionListener(new ActionListener(){
			@SuppressWarnings("static-access")
				public void actionPerformed(ActionEvent ev) {
					JOptionPane ReadMe = new JOptionPane();
					ReadMe.showMessageDialog(null," Gestion de Contrat \n"
							+ "Mode d'emploi:\n"
							+ "Bienvenue dans le manuel d'aide de Gestion de Contrat \n"
							+ "I-Utilisation:\n"
							+ "\t\t\n\n\n "
							+ "2016 \n\n ","ReadMe", JOptionPane.INFORMATION_MESSAGE);
				}
	    	});
		
		
		this.menuBar.add(Aide);
			
					
			this.setJMenuBar(menuBar);
			
			
	
		
			Border[] listBorder = {	
					BorderFactory.createEtchedBorder(Color.blue, Color.gray),
					BorderFactory.createEtchedBorder(Color.green, Color.gray),
					BorderFactory.createEtchedBorder(Color.gray, Color.gray),
					BorderFactory.createEtchedBorder(Color.red, Color.gray),
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
			 			
			 	}
			 	
			 });
		
	

JLabel lib = new JLabel("Nombre de contrat:");
JLabel lib2 = new JLabel("Contrat actif:");
JLabel lib4 = new JLabel("Contrat terminé:");
JLabel lib3 = new JLabel("Hors forfait:" );

JButton facture = new JButton("Nouvelle intervention");
facture.setPreferredSize(new Dimension(200, 20));
facture.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
	
		new Controller_Intervention();
		
	}
	
});

JButton contra = new JButton("Nouveau contrat");
contra.setPreferredSize(new Dimension(200, 20));
contra.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
	
		new Controller_Contrat();
		
	}
	
});


JButton cli = new JButton("Nouveau client");
cli.setPreferredSize(new Dimension(200, 20));
cli.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
	
			new Controller_Client();
	
	}
	
});

JButton recap = new JButton("Récapitulatif");
recap.setPreferredSize(new Dimension(200, 20));
recap.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent arg0) {
	
		DAORecapitulatif Recapitulatif =new DAORecapitulatif(JDBC.getConnection());
		Recapitulatif.Recapitulatif();
	
	}
	
});

JButton search = new JButton("Recherche");
search.setPreferredSize(new Dimension(200, 20));

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
premiere_couche.setPreferredSize(new Dimension(350, 380));
premiere_couche.setBackground(Color.white);




JLabel vide = new JLabel("                                    ");
vide.setPreferredSize(new Dimension(600, 20));
premiere_couche.add(vide);
premiere_couche.add(cli);
premiere_couche.add(contra);
premiere_couche.add(facture);
premiere_couche.add(recap);
premiere_couche.add(actualiser);
premiere_couche.add(panlib);
premiere_couche.add(panlib2);
premiere_couche.add(panlib4);
//premiere_couche.add(panlib3);



/**/
// LISTE CONTRAT

//FERMER

fermer.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}				
});



/**/change_onglet.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		if(gauche) {
		p.setTabPlacement(1);
		gauche=false;
		haut = true;
		
		}
		else if(haut){
			p.setTabPlacement(2);
			haut=false;
			gauche=false;
			droite=false;
			bas=true;
			
		}
		else if(bas){
			p.setTabPlacement(3);
			bas=false;
			haut=false;
			gauche=false;
			droite=true;
			
		}
		else if(droite){
			p.setTabPlacement(4);
			droite=false;
			bas=false;
			haut=false;
			gauche=true;
			
		}
	}				
});




JLabel jlb = new JLabel(new ImageIcon("images/accueil_cls.jpg"));
jlb.setPreferredSize(new Dimension(300, 320));
contient.setBackground(Color.white);
JPanel doubl = new JPanel();
doubl.add(jlb);
doubl.add(premiere_couche);
doubl.setBackground(Color.white);
initToolBar();
contient.add(doubl,  BorderLayout.CENTER);
contient.setBackground(Color.white);



p = new JTabbedPane(onglet);

p.add("",contient);
p.setIconAt(0, new ImageIcon("images/tbord.png"));
p.add("", new Onglet_Client());
p.setIconAt(1, new ImageIcon("images/client.png"));
p.add("", new Onglet_Contrat());
p.setIconAt(2, new ImageIcon("images/contrat.png"));
p.add("Intervention", new Onglet_Intervention());
//p.setIconAt(3, new ImageIcon("images/facture.png"));

menu.setBackground(Color.white);
p.setBackground(Color.white);
split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menu,p);
split.setOneTouchExpandable(true);
split.setBackground(Color.white);


this.setContentPane(split);

	
	}
	public class Background extends JPanel {
		 
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g){
	            try {
	                    Image img = ImageIO.read(new File("images/fond2.jpg"));
	                     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	            } catch (IOException e) {
	                  
	                    e.printStackTrace();
	            }
	            
	    }               
	}	
	
	public class Background2 extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		 
	                
	}	
	public static void main(String[] args) throws UnknownHostException, MalformedURLException, RemoteException, NotBoundException, InterruptedException{
	
		if(true){
	chargement wind = new chargement();
		wind.setVisible(true);
		
		}
		}
	  private JToolBar toolBar = new JToolBar();
	 /**/ private JButton 	misepage = new JButton(new ImageIcon("images/mise_page.png")),
	  
	 
	  impression = new JButton(new ImageIcon("images/imprimer.png")),
	  recherche = new JButton(new ImageIcon("images/search.png")),
	  
	  liste_cli= new JButton(new ImageIcon("images/cli.png")),
	  liste_cont= new JButton(new ImageIcon("images/icone_contra.jpg")),
	  liste_inter= new JButton(new ImageIcon("images/inter.png")),
	  modif = new JButton(new ImageIcon("images/modifier.png")),
	  change_onglet = new JButton(new ImageIcon("images/change_onglet.jpg")),
	  client = new JButton(new ImageIcon("images/new_cli.png")),
	  icone_contrat = new JButton(new ImageIcon("images/new_cont.png")),
	  icone_facture = new JButton(new ImageIcon("images/intervention.png"));
	  
	  
	  
	  
	  
private Color fondBouton = Color.white;

	 private void initToolBar(){
	    	
		 client.setToolTipText("Nouveau client");
		 icone_facture.setToolTipText("Nouvelle intervention");
		 icone_contrat.setToolTipText("Nouveau contrat");
		 change_onglet.setToolTipText("Changer la position de l'onglet");
		 modif.setToolTipText("Modifier Client/Contrat/Intervention");
		 liste_cli.setToolTipText("liste de tout les clients");
		 liste_cont.setToolTipText("Liste de tout les contrats");
		 liste_inter.setToolTipText("Liste de toute les interventions");
		 misepage.setToolTipText("Aperçu avant impression");
		 impression.setToolTipText("Imprimer");
		 recherche.setToolTipText("Recherche Client/Contrat/Intervention");
		 
		 
		 	horloge = new JTextField();
		 	horloge.setBackground(Color.white);
			horloge.setForeground(Color.black);
			horloge.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 34));
			horloge.setEditable(false);
			horloge.setBounds(10, 11, 156, 36);
			this.toolBar.add(horloge);
			horloge.setColumns(5);
			
			Timer t = new Timer(1000, new ClockListener());
			t.start();
			
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
		 
			this.toolBar.add(change_onglet);
		 	this.change_onglet.setBackground(fondBouton);
			
		 	this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
		 
			this.client.setBackground(fondBouton);
			this.toolBar.add(client);
			this.toolBar.add(icone_contrat);
			this.toolBar.add(icone_facture);
			this.icone_contrat.setBackground(fondBouton);
			this.icone_facture.setBackground(fondBouton);
	  
			
			
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
		
			
			
			//this.toolBar.add(recherche);
			//this.toolBar.add(modif);
			
			//this.toolBar.addSeparator();
			
	    	//this.toolBar.add(misepage);
	    	//this.toolBar.add(impression);
	   	
	    	this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
			this.toolBar.addSeparator();
		
	 
	    	this.toolBar.add(liste_cli);
	    	this.toolBar.add(liste_cont);
	    	this.toolBar.add(liste_inter);
	    	this.liste_cli.setBackground(fondBouton);
	    	this.liste_cont.setBackground(fondBouton);
	    	this.liste_inter.setBackground(fondBouton);
	    	
	    	
	    	this.toolBar.addSeparator();
		
	    	
	    	this.modif.setBackground(fondBouton);
	    	this.recherche.setBackground(fondBouton);
	    	this.misepage.setBackground(fondBouton);
	    	this.impression.setBackground(fondBouton);
	    	
	    	
	    	
	    	
	    	
	    	
	    	this.toolBar.addSeparator();
	    	this.toolBar.addSeparator();
	    
	    
	    	toolBar.setBackground(Color.white);
	    	menu.add(toolBar, BorderLayout.CENTER);
	    	menu.setPreferredSize(new Dimension(600, 50));
	    	
	    	//Ajout des Listeners
	    
	    	client.addActionListener(new ActionListener(){

	    		public void actionPerformed(ActionEvent arg0) {
	    		
	    				new Controller_Client();
	    		
	    		}
	    		
	    	});
	    	
			icone_facture.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
					new Controller_Intervention();
					
				}
				
			});
			
			icone_contrat.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
					new Controller_Contrat();
					
				}
				
			});
			
			 
			liste_cli.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
					DAOListeClient LClient =new DAOListeClient(JDBC.getConnection());
					LClient.ListeClient();
				
				}
				
			});
			
			liste_cont.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
					DAOListeContrat LContrat =new DAOListeContrat(JDBC.getConnection());
					LContrat.ListeContrat();
				
				}
				
			});
			
			liste_inter.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent arg0) {
				
					DAOListeIntervention LIntervention =new DAOListeIntervention(JDBC.getConnection());
					LIntervention.ListeIntervention();
				
				}
				
			});
			  
			/*misepage.setToolTipText("Aperçu avant impression");
			impression.setToolTipText("Imprimer");*/

			recherche.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					new Controller_Recherche();								
				}
				
			});
			 
			modif.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					new Controller_Modif();
				}
				
			});
	    
		 	impression.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					new Imprimante();
				}
				
			});
	 	
	 
	 }
	
	
	 class ClockListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
				horloge.setText(df.format(Calendar.getInstance().getTime()));
			}
		}
}



