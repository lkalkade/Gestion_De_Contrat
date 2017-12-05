package com.app.controller;

import com.app.dao.DAOClient;
import com.app.dao.DAOContrat;
import com.app.dao.JDBC;
import com.app.entity.Client;
import com.app.entity.Contrat;
import com.app.entity.Intervention;
import com.app.view.jdialog.JDialog_Client;
import com.app.listeners.CRUDListner;

public class Controller_Client implements CRUDListner {
	private DAOClient controllerclient;
	private DAOContrat controllercontrat;
	private JDialog_Client clientG;
	private Client client;

	public Controller_Client() {
		clientG = new JDialog_Client();
		clientG.setSize(1050, 509);
		clientG.setTitle("Edit Client");
		clientG.setVisible(true);
		clientG.setRetieveListner(Controller_Client.this);
		
	}
	
private boolean verif = false;

	private void AddClient(Client client) {
		if(clientG.validContrat()==true){
		controllerclient = new DAOClient(JDBC.getConnection());
		controllerclient.create(client);
		searchClient(client.getNum());
		verif = true;
		}
		}
	
	private void AddContrat(Contrat contrat) {
		if(verif==true  && clientG.validContrat()==true){
		controllercontrat = new DAOContrat(JDBC.getConnection());
		controllercontrat.findClient(contrat, client);
		controllercontrat.create(contrat);
		searchContrat(contrat.getId());
		}
	}

	private void searchContrat(int id) {
		// TODO Auto-generated method stub
		controllercontrat = new DAOContrat(JDBC.getConnection());
		controllercontrat.find(id);
		clientG.showOntableSearch(controllercontrat.getTableau());
		System.out.println(controllercontrat.getTableau());
	}

	private void searchClient(int client) {
		controllerclient = new DAOClient(JDBC.getConnection());
		controllerclient.find(client);
		clientG.showOntableSearch(controllerclient.getTableau());
	}

	

	private void removeClient(int client) {
		controllerclient = new DAOClient(JDBC.getConnection());
		controllerclient.remove(client);

	}

	private void modifyClient(int client, String[] tabContenu) {
		controllerclient = new DAOClient(JDBC.getConnection());
		controllerclient.modify(client, tabContenu);
	}

	@Override
	public void SearchPerformed(int client) {
		searchClient(client);
	}

	@Override
	public void addPerformed(Client client) {
		AddClient(client);
	}

	@Override
	public void removePerformed(int stagiaire) {
		removeClient(stagiaire);
	}

	@Override
	public void modifyPerformed(int stagiaire, String[] tabContenu) {
		modifyClient(stagiaire, tabContenu);
	}

	@Override
	public void addPerformed(Contrat contrat) {
		// TODO Auto-generated method stub
		AddContrat(contrat);
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
