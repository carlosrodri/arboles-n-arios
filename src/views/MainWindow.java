package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import controllers.Actions;
import controllers.Controller;
import models.Node;
import models.Tree;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private Menu_Button menuBar;
	private JTree jtree;

	public MainWindow(Controller controller) {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		menuBar = new Menu_Button();
		setJMenuBar(menuBar.createMenuBar("Select", "Select", controller, Actions.SELECT.toString()));
		
		jtree = new JTree();
		add(jtree, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void setDatas(Tree tree) {
		DefaultMutableTreeNode father = new DefaultMutableTreeNode(tree.getRoot().getInfo());
		for (Node<String> node : tree.getRoot().getNodeList()) {
			DefaultMutableTreeNode song = new DefaultMutableTreeNode(node.getInfo());
			father.add(song);
		}
		DefaultTreeModel model = new DefaultTreeModel(father);
		jtree.setModel(model);
		revalidate();
	}
}
