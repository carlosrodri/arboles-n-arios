package models;

import java.util.ArrayList;

public class Node<T> {
	ArrayList<Node<T>> nodeList;
	Node<T> fatherNode;
	T info;
	
	public Node(T info, Node<T> fatherNode) {
		this.info = info;
		this.fatherNode = fatherNode;
	}
	
	public T getInfo() {
		return info;
	}
	
	public Node<T> getFatherNode(){
		return fatherNode;
	}
}
