package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controllers.Actions;
import controllers.Controller;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private Menu_Button menuBar;

	public MainWindow(Controller controller) {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		menuBar = new Menu_Button();
		setJMenuBar(menuBar.createMenuBar("Select", "Select", controller, Actions.SELECT.toString()));
		
		setVisible(true);
	}
}
