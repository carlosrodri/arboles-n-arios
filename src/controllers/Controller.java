package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Dao;
import views.FileChooser;
import views.MainWindow;

public class Controller implements ActionListener{
	private FileChooser fileChooser;
	private MainWindow mainWindow;
	private Dao dao;

	public Controller() {
		mainWindow = new MainWindow(this);
		fileChooser = new FileChooser(this);
		dao = new Dao();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand())) {
		case SELECT:
			try {
				for (String list : dao.getElementsByType(dao.getElements(fileChooser.getPathFile()))) {
					System.out.println(list);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		}

	}

}
