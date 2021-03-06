package models;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

public class Dao {
	private File file;
	ArrayList<File> elements;
	HashSet<String> uniqueExtension;
	
	public Dao() {
		elements = new ArrayList<>();
		uniqueExtension = new HashSet<>();
	}
	
	public File[] getElements(String path){
		File[] list = null;
		file = new File(path);
		if(file.exists()) {
			list = file.listFiles();
		}
		return list;
	}
	
	public ArrayList<File> getElementsByType(File[] list){
		for (int i = 0; i < list.length; i++) {
			if(list[i].isDirectory()) {
				getElementsByType(getElements(list[i].getPath()));
			}else {
				elements.add(list[i]);
			}
		}
		return elements;
	}
	
	public HashSet<String> getUniqueExtension(){
		for (File string : elements) {
			uniqueExtension.add(getFileExtension(string));
		}
		return uniqueExtension;
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