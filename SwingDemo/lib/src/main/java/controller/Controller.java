package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import model.*;


import gui.MainFrame;
import gui.MainPanel;

public class Controller {

	private MainFrame mainFrame;
	private MainPanel mainPanel;

	public Controller() {
		var props = Profile.getProperties("db");

		var db = Database.getInstance();

		try {
			db.connect(props);
		} catch (SQLException e) {
			System.out.println("Cannot connect to the Database");
		}

		UserDao userDao = new UserDaoImpl();

		mainPanel = new MainPanel();
		mainPanel.setFormListener((username, password) -> {
			userDao.save(new User(username,password));
		});

		mainFrame = new MainFrame();

		mainFrame.setContentPane(mainPanel);
		mainFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				try {
					db.close();
				} catch (SQLException e) {
					System.out.println("Cannot close Database Connection");
				}
			}
		});
	}

}
