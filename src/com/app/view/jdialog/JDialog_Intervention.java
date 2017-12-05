package com.app.view.jdialog;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.jdesktop.swingx.JXSearchField;
import org.jdesktop.swingx.JXSearchField.LayoutStyle;

import com.app.dao.DAONombre;
import com.app.dao.DAOSearch;
import com.app.dao.JDBC;
import com.app.entity.Intervention;
import com.app.view.ButtonColor;
import com.toedter.calendar.JDateChooser;

import com.app.listeners.CRUDListner;

public class JDialog_Intervention extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JTextField nomclientField;
	private JTextField nomtechnicienField;
	private JFormattedTextField dureeField;
	private JFormattedTextField HdebutField;
	private JFormattedTextField HfinField;
	private JFormattedTextField tpsrestantField;
	private JFormattedTextField tpstotalField;
	private JFormattedTextField reportField;
	private JTextField numinterventionField;
	private JTextField numcontratField;
	private JTextField statutField;
	private JTextField horloge;
	
	private JButton ajouter;
	private JButton supprimer;
	private JButton modifier;
	

	private JLabel nomclient;
	private JLabel numintervention;
	private JLabel dateintervention;
	private JLabel nomtechnicien;
	private JLabel Hdebut;
	private JLabel Hfin;
	

	private JXSearchField searchField;
	private JScrollPane scrollPane;
	private JTable table;

	private JDateChooser chooser;

	private DefaultTableModel dt;
	
	private CRUDListner controller;

	private static int nintervention = 0;
	private Object nom =null;
	private int numc =0;
	private String tempsrt=null;
	private String forfait=null;
	
	private String[] tabContenu;
	private JComboBox<String> lClient;
	
	public String getNomclient() {
		return nomclientField.getText();
	}

	public String getDtIntervention() throws DataFormatException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		Date inDate = null;
		inDate = chooser.getDate();
		try {
			inDate = dateFormat.parse((dateFormat.format(inDate)).trim());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateFormat.format(inDate);
	}

	public String getNumintervention() {
		return numinterventionField.getText();
	}
	
	public String getNomtechnicien() {
		return nomtechnicienField.getText();
	}

	public String getTemps() {
		return dureeField.getText();
	}
	
	public String getHoursFin()
	{
		return HfinField.getText();
	}
	
	public String getHoursDebut()
	{
		return HdebutField.getText();
	}
	
	public String getRestant()
	{
		return tpsrestantField.getText();
	}
	
	public String getTotal()
	{
		return tpstotalField.getText();
	}
	
	public String getReport()
	{
		return reportField.getText();
	}
	
	public String getNumcontrat()
	{
		return numcontratField.getText();
	}
	
	public String getStatut() {
		return statutField.getText();
	}
	
	public String getSearchField() {
		return searchField.getText();
	}
	
	public JDialog_Intervention() {
		
	
	
		// set the position of the window
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLocationRelativeTo(null);
		setResizable(true);
		Point p = new Point(200, 200);
		setLocation(p.x, p.y);
			
		    ajouter = new ButtonColor("Ajout", Color.BLACK);
			ajouter.setFont(new Font("Tahoma", Font.BOLD, 14));
			ajouter.setBounds(10, 416, 227, 23);
			getContentPane().add(ajouter);
			ajouter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						if(validIntervention()==true){
							searchContrat();
							CalculHoraire();
							CalculHoraireRestant();
							CalculHoraireTotal();
							CalculHoraireReport();
							StatutContrat();
							modifyTemps(getTotal(), getRestant(),getReport(),getStatut());
						AddFacture();
						numinterventionField.setText("");
						chooser.setDate(new Date());
						nomtechnicienField.setText("");
						HdebutField.setText("");
						HfinField.setText("");
						}
					} catch (DataFormatException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			numintervention = new JLabel("BLM");
			numintervention.setBounds(10, 133, 99, 14);
			getContentPane().add(numintervention);
			
			nomclient = new JLabel("Nom Client");
			nomclient.setBounds(10, 179, 79, 14);
			getContentPane().add(nomclient);
			
			dateintervention = new JLabel("Date");
			dateintervention.setBounds(10, 221, 89, 14);
			getContentPane().add(dateintervention);
			
			chooser = new JDateChooser();
			chooser.setLocale(Locale.FRANCE);
			chooser.setBounds(109, 218, 128, 20);

			getContentPane().add(chooser);
			
			nomtechnicien = new JLabel("Technicien");
			nomtechnicien.setBounds(10, 263, 79, 14);
			getContentPane().add(nomtechnicien);
			
			Hdebut = new JLabel("Heure Départ");
			Hdebut.setBounds(11, 301, 78, 14);
			getContentPane().add(Hdebut);
			
			Hfin = new JLabel("Heure Arrivée");
			Hfin.setBounds(11, 341, 78, 14);
			getContentPane().add(Hfin);
			
			
			DAONombre Nuintervention=new DAONombre(JDBC.getConnection());
			nintervention= Nuintervention.NumIntervention(nintervention);
			nintervention++;
			
			numinterventionField = new JTextField(""+nintervention);
			numinterventionField.setBounds(109, 130, 128, 20);
			getContentPane().add(numinterventionField);
			numinterventionField.setColumns(10);
			
			/*nomclientField = new JTextField();
			nomclientField.setBounds(109, 176, 128, 20);
			getContentPane().add(nomclientField);
			nomclientField.setColumns(10);*/
			
			
			
			DAOSearch nclient=new DAOSearch(JDBC.getConnection());
			lClient=nclient.findClient();
			
			
		//tabClient = new JComboBox();
		lClient.setBounds(109, 178, 128, 20);
		getContentPane().add(lClient);
		
		lClient.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nom=lClient.getSelectedItem();
				System.out.println("Choix: "+nom);
				nomclientField = new JTextField();
				nomclientField.setText(""+nom);
				searchContrat();
			}
			
		});
			
			
			
			
			
			

			nomtechnicienField = new JTextField();
			nomtechnicienField.setBounds(109, 260, 108, 20);
			getContentPane().add(nomtechnicienField);
			nomtechnicienField.setColumns(10);
			
						
			HdebutField = new JFormattedTextField();
			HdebutField.setBounds(109, 298, 128, 20);
			 try {
		            MaskFormatter heureMask = new MaskFormatter("##:##");
		            heureMask.install(HdebutField);
		        } catch (ParseException ex) {
		            Logger.getLogger(JDialog_Intervention.class.getName()).log(Level.SEVERE, null, ex);
		        }
			getContentPane().add(HdebutField);
			HdebutField.setColumns(10);
			
			HfinField = new JFormattedTextField();
			HfinField.setBounds(109, 335, 128, 20);
			 try {
		            MaskFormatter heureMask = new MaskFormatter("##:##");
		            heureMask.install(HfinField);
		        } catch (ParseException ex) {
		            Logger.getLogger(JDialog_Intervention.class.getName()).log(Level.SEVERE, null, ex);
		        }
			getContentPane().add(HfinField);
			HfinField.setColumns(10);
			

			supprimer = new ButtonColor("Supprimer", Color.BLACK);
			supprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
			supprimer.setBounds(360, 39, 115, 23);
			getContentPane().add(supprimer);
			supprimer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
