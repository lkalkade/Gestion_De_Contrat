package com.app.entity;

import java.util.ArrayList;

//import java.util.ArrayList;


/*OK*/

public class Client {

	private String nom;
	private int nclient;
	private Client client;
	private ArrayList<Client> listeclient = new ArrayList<Client>();
	private int index;
	
	
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getNum() {
		return nclient;
	}
	
	public void setNum(int num) {
		this.nclient = num;
	}
	
	public ArrayList<Client> getListeclient() {
		return listeclient;
	}

	public void setListeclient(ArrayList<Client> listeclient) {
		this.listeclient = listeclient;
	}
	
	public boolean searchClient(String[] searchIntred) {
		for (String obj : searchIntred) {
			if (!listeclient.contains(obj)) {
				return false;
			} else {
				index = listeclient.indexOf(obj);
				setClient(listeclient.get(index));
				break;
			}
		}
		return true;

	}

	public void AddClient(Client client) {
		listeclient.add(client);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	public Client( int nclient, String nom){
		this.nclient = nclient; 
		this.nom = nom;
	}
	
	
	public Client(String nom) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
	}

}
