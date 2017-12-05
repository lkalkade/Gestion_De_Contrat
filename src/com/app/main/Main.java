package com.app.main;

import javax.swing.SwingUtilities;

import com.app.view.chargement;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			private chargement charge;

			@Override
			public void run() {
				charge = new chargement();
				charge.setVisible(true);
				//new Controller();
			}
		});
	}
}
