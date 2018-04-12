package models;

import java.io.File;
import java.util.ArrayList;

public class Dao {
	private File file;
	ArrayList<String> elements;
	
	public Dao() {
		elements = new ArrayList<>();
	}
	
	public File[] getElements(String path){
		File[] list = null;
		file = new File(path);
		if(file.exists()) {
			list = file.listFiles();
		}
		return list;
	}
	
	public ArrayList<String> getElementsByType(File[] list){
		
		for (int i = 0; i < list.length; i++) {
			if(list[i].isDirectory()) {
				getElementsByType(getElements(list[i].getPath()));
			}else {
				elements.add(list[i].getName());
			}
		}
		return elements;
	}
}
