package views;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(400, 600);
		setTitle("Files Tree V 1.0");

		menuBar = new Menu_Button();
		setJMenuBar(menuBar.createMenuBar("Select", "Select", controller, Actions.SELECT.toString()));

		jtree = new JTree();
		jtree.setModel(null);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(jtree);

		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	public void setDatas(Tree tree, int size) {
		DefaultMutableTreeNode father = new DefaultMutableTreeNode(tree.getRoot().getInfo().getName());
		DefaultTreeModel model = new DefaultTreeModel(father);
		//		model.setAsksAllowsChildren(true);
		jtree.setModel(model);
		int i = 0;
		for (Node<File> node : tree.getRoot().getNodeList()) {
			DefaultMutableTreeNode son = new DefaultMutableTreeNode(node.getInfo().getName());
			DefaultMutableTreeNode max = new DefaultMutableTreeNode("Max");
			DefaultMutableTreeNode min = new DefaultMutableTreeNode("Min");
			model.insertNodeInto(son, father, i);
			model.insertNodeInto(max, son, 0);
			model.insertNodeInto(min, son, 1);
			setFiles(model, max, min, node.getNodeList(), size);
			i++;
		}
		revalidate();
	}

	private void setFiles(DefaultTreeModel model, DefaultMutableTreeNode max, DefaultMutableTreeNode min, ArrayList<Node<File>> list, int size) {
		for (Node<File> node : list) {
			if(node.getInfo().length() > size*1000) {
				max.add(new DefaultMutableTreeNode(node.getInfo().getName()));
			}else {
				min.add(new DefaultMutableTreeNode(node.getInfo().getName()));
			}
		}
	}

	public int getSizeOfFile() {
		return Integer.parseInt(JOptionPane.showInputDialog("Input the size in KB for sort"));
	}
}