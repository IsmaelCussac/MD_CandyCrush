package com.view;

public class Application {

	private static Application instance;

	public Application() {
		new Window();
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
