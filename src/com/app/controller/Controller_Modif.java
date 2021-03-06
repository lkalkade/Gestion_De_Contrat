package com.app.controller;

import com.app.dao.DAOContrat;
import com.app.dao.JDBC;
import com.app.entity.Client;
import com.app.entity.Contrat;
import com.app.entity.Intervention;
import com.app.view.jdialog.JDialog_Modif;
import com.app.listeners.CRUDListner;

public class Controller_Modif implements CRUDListner {
	private DAOContrat controllercontrat;
	private JDialog_Modif modifG;
	public Controller_Modif() {
		modifG = new JDialog_Modif();
		modifG.setSize(900, 509);
		modifG.setTitle("Modifier");
		modifG.setVisible(true);
		modifG.setRetieveListner(Controller_Modif.this);

	}

	private void AddContrat(Contrat contrat) {
		controllercontrat = new DAOContrat(JDBC.getConnection());
		controllercontrat.create(contrat);
		searchContrat(contrat.getId());
	}

	private void searchContrat(int contrat) {
		controllercontrat = new DAOContrat(JDBC.getConnection());
		controllercontrat.find(contrat);
		modifG.showOntableSearch(controllercontrat.getTableau());
	}

		


	private void removeContrat(int contrat) {
		controllercontrat = new DAOContrat(JDBC.getConnection());
		controllercontrat.remove(contrat);

	}

	private void modifyContrat(int contrat, String[] tabContenu) {
		controllercontrat = new DAOContrat(JDBC.getConnection());
		controllercontrat.modify(contrat, tabContenu);
	}

	@Override
	public void SearchPerformed(int contrat) {
		searchContrat(contrat);
	}

	@Override
	public void addPerformed(Contrat contrat) {
		AddContrat(contrat);
	}

	@Override
	public void removePerformed(int stagiaire) {
		removeContrat(stagiaire);
	}

	@Override
	public void modifyPerformed(int stagiaire, String[] tabContenu) {
		modifyContrat(stagiaire, tabContenu);
	}

	@Override
	public void addPerformed(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPerformed(Intervention intervention) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyPerformed(int numc, String total, String restant, String report, String statut) {
		// TODO Auto-generated method stub
		
	}

}
