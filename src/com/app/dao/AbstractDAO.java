package com.app.dao;

import java.sql.Connection;

import com.app.entity.Client;
import com.app.entity.Contrat;

public abstract class AbstractDAO<T> {
	protected Connection connection = null;

	public AbstractDAO(Connection connection) {
		this.connection = connection;
	}

	public abstract void create(T obj);

	public abstract void find(int searchIntred);


	public abstract void remove(int stagiaire);

	public abstract void modify(int stagiaire, String[] tabContenu);

	public void create(Client client, Contrat contrat) {
		// TODO Auto-generated method stub
		
	}

}
