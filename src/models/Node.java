package models;

import java.util.ArrayList;

public class Node<T> {
	private ArrayList<Node<T>> nodeList;
	private Node<T> fatherNode;
	private T info;
	
	public Node(T info, Node<T> fatherNode) {
		this.info = info;
		this.fatherNode = fatherNode;
	}
	
	public T getInfo() {
		return info;
	}
	
	public ArrayList<Node<T>> getNodeList() {
		return nodeList;
	}
	
	public void setNodeList(ArrayList<Node<T>> nodeList) {
		this.nodeList = nodeList;
	}

	public Node<T> getFatherNode(){
		return fatherNode;
	}
}