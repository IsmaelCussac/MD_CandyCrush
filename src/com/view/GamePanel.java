package com.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Field;

import com.controller.GridManager;
import com.model.Constants;

public class GamePanel extends Panel implements MouseListener,
		MouseMotionListener, Runnable {

	private GridManager gridManager;

	public GamePanel() {
		gridManager = GridManager.getInstance();

		while (gridManager.fill());

		while (gridManager.removeAlignments()) {
			gridManager.fill();
		}

		addMouseListener(this);
		addMouseMotionListener(this);
		new Thread(this).start();
	}

	Color colors[] = { Color.WHITE, Color.RED, Color.GREEN, Color.BLUE,
			Color.GRAY, Color.PINK, Color.CYAN };

	int selectedX = -1, selectedY = -1;
	int swappedX = -1, swappedY = -1;

	// image pour le rendu hors écran
	Image buffer;

	public Dimension getPreferredSize() {
		return new Dimension(32 * Constants.xMax + 1 + 100, 32 * Constants.yMax + 1);
	}

	public void paint(Graphics g2) {
		if (buffer == null)
			buffer = createImage(800, 600);
		Graphics2D g = (Graphics2D) buffer.getGraphics();

		// fond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		// afficher la grille vide
		g.setColor(Color.BLACK);
		for (int i = 0; i <= Constants.xMax; i++) {
			g.drawLine(32 * i, 0, 32 * i, Constants.yMax * 32 + 1);
		}
		for (int i = 0; i <= Constants.yMax; i++) {
			g.drawLine(0, 32 * i, Constants.xMax * 32 + 1, 32 * i);
		}
		// afficher la première case sélectionnée
		if (selectedX != -1 && selectedY != -1) {
			g.setColor(Color.ORANGE);
			g.fillRect(selectedX * 32 + 1, selectedY * 32 + 1, 31, 31);
		}

		// afficher la deuxième case sélectionnée
		if (swappedX != -1 && swappedY != -1) {
			g.setColor(Color.YELLOW);
			g.fillRect(swappedX * 32 + 1, swappedY * 32 + 1, 31, 31);
		}

		// afficher le contenu de la grille
		for (int i = 0; i < Constants.xMax; i++) {
			for (int j = 0; j < Constants.yMax; j++) {
				try {
					Field field = Class.forName("java.awt.Color").getField(
							gridManager.getGridModel().getCandy(i, j)
									.getColor().toString());
					g.setColor((Color) field.get(null));
				} catch (Exception e) {
				}
				g.fillOval(32 * i + 3, 32 * j + 3, 27, 27);
			}
		}
		
		g.drawString("Score: " + gridManager.getScore(), 280, 200);

		// copier l'image à l'écran
		g2.drawImage(buffer, 0, 0, null);
	}

	// gestion des événements souris
	public void mousePressed(MouseEvent e) {
		// on appuie sur le bouton de la souris : récupérer les coordonnées de
		// la première case
		selectedX = e.getX() / 32;
		selectedY = e.getY() / 32;

		// affiche la couleur du pion cliqué
		// if (selectedX != -1 && selectedY != -1) {
		// swappedX = e.getX() / 32;
		// swappedY = e.getY() / 32;
		// System.out.println(gridManager.getGridModel().getCandy(swappedX,
		// swappedY).getColor());
		// }
		repaint();
	}

	public void mouseMoved(MouseEvent e) {
		// on bouge la souris : récupérer les coordonnées de la deuxième case
		if (selectedX != -1 && selectedY != -1) {
			swappedX = e.getX() / 32;
			swappedY = e.getY() / 32;
			// si l'échange n'est pas valide, on cache la deuxième case
			if (!gridManager.isValidSwap(selectedX, selectedY, swappedX,
					swappedY)) {
				swappedX = swappedY = -1;
			}
		}
		repaint();
	}

	public void mouseReleased(MouseEvent e) {
		// lorsque l'on relâche la souris il faut faire l'échange et cacher les
		// cases
		if (selectedX != -1 && selectedY != -1 && swappedX != -1
				&& swappedY != -1) {
			gridManager.swap(selectedX, selectedY, swappedX, swappedY);
		}
		selectedX = selectedY = swappedX = swappedY = -1;
		repaint();
	}

	// non implémentés
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		while (true) {
			// un pas de simulation toutes les 100ms
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
			}

			// s'il n'y a pas de case vide, chercher des alignements
			if (!gridManager.fill()) {
				gridManager.removeAlignments();
			}

			// redessiner
			repaint();
		}
	}
}
