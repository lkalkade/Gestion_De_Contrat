package com.app.entity;

import java.util.ArrayList;

/*ok*/

public class Contrat {

	private String typecontrat, forfaits, deplacement;
	private String datecontrat;
	private String nomclient;
	private int id;
	private ArrayList<Contrat> listecontrat = new ArrayList<Contrat>();
	private int index;
	private Contrat contrat;
	 
	public Contrat(int id, String nomclient, String datecontrat, String typecontrat, String forfaits,
			String deplacement){
		this.id=id;
		this.nomclient=nomclient;
		this.datecontrat = datecontrat;
		this.typecontrat = typecontrat;
		this.forfaits = forfaits;
		this.deplacement = deplacement;
		}
	
	public Contrat(int id, String forfaits) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.forfaits = forfaits;
	}

	public String getTypeContrat() {
		return typecontrat;
	}
	public void setTypeContrat(String typecontrat) {
		this.typecontrat = typecontrat;
	}
	
	public String getForfaits() {
		return forfaits;
	}
	public void setForfaits(String forfaits) {
		this.forfaits = forfaits;
	}
	
	public String getDateContrat() {
		return datecontrat;
	}
	public void setDateContrat(String datecontrat) {
		this.datecontrat = datecontrat;
	}
	
	public String getDeplacement() {
		return deplacement;
	}
	public void setDeplacement(String deplacement) {
		this.deplacement = deplacement;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList<Contrat> getListecontrat() {
		return listecontrat;
	}

	public void setListecontrat(ArrayList<Contrat> listecontrat) {
		this.listecontrat = listecontrat;
	}
	
	public boolean searchContrat(String[] searchIntred) {
		for (String obj : searchIntred) {
			if (!listecontrat.contains(obj)) {
				return false;
			} else {
				index = listecontrat.indexOf(obj);
				setContrat(listecontrat.get(index));
				break;
			}
		}
		return true;

	}

	public void AddContrat(Contrat contrat) {
		listecontrat.add(contrat);
	}

	public  Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}


	public String getNomclient() {
		return nomclient;
	}


	public void setNomclient(String nomclient) {
		this.nomclient = nomclient;
	}


	public String getStatut() {
		// TODO Auto-generated method stub
		return "Actif";
	}

	
	
}
