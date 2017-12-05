package com.app.controller;

import com.app.dao.DAOContrat;
import com.app.dao.DAOIntervention;
import com.app.dao.JDBC;
import com.app.entity.Client;
import com.app.entity.Contrat;
import com.app.entity.Intervention;
import com.app.view.jdialog.JDialog_Intervention;
import com.app.listeners.CRUDListner;

public class Controller_Intervention implements CRUDListner {
	private DAOIntervention controllerfacture;
	private DAOContrat controllercontrat;
	private JDialog_Intervention factureG;
	public Controller_Intervention() {
		factureG = new JDialog_Intervention();
		factureG.setSize(900, 509);
		factureG.setTitle("Edit Intervention");
		factureG.setVisible(true);
		factureG.setRetieveListner(Controller_Intervention.this);
	}

	private void AddFacture(Intervention facture) {
		controllerfacture = new DAOIntervention(JDBC.getConnection());
		controllerfacture.create(facture);
		searchFacture(facture.getIdintervention());
	}

	private void searchFacture(int facture) {
		controllerfacture = new DAOIntervention(JDBC.getConnection());
		controllerfacture.find(facture);
		factureG.showOntableSearch(controllerfacture.getTableau());
	}
	

	private void removeFacture(int contrat) {
		controllerfacture = new DAOIntervention(JDBC.getConnection());
		controllerfacture.remove(contrat);

	}

	private void modifyFacture(int facture, String[] tabContenu) {
		controllerfacture = new DAOIntervention(JDBC.getConnection());
		controllerfacture.modify(facture, tabContenu);
	}

	private void modifyTemps(int contrat,String total, String restant, String report, String statut ) {
		controllercontrat = new DAOContrat(JDBC.getConnection());
		controllercontrat.modifytemps(contrat, total, restant, report, statut);
	}
	
	@Override
	public void SearchPerformed(int facture) {
		searchFacture(facture);
	}


	public void addPerformed(Intervention facture) {
		AddFacture(facture);
	}

	@Override
	public void removePerformed(int stagiaire) {
		removeFacture(stagiaire);
	}

	@Override
	public void modifyPerformed(int stagiaire, String[] tabContenu) {
		modifyFacture(stagiaire, tabContenu);
	}

	@Override
	public void addPerformed(Contrat contrat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPerformed(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyPerformed(int numc, String total, String restant, String report, String statut) {
		// TODO Auto-generated method stub
		modifyTemps(numc, total, restant, report, statut);
	}

}
