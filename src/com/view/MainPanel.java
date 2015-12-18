package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	
	public MainPanel() {
		
		JPanel panel = new JPanel();
		
		
		JButton btnJouer = new JButton("Jouer"); 
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GamePanel();
			}

		});
	}
}
