package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Dao;
import models.Tree;
import views.FileChooser;
import views.MainWindow;

public class Controller implements ActionListener{
	private FileChooser fileChooser;
	private MainWindow mainWindow;
	private Dao dao;
	private Tree tree;

	public Controller() {
		dao = new Dao();
		tree = new Tree();
		mainWindow = new MainWindow(this);
		fileChooser = new FileChooser(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand())) {
		case SELECT:
			String path = null;
			try {
				path = fileChooser.getPathFile();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				dao.getElementsByType(dao.getElements(path));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			tree.add(path, dao.getElementsByType(dao.getElements(path)), dao.getUniqueExtension());
			break;
		}
		mainWindow.setDatas(tree);
	}

}
