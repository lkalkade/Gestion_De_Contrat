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
	private JTextArea éditeur = new JTextArea(feuille);
   private JToolBar barre = new JToolBar();  
   

   public Imprimante() {
      barre.add(new AbstractAction("Imprimer") {
         /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e) {
            try {
               éditeur.print();
            } 
            catch (PrinterException ex) {
               setTitle("Problème d'impression");
            }
         }
      });
      add(barre, BorderLayout.NORTH);
      éditeur.setEditable(false);
      add(new JScrollPane(éditeur));
      setSize(900, 550);
      setVisible(true);
   }   
   
}