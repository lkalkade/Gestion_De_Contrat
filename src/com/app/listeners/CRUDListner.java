package com.app.listeners;

import com.app.entity.Client;
import com.app.entity.Contrat;
import com.app.entity.Intervention;

public interface CRUDListner {

	public void SearchPerformed(int contrat);

	public void addPerformed(Contrat contrat);

	public void modifyPerformed(int contrat, String[] tabContenu);

	public void removePerformed(int contrat);

	public void addPerformed(Client client);

	void addPerformed(Intervention intervention);

	public void modifyPerformed(int numc, String total, String restant, String report, String statut);

}
