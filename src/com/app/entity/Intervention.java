package com.app.entity;

import java.util.ArrayList;

/*OK*/

public class Intervention {
	

	private String technicien, duree, dateintervention, hdebut, hfin;
	private String forfait,nomclient;
	private int idintervention;
	private int numcontrat;
	private ArrayList<Intervention> listeintervention = new ArrayList<Intervention>();
	private int index;
	private Intervention intervention;
	

	public Intervention(int idintervention, String technicien,
			String dateintervention, String hdebut, String hfin, String duree,
			int numcontrat)
	{
		this.idintervention=idintervention;
		this.technicien = technicien;
		this.dateintervention = dateintervention;
		this.hdebut = hdebut;
		this.hfin = hfin;
		this.duree = duree;
		this.numcontrat=numcontrat;
		
	}


	public String getTechnicien() {
		return technicien;
	}

	public void setTechnicien(String technicien) {
		this.technicien = technicien;
	}
	
	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}
	
	public String getDateintervention() {
		return dateintervention;
	}

	public void setDateintervention(String dateintervention) {
		this.dateintervention = dateintervention;
	}
	
	
	public int getIdintervention() {
		return idintervention;
	}

	public void setIdintervention(int idintervention) {
		this.idintervention = idintervention;
	}
	
	public ArrayList<Intervention> getListeintervention() {
		return listeintervention;
	}

	public void setListeintervention(ArrayList<Intervention> listeintervention) {
		this.listeintervention = listeintervention;
	}
	
	public boolean searchFacture(String[] searchIntred) {
		for (String obj : searchIntred) {
			if (!listeintervention.contains(obj)) {
				return false;
			} else {
				index = listeintervention.indexOf(obj);
				setIntervention(listeintervention.get(index));
				break;
			}
		}
		return true;

	}

	public void AddFacture(Intervention intervention) {
		listeintervention.add(intervention);
	}

	public  Intervention getIntervention() {
		return intervention;
	}

	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}

	public String getHdebut() {
		return hdebut;
	}

	public void setHdebut(String hdebut) {
		this.hdebut = hdebut;
	}

	public String getHfin() {
		return hfin;
	}

	public void setHfin(String hfin) {
		this.hfin = hfin;
	}


	public int getNumcontrat() {
		return numcontrat;
	}


	public void setNumcontrat(int numcontrat) {
		this.numcontrat = numcontrat;
	}


	public String getForfait() {
		return forfait;
	}


	public void setForfait(String forfait) {
		this.forfait = forfait;
	}


	public String getNomclient() {
		return nomclient;
	}


	public void setNomclient(String nomclient) {
		this.nomclient = nomclient;
	}

}
