package views;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import controllers.Controller;

public class FileChooser extends JDialog{

	private static final long serialVersionUID = 1L;
	public JFileChooser jFileChooser;

	public FileChooser(Controller controller){
		setSize(800,400);
		setLocationRelativeTo(null);
		setModal(true);
//		FileNameExtensionFilter filterX = new FileNameExtensionFilter(".xml", "xml");
//		FileNameExtensionFilter filterJ = new FileNameExtensionFilter(".jsn", "jsn");
//		FileNameExtensionFilter filterB = new FileNameExtensionFilter(".bin", "bin");
//		FileNameExtensionFilter filterT = new FileNameExtensionFilter(".txt", "txt");
		jFileChooser = new JFileChooser();
//		jFileChooser.setFileFilter(filterX);
//		jFileChooser.setFileFilter(filterJ);
//		jFileChooser.setFileFilter(filterB);
//		jFileChooser.setFileFilter(filterT);
	}

	public String getPathFile() throws Exception{
		int selection = jFileChooser.showOpenDialog(this);
		if(selection == JFileChooser.APPROVE_OPTION){
			return jFileChooser.getSelectedFile().getPath();
		}else
			throw new Exception("Cancelo La Seleccion");		
	}
	
	public String showSaveFile() throws Exception{
		int selection = jFileChooser.showSaveDialog(this);
		if(selection == JFileChooser.APPROVE_OPTION){
			return jFileChooser.getSelectedFile().getPath();
		}else
			throw new Exception("No se ha seleccionado ningun archivo");
	}
}