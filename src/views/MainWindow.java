package views;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.util.ArrayList;

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
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(jtree);
		
		add(scrollPane, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void setDatas(Tree tree) {
		DefaultMutableTreeNode father = new DefaultMutableTreeNode(tree.getRoot().getInfo());
		DefaultTreeModel model = new DefaultTreeModel(father);
		jtree.setModel(model);
		int i = 0;
		for (Node<String> node : tree.getRoot().getNodeList()) {
			DefaultMutableTreeNode son = new DefaultMutableTreeNode(node.getInfo());
			model.insertNodeInto(son, father, i);
			setFiles(model, son, node.getNodeList());
			i++;
		}
		revalidate();
	}
	
	private void setFiles(DefaultTreeModel model, DefaultMutableTreeNode son, ArrayList<Node<String>> list) {
		int i = 0;
		for (Node<String> node : list) {
			model.insertNodeInto(new DefaultMutableTreeNode(node.getInfo()), son, i);
			i++;
		}
	}
}