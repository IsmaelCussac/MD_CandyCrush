package com.view;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

public class Window extends Panel {

	public Window() {

		Frame frame = new Frame("Candy Crush");
		final GamePanel gamePanel = new GamePanel();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});

		frame.add(gamePanel);
		frame.pack();
		frame.setVisible(true);
	}
}
