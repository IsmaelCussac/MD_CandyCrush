package com.view;

public class Application {

	private Window window;
	private static Application instance;

	public Application() {
		window = new Window();
		// window.setVisible(true);
	}

	public static void main(String[] args) {
		Application.setInstance(new Application());
	}

	public static Application getInstance() {
		return instance;
	}

	public static void setInstance(Application app) {
		instance = app;
	}
}
