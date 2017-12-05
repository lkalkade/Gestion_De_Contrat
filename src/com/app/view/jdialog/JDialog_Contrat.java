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
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

import com.app.view.ButtonColor;
import com.toedter.calendar.JDateChooser;
import com.app.dao.DAONombre;
import com.app.dao.DAOSearch;
import com.app.dao.JDBC;
import com.app.entity.Contrat;
import com.app.listeners.CRUDListner;

public class JDialog_Contrat extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField numcontratField;
	private JTextField nomclientField;
	private JTextField typecontratField;
	private JFormattedTextField forfaitField;
	private JTextField deplacementField;
	
	private JButton ajouter;
	private JButton supprimer;
	private JButton modifier;
	
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton Oui = new JRadioButton("Oui");
	private JRadioButton Non = new JRadioButton("Non");

	private JLabel numcontrat;
	private JLabel nomclient;
	private JLabel datecontrat;
	private JLabel typecontrat;
	private JLabel forfait;
	private JLabel deplacement;

	private JXSearchField searchField;
	private JScrollPane scrollPane;
	private JTable table;

	private CRUDListner controller;

	private static int ncontrat = 0;
	private Object nom =null;
	
	private String dplt = null;
	private Object Type =null;
	private JDateChooser chooser;

	private DefaultTableModel dt;

	private String[] tabContenu;
	private String[] tabtype = {"Ciel", "Sage", "Materiel", "Logiciel"};
	private JComboBox<String> lClient;
	
	private JComboBox<?> combotype;
	
	public String getNContrat() {
		return numcontratField.getText();
	}

	public String getDtContrat() throws DataFormatException {
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

	public String getTpContrat() {
		return typecontratField.getText();
	}
	
	public String getNclient() {
		return nomclientField.getText();
	}

	public String getForfait() {
		return forfaitField.getText();
	}
	
	public String getTpsrestant(){
		return "";
	}
	
	public String getTpstotal(){
		return "";
	}
	
	public String getReport(){
		return "";
	}
	
	public String getDplt() {
		return deplacementField.getText();
	}
	
	public String getSearchField() {
		return searchField.getText();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JDialog_Contrat() {
		
		
	
		
		// set the position of the window
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLocationRelativeTo(null);
		setResizable(true);
		Point p = new Point(30, 100);
		setLocation(p.x, p.y);
		
			
		ajouter = new ButtonColor("Ajout", Color.BLACK);
		ajouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		ajouter.setBounds(10, 366, 227, 23);
		getContentPane().add(ajouter);
		ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					AddContrat();
					numcontratField.setText("");
					//nomclientField.setText("");
					chooser.setDate(new Date());
					typecontratField.setText("");
					forfaitField.setText("");
					deplacementField.setText("");
					
				} catch (DataFormatException e1) {
					e1.printStackTrace();
				}
				
			}
		});

		
		nomclient = new JLabel("Nom Client");
		nomclient.setBounds(10, 133, 99, 14);
		getContentPane().add(nomclient);
		
		numcontrat = new JLabel("N° Contrat");
		numcontrat.setBounds(10, 179, 79, 14);
		getContentPane().add(numcontrat);
		
		datecontrat = new JLabel("Date Contrat");
		datecontrat.setBounds(10, 221, 89, 14);
		getContentPane().add(datecontrat);
		
		chooser = new JDateChooser();
		chooser.setLocale(Locale.FRANCE);
		chooser.setBounds(109, 218, 128, 20);

		getContentPane().add(chooser);
		
		typecontrat = new JLabel("Type Contrat");
		typecontrat.setBounds(10, 263, 79, 14);
		getContentPane().add(typecontrat);
		
		forfait = new JLabel("Forfait");
		forfait.setBounds(11, 301, 78, 14);
		getContentPane().add(forfait);
		
		deplacement = new JLabel("Deplacement");
		deplacement.setBounds(11, 336, 99, 14);
		getContentPane().add(deplacement);
		
		
		nomclientField = new JTextField();
		/*nomclientField.setBounds(109, 130, 128, 20);
		getContentPane().add(nomclientField);
		nomclientField.setColumns(10);*/
		DAOSearch nclient=new DAOSearch(JDBC.getConnection());
		lClient=nclient.listeClient();
		
		
	//tabClient = new JComboBox();
	lClient.setBounds(109, 130, 128, 20);
	getContentPane().add(lClient);
	
	lClient.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			nom=lClient.getSelectedItem();
			System.out.println("Choix: "+nom);
			nomclientField = new JTextField();
			nomclientField.setText(""+nom);
		}
		
	});
		
		
		
		DAONombre NbContrat=new DAONombre(JDBC.getConnection());
		ncontrat= NbContrat.NumContrat(ncontrat);
		ncontrat++;
		numcontratField = new JTextField(""+ncontrat);
		numcontratField.setBounds(109, 176, 128, 20);
		getContentPane().add(numcontratField);
		numcontratField.setColumns(10);
		
		

		typecontratField = new JTextField();
		typecontratField.setBounds(109, 260, 108, 20);
		getContentPane().add(typecontratField);
		typecontratField.setColumns(10);
		
		combotype = new JComboBox(tabtype);
		combotype.setBounds(109, 260, 128, 20);
		getContentPane().add(combotype);
		
		combotype.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Type=combotype.getSelectedItem();
				typecontratField.setText((String) Type);
			}
			
		});

		forfaitField = new JFormattedTextField();
		forfaitField.setBounds(109, 298, 128, 20);
		try {
            MaskFormatter heureMask = new MaskFormatter("##:##");
            heureMask.install(forfaitField);
        } catch (ParseException ex) {
            Logger.getLogger(JDialog_Contrat.class.getName()).log(Level.SEVERE, null, ex);
        }
		getContentPane().add(forfaitField);
		forfaitField.setColumns(10);
	
	
		deplacementField = new JTextField();
		
		bg.add(Oui);
	    bg.add(Non);
		Oui.setBounds(109, 333, 64, 20);
		Non.setBounds(173, 333, 64, 20);
		getContentPane().add(Oui);
		getContentPane().add(Non);
		Oui.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dplt=Oui.getText();
				deplacementField.setText(dplt);
			}
			
		});
		
		Non.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dplt=Non.getText();
				deplacementField.setText(dplt);
			}
			
		});

		supprimer = new ButtonColor("Supprimer", Color.BLACK);
		supprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		supprimer.setBounds(360, 39, 115, 23);
		getContentPane().add(supprimer);
		supprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				tabContenu = tableContent();