//					tabContenu = tableContent();
//					if (tabContenu.length == 6)
//						removeSearch();
					if (getSearchField().length() == 8) {
						removeSearch();
						showOntableSearch();
					}

				}
			});

			modifier = new ButtonColor("Modifier", Color.BLACK);
			modifier.setFont(new Font("Tahoma", Font.BOLD, 12));
			modifier.setBounds(480, 39, 99, 23);
			getContentPane().add(modifier);
			modifier.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					tabContenu = tableContent();
//					if (tabContenu.length == 6)
//						modifyStagiaire(tabContenu);
					if (getSearchField().length() == 8)
						modifyFacture(tabContenu);
				}
			});
			

			searchField = new JXSearchField("N°Contrat");
			searchField.setBounds(400, 11, 148, 20);
			searchField.setColumns(10);
			searchField.setLayoutStyle(LayoutStyle.MAC);
			getContentPane().add(searchField);
			searchField.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (searchField.getText().length() == 8)
						searchFacture();
				}
			});
			
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(247, 90, 539, 300);
			getContentPane().add(scrollPane);

			table = new JTable();
			table.setRowHeight(34);
			table.setFont(new Font("Tahoma", Font.BOLD, 12));
			table.setForeground(Color.BLACK);
			dt = new DefaultTableModel(new Object[][] {},
					new String[] { "BLM","Date Intervention","Technicien","Debut","fin","Duree","N°Contrat" });
			table.setModel(dt);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
			Dimension d = table.getPreferredSize();
			table.setPreferredScrollableViewportSize(d);
			table.setFillsViewportHeight(true);
		
			setContentPane(getContentPane());
			getContentPane().setLayout(null);
		
			//messagePane.add(new JLabel(message));
		// get content pane, which is usually the
		// Container of all the dialog's components.
		//getContentPane().add(messagePane);

		// Create a button
		JPanel buttonPane = new JPanel();
		JButton button = new JButton("Close me");
		buttonPane.add(button);
		// set action listener on the button
		button.addActionListener(new MyActionListener());
		getContentPane().add(buttonPane, BorderLayout.PAGE_END);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	// override the createRootPane inherited by the JDialog, to create the rootPane.
	// create functionality to close the window when "Escape" button is pressed
	public JRootPane createRootPane() {
		JRootPane rootPane = new JRootPane();
		KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
		Action action = new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		};
		InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(stroke, "ESCAPE");
		rootPane.getActionMap().put("ESCAPE", action);
		return rootPane;
	}

	// an action listener to be used when an action is performed
	// (e.g. button is pressed)
	class MyActionListener implements ActionListener {

		//close and dispose of the window.
		public void actionPerformed(ActionEvent e) {
			//System.out.println("disposing the window..");
			setVisible(false);
			dispose();
		}
	}

	private void searchFacture() {
		if (getSearchField() != null) {
			if (controller != null) {
				nintervention = ConvertCin(searchField.getText());
				if (nintervention != 0)
					controller.SearchPerformed(nintervention);
			}

		}
	}

	private void searchContrat() {
		DAOSearch ncontrat=new DAOSearch(JDBC.getConnection());
		int num = ncontrat.findContrat(getNomclient());
		numc=num;
		Tempsrestant();
		Tempstotal();
	}

	
	private void Tempsrestant() {
		DAOSearch tpsrestant=new DAOSearch(JDBC.getConnection());
		String tpsr = tpsrestant.TempsRestant(getNomclient(), numc);
		tempsrt=tpsr;
	}
	
	private void Tempstotal() {
		DAOSearch tpstotal=new DAOSearch(JDBC.getConnection());
		System.out.println("NUMC :"+numc);
		String total = tpstotal.TempsTotal(getNomclient(), numc);
		forfait=total;
	}
	private void removeSearch() {
		if (controller != null) {
			nintervention = ConvertCin(getSearchField());
			if (nintervention != 0)
				controller.removePerformed(nintervention);
		}
	}

	private void AddFacture() throws DataFormatException {
	if (getNumintervention() != null  && getNomtechnicien() != null 
			&& getHoursDebut()!=null && getHoursFin()!=null &&
			getTemps()!=null
				) {
			if (controller != null) {
				nintervention = ConvertCin(getNumintervention());
				if (nintervention != 0)
					controller.addPerformed(new Intervention(nintervention, getDtIntervention(), getNomtechnicien(),
							getHoursDebut(), getHoursFin(),getTemps(),numc));
			}

		}
	}
	
	private void modifyTemps(String total, String restant, String report, String statut) {
		if (getSearchField() != null) {
			if (controller != null) {
				numc = ConvertCin1(getSearchField());
				if (numc != 0)
					controller.modifyPerformed(numc, total, restant, report, statut);
			}

		}
	}
	
	private void modifyFacture(String[] tabContenu) {
		if (getSearchField() != null) {
			if (controller != null) {
				nintervention = ConvertCin(getSearchField());
				if (nintervention != 0)
					controller.modifyPerformed(nintervention, tabContenu);
			}

		}
	}

	private int ConvertCin1(String cin) {
		try {
			if (!cin.isEmpty()) {
				if (!cin.matches("^\\d+$"))
					JOptionPane.showMessageDialog(this, "N° Contrat doit etre des chiffres");
				numc = Integer.parseInt(cin);
			} 
			} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return numc;

	}
	
	private int ConvertCin(String cin) {
		try {
			if (!cin.isEmpty()) {
				if (!cin.matches("^\\d+$"))
					JOptionPane.showMessageDialog(this, "N° Contrat doit etre des chiffres");
				nintervention = Integer.parseInt(cin);
			} else
				JOptionPane.showMessageDialog(this, "N° Contrat doit etre 8 chiffres");
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return nintervention;

	}

	class ClockListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
			horloge.setText(df.format(Calendar.getInstance().getTime()));
		}
	}

	public void setRetieveListner(CRUDListner controllerR) {
		this.controller = controllerR;
	}

	public void addPerformed(CRUDListner controllerA) {
		this.controller = controllerA;
	}

	public void showOntable(Intervention intervention) {
		Object[] tableau = {intervention.getIdintervention(), intervention.getDateintervention(),intervention.getTechnicien(), intervention.getDuree()};
		dt.addRow(tableau);
	}

	public void showOntableSearch(Object[] facture) {
		if (table.getRowCount() >= 1)
			for (int i = 0; i < dt.getRowCount(); i++)
				dt.removeRow(i);
		dt.addRow(facture);
	}

	private void showOntableSearch() {
		if (table.getRowCount() >= 1)
			for (int i = 0; i < dt.getRowCount(); i++)
				dt.removeRow(i);
	}

	private String[] tableContent() {
		tabContenu = new String[6];
		for (int i = 0; i < table.getColumnCount(); i++) {
			Object valeur = table.getValueAt(0, i);
			if (valeur != null)
				tabContenu[i] = valeur.toString();
		}
		return tabContenu;
	}
	
	private void StatutContrat(){
		
		System.out.println("TPS TOTAL: "+getTotal());
		System.out.println("TPS RESTANT: "+getRestant());
		System.out.println("FORFAIT : "+forfait);
		if(getTotal().equals(forfait))
		{
			
			statutField = new JFormattedTextField();
			statutField.setText("Inactif");
			System.out.println("StatutInactif: "+statutField.getText());
		}
		else
		{
			statutField = new JFormattedTextField();
			statutField.setText("Actif");
			System.out.println("StatutActif: "+statutField.getText());
		}
	}
	
	private void CalculHoraireReport(){
		
		 SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		 Date tempsforfait = null;
		 Date tempstotal = null;
       
       
       try { 
       	tempstotal = format.parse(getTotal());
       	tempsforfait = format.parse(forfait);
       } 
       catch (ParseException e) 
       { 
       	e.printStackTrace(); 
       } 
       long forfait = tempsforfait.getTime();
       long tpstotal = tempstotal.getTime();
       
       if(tpstotal > forfait){
       
    	statutField = new JFormattedTextField();
    	statutField.setText("Hors Forfait");
    	System.out.println("StatutReport: "+statutField.getText());
    	   
       long report = tempstotal.getTime()-tempsforfait.getTime();
       long diffMinutesreport = (report / (60 * 1000)%60);
       long diffHoursreport = report / (60 * 60 * 1000);
       
       
       if(diffHoursreport < 10 && diffMinutesreport < 10)
       {
    	   reportField = new JFormattedTextField();
    	   reportField.setText("0"+diffHoursreport+":0"+diffMinutesreport+":00");
       }
       
       else if(diffHoursreport >= 10 && diffMinutesreport < 10)
       {
    	   reportField = new JFormattedTextField();
       	reportField.setText(diffHoursreport+":0"+diffMinutesreport+":00");
      	 
       }
       
       else if(diffHoursreport < 10 && diffMinutesreport >= 10)
       {
    	   reportField = new JFormattedTextField();
       	reportField.setText("0"+diffHoursreport+":"+diffMinutesreport+":00");
      
       }
       
       else
       {	
    	   reportField = new JFormattedTextField();
       	reportField.setText(diffHoursreport+":"+diffMinutesreport+":00");

       }
      }
       else{
    	   reportField = new JFormattedTextField();
          	reportField.setText("00:00:00");
       }
                
	}
	
	
	
	
	private void CalculHoraireTotal(){
		
		 SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date tempsrestant = null;
        Date tempstotal = null;
        
        
        try { 
        	tempsrestant = format.parse(tpsrestantField.getText());
        	tempstotal = format.parse(forfait);
        	//report = format.parse();
        } 
        catch (ParseException e) 
        { 
        	e.printStackTrace(); 
        } 
        
        long total = tempstotal.getTime()-tempsrestant.getTime();
        long diffMinutestotal = (total / (60 * 1000)%60);
        long diffHourstotal = total / (60 * 60 * 1000);
        
        
        if(diffHourstotal < 10 && diffMinutestotal < 10)
        {
        	tpstotalField = new JFormattedTextField();
        	tpstotalField.setText("0"+diffHourstotal+":0"+diffMinutestotal+":00");
        }
        
        else if(diffHourstotal >= 10 && diffMinutestotal < 10)
        {
        	tpstotalField = new JFormattedTextField();
        	tpstotalField.setText(diffHourstotal+":0"+diffMinutestotal+":00");
       	 
        }
        
        else if(diffHourstotal < 10 && diffMinutestotal >= 10)
        {
        	tpstotalField = new JFormattedTextField();
        	tpstotalField.setText("0"+diffHourstotal+":"+diffMinutestotal+":00");
       
        }
        
        else
        {	
        	tpstotalField = new JFormattedTextField();
        	tpstotalField.setText(diffHourstotal+":"+diffMinutestotal+":00");

        }
                 
	}
	
	private void CalculHoraireRestant(){
		
		 SimpleDateFormat format = new SimpleDateFormat("HH:mm");
       Date duree=null;
       Date tempsrestant = null;
       
       
       try { 
       	duree = format.parse(dureeField.getText()); 
       	tempsrestant = format.parse(tempsrt);
       } 
       catch (ParseException e) 
       { 
       	e.printStackTrace(); 
       } 
       
       long restant = tempsrestant.getTime()-duree.getTime();
       long diffMinutesrestant = (restant / (60 * 1000)%60);
       long diffHoursrestant = restant / (60 * 60 * 1000);
       
       
       if(diffHoursrestant < 10 && diffMinutesrestant < 10)
       {
    	tpsrestantField = new JFormattedTextField();
    	tpsrestantField.setText("0"+diffHoursrestant+":0"+diffMinutesrestant+":00");
       }
       
       else if(diffHoursrestant >= 10 && diffMinutesrestant < 10)
       {
    	   tpsrestantField = new JFormattedTextField();
       	tpsrestantField.setText(diffHoursrestant+":0"+diffMinutesrestant+":00");
       	 
       }
       
       else if(diffHoursrestant < 10 && diffMinutesrestant >= 10)
       {
    	   tpsrestantField = new JFormattedTextField();
       	tpsrestantField.setText("0"+diffHoursrestant+":"+diffMinutesrestant+":00");
      
       }
       
       else
       {	
    	   tpsrestantField = new JFormattedTextField();
       	tpsrestantField.setText(diffHoursrestant+":"+diffMinutesrestant+":00");
       	
       }
                   
	}
	
	private void CalculHoraire(){
		
		 SimpleDateFormat format = new SimpleDateFormat("HH:mm");
         Date d1 = null; Date d2 = null;
         
         
         try { 
         	d1 = format.parse(HdebutField.getText()); 
         	d2 = format.parse(HfinField.getText());
         	
         } 
         catch (ParseException e) 
         { 
         	e.printStackTrace(); 
         } 
         
         long diff = d2.getTime() - d1.getTime(); 
         long diffMinutes = (diff / (60 * 1000)%60);
         long diffHours = diff / (60 * 60 * 1000);
         
         
         if(diffHours < 10 && diffMinutes < 10)
         {
        	dureeField = new JFormattedTextField();
         	dureeField.setText("0"+diffHours+":0"+diffMinutes+":00");
         }
         
         else if(diffHours >= 10 && diffMinutes < 10)
         {
        	 dureeField = new JFormattedTextField();
        	 dureeField.setText(diffHours+":0"+diffMinutes+":00");
        	 
         }
         
         else if(diffHours < 10 && diffMinutes >= 10)
         {
        	 dureeField = new JFormattedTextField();
        	 dureeField.setText("0"+diffHours+":"+diffMinutes+":00");
        
         }
         
         else
         {	
        	 dureeField = new JFormattedTextField();
        	 dureeField.setText(diffHours+":"+diffMinutes+":00");
         	
         }
                  
	}
		
	
	public boolean validIntervention() {
		if(!getNomtechnicien().equals("") && !getHoursDebut().equals("  :  ") 
				&& !getHoursFin().equals("  :  "))
		{
			return true;
		}
		else{
			
			
			if(getNomtechnicien().equals("")){
				JOptionPane.showMessageDialog(null, "Champ "+ nomtechnicien.getText() +" non renseigné", "Message d’avertissement",
						JOptionPane.ERROR_MESSAGE);
				}
			if(getHoursDebut().equals("  :  ")){
				JOptionPane.showMessageDialog(null, "Champ "+ Hdebut.getText() +" non renseigné", "Message d’avertissement",
					JOptionPane.ERROR_MESSAGE);
				}
			if(getHoursFin().equals("  :  ")){
				JOptionPane.showMessageDialog(null, "Champ "+ Hfin.getText() +" non renseigné", "Message d’avertissement",
					JOptionPane.ERROR_MESSAGE);
				}
			return false;
		}
	}
}