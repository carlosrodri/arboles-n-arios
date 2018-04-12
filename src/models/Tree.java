package models;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class Tree {

	private Node<String> root;

	public void add(String name, ArrayList<String> listElements, HashSet<String> listUniqueExtension) {
		if (root != null) {
			for (Node<String> node : root.getNodeList()) {
				setChild(node, listElements, listUniqueExtension);
			}
		}else {
			root = new Node<String>(new File(name).getName(), null);
			setChild(root, listElements, listUniqueExtension);
		}
	}

	private void setChild(Node<String> root, ArrayList<String> listElements, HashSet<String> listUniqueExtension) {
		ArrayList<Node<String>> nodeList = new ArrayList<>();
		if(root.equals(this.root)) {
			for (String child : listUniqueExtension) {
				Node<String> childNode = new Node<String>(child, root);
				setChild(childNode, listElements, listUniqueExtension);
				nodeList.add(childNode);
			}
			root.setNodeList(nodeList);
		}else {
			ArrayList<Node<String>> list = new ArrayList<>();
			for (String element : listElements) {
				if(getFileExtension(new File(element)).equals(root.getInfo())) {
					Node<String> node = new Node<String>(element, root);
					list.add(node);
				}
			}
			root.setNodeList(list);
		}
	}

	public Node<String> getRoot() {
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