//				if (tabContenu.length == 6)
//					removeSearch();
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
//				if (tabContenu.length == 6)
//					modifyStagiaire(tabContenu);
				if (getSearchField().length() == 8)
					modifyContrat(tabContenu);
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
					searchContrat();
			}
		});
		scrollPane = new JScrollPane();
		scrollPane.setBounds(247, 90, 939, 300);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setRowHeight(34);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setForeground(Color.BLACK);
		dt = new DefaultTableModel(new Object[][] {},
				new String[] { "N° Contrat","Client","Contrat Etabli","Type Contrat","Forfait","Deplacement","Temps Restant","Temps Total","Report","Statut" });
		table.setModel(dt);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		Dimension d = table.getPreferredSize();
		table.setPreferredScrollableViewportSize(d);
		table.setFillsViewportHeight(true);

		
			setContentPane(getContentPane());
			getContentPane().setLayout(null);

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
				System.out.println("escaping..");
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
	private void searchContrat() {
		if (getSearchField() != null) {
			if (controller != null) {
				ncontrat = ConvertCin(searchField.getText());
				if (ncontrat != 0)
					controller.SearchPerformed(ncontrat);
			}

		}
	}

	private void removeSearch() {
		if (controller != null) {
			ncontrat = ConvertCin(getSearchField());
			if (ncontrat != 0)
				controller.removePerformed(ncontrat);
		}
	}

	private void AddContrat() throws DataFormatException {
		if(validContrat()== true){
			if (getNContrat() != null && getTpContrat() != null && getForfait() != null
				&& getDplt() != null) {
				if (controller != null) {
					ncontrat = ConvertCin(getNContrat());
					if (ncontrat != 0)
						controller.addPerformed(new Contrat(ncontrat, getNclient(), getDtContrat(), getTpContrat(),
							getForfait(), getDplt()));
				}
			}
		}
	}

	private void modifyContrat(String[] tabContenu) {
		if (getSearchField() != null) {
			if (controller != null) {
				ncontrat = ConvertCin(getSearchField());
				if (ncontrat != 0)
					controller.modifyPerformed(ncontrat, tabContenu);
			}

		}
	}

	private int ConvertCin(String cin) {
		try {
			if (!cin.isEmpty()) {
				if (!cin.matches("^\\d+$"))
					JOptionPane.showMessageDialog(this, "N° Contrat doit etre des chiffres");
				ncontrat = Integer.parseInt(cin);
			} else
				JOptionPane.showMessageDialog(this, "N° Contrat doit etre 8 chiffres");
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return ncontrat;

	}


	public void setRetieveListner(CRUDListner controllerR) {
		this.controller = controllerR;
	}

	public void addPerformed(CRUDListner controllerA) {
		this.controller = controllerA;
	}

	public void showOntable(Contrat contrat) {
		Object[] tableau = { contrat.getId(), contrat.getDateContrat(),contrat.getTypeContrat(), contrat.getForfaits(),
				 contrat.getDeplacement() };
		dt.addRow(tableau);
	}

	public void showOntableSearch(Object[] contrat) {
		if (table.getRowCount() >= 1)
			for (int i = 0; i < dt.getRowCount(); i++)
				dt.removeRow(i);
		dt.addRow(contrat);
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
	
	public boolean validContrat(){
		if(!getNclient().equals("") &&  !getTpContrat().equals("") &&
				!getForfait().equals("") && !getDplt().equals(""))
		{
			return true;
		}
		else{
			numcontratField = new JTextField(""+ncontrat);
			if(getNclient().equals("")){
				JOptionPane.showMessageDialog(null, "Champ "+ nomclient.getText() +" non renseigné", "Message d’avertissement",
					JOptionPane.ERROR_MESSAGE);
				}
			
			if(getTpContrat().equals("")){
				JOptionPane.showMessageDialog(null, "Champ "+ typecontrat.getText() +" non renseigné", "Message d’avertissement",
					JOptionPane.ERROR_MESSAGE);
				}
			if(getForfait().equals("")){
				JOptionPane.showMessageDialog(null, "Champ "+ forfait.getText() +" non renseigné", "Message d’avertissement",
					JOptionPane.ERROR_MESSAGE);
				}
			if(getDplt().equals("")){
				JOptionPane.showMessageDialog(null, "Champ "+ deplacement.getText() +" non renseigné", "Message d’avertissement",
					JOptionPane.ERROR_MESSAGE);
				}
			return false;
		}
	}

}