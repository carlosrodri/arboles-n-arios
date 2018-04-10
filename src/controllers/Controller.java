package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.FileChooser;
import views.MainWindow;

public class Controller implements ActionListener{
	private FileChooser fileChooser;
	private MainWindow mainWindow;

	public Controller() {
		mainWindow = new MainWindow(this);
		fileChooser = new FileChooser(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand())) {
		case SELECT:
			try {
				fileChooser.getPathFile();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		}
		
	}

}
