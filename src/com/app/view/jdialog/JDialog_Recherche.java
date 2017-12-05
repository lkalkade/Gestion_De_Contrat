package com.app.view.jdialog;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXSearchField;
import org.jdesktop.swingx.JXSearchField.LayoutStyle;

import com.app.entity.Contrat;
import com.app.listeners.CRUDListner;

public class JDialog_Recherche extends JDialog {

	private static final long serialVersionUID = 1L;


	private JXSearchField searchField;
	private JScrollPane scrollPane;
	private JTable table;

	private CRUDListner controller;

	private static int ncontrat = 0;
	

	private DefaultTableModel dt;

	
	public String getSearchField() {
		return searchField.getText();
	}
	
	public JDialog_Recherche() {
		
		
	
		
		// set the position of the window
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLocationRelativeTo(null);
		setResizable(true);
		Point p = new Point(200, 200);
		setLocation(p.x, p.y);
		
			

		searchField = new JXSearchField("N°Contrat");
		searchField.setBounds(300, 11, 248, 30);
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
		scrollPane.setBounds(80, 90, 739, 300);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setRowHeight(34);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setForeground(Color.BLACK);
		dt = new DefaultTableModel(new Object[][] {},
				new String[] { "N° Contrat","Client","Contrat Etabli","Type Contrat","Forfait","Deplacement" });
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
	
}