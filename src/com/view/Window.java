package com.view;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

public class Window extends Panel {

	//private JPanel contentPanel;

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

		// try {
		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		// } catch (Exception e1) {
		// e1.printStackTrace();
		// }

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100, 500, 500);
		//
		// JMenuBar menuBar = new JMenuBar();
		// setJMenuBar(menuBar);
		//
		// JMenu menuOption = new JMenu("Option");
		// menuBar.add(menuOption);
		//
		// contentPanel = new JPanel();
		// contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPanel.setLayout(new BorderLayout(0, 0));
		// setContentPane(contentPanel);
		//
		// MainPanel mainPanel = new MainPanel();
		// contentPanel.add(mainPanel, BorderLayout.CENTER);
		//
		// contentPanel.setVisible(true);
	}

	// public void revalidate() {
	// super.revalidate();
	// }
}
