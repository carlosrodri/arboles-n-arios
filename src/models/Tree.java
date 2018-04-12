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
				nodeList.add(new Node<String>(child, root));
			}
			root.setNodeList(nodeList);
		}else {
			ArrayList<Node<String>> list = new ArrayList<>();
			for (String element : listElements) {
				if(element.substring(element.length()-3, element.length()).equals(root.getInfo())) {
					list.add(new Node<String>(element, root));
				}
			}
			root.setNodeList(list);
		}
	}
	
	public void print(Node<String> root) {
		if(root != null) {
			System.out.println(root.getInfo() + "-----father node");
			System.out.println(root.getNodeList() + "list");
			if(root.getNodeList() != null) {
				for (Node<String> node : root.getNodeList()) {
					System.out.println(node.getInfo() + "---------- song node");
				}
			}
		}else {

		}
	}

	public Node<String> getRoot() {
		return root;
	}
}