package models;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class Tree {

	private Node<File> root;

	public void add(String name, ArrayList<File> listElements, HashSet<String> listUniqueExtension) {
		if (root != null) {
			for (Node<File> node : root.getNodeList()) {
				setChild(node, listElements, listUniqueExtension);
			}
		}else {
			root = new Node<File>(new File(name), null);
			setChild(root, listElements, listUniqueExtension);
		}
	}

	private void setChild(Node<File> root, ArrayList<File> listElements, HashSet<String> listUniqueExtension) {
		ArrayList<Node<File>> nodeList = new ArrayList<>();
		if(root.equals(this.root)) {
			for (String child : listUniqueExtension) {
				Node<File> childNode = new Node<File>(new File(child), root);
				setChild(childNode, listElements, listUniqueExtension);
				nodeList.add(childNode);
			}
			root.setNodeList(nodeList);
		}else {
			ArrayList<Node<File>> list = new ArrayList<>();
			for (File element : listElements) {
				if(getFileExtension(element).equals(root.getInfo().getName())) {
					Node<File> node = new Node<File>(element, root);
					list.add(node);
				}
			}
			root.setNodeList(list);
		}
	}

	public Node<File> getRoot() {
		return root;
	}

	private String getFileExtension(File file) {
		String name = file.getName();
		try {
			return name.substring(name.lastIndexOf(".") + 1);
		} catch (Exception e) {
			return "";
		}
	}
}