package com.app.impression;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterException;
import javax.swing.*;

import com.app.dao.DAOImpression;
import com.app.dao.DAOSearch;
import com.app.dao.JDBC;
import com.app.entity.Client;

public class Imprimante extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom="A2L COPY";
	DAOImpression imprime=new DAOImpression(JDBC.getConnection());
	String feuille = imprime.Impression(nom);
	private JTextArea �diteur = new JTextArea(feuille);
   private JToolBar barre = new JToolBar();  
   

   public Imprimante() {
      barre.add(new AbstractAction("Imprimer") {
         /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
            try {
               �diteur.print();
            } 
            catch (PrinterException ex) {
               setTitle("Probl�me d'impression");
            }
         }
      });
      add(barre, BorderLayout.NORTH);
      �diteur.setEditable(false);
      add(new JScrollPane(�diteur));
      setSize(900, 550);
      setVisible(true);
   }   
   
}