package userInterface;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Assistant;
import model.AssistantRepetidoException;
import model.WorldCup;

public class Controller {
	private final static String FILE_PATH="data"+File.separator+"totalInfo.csv";
	private final static String FILE_PATH2="data"+File.separator+"totalInfo.csv";
	private WorldCup sub21;
	
	public Controller() {
		sub21 = new WorldCup();
	}
	
	public String loadCVS() {
		String msg ="";
		try {
			File d = new File("data");
			if(!d.exists())
				d.mkdir();
			
			File f = new File(FILE_PATH2);
			sub21.chargeData(f);
			msg="los archivos se han cargado con exito";
			}catch(AssistantRepetidoException | NumberFormatException | IOException e) {
				msg=e.getLocalizedMessage();
			}
		return msg;
	}
	public String buscarAssistant(int id) throws NullPointerException{
		String toReturn="";
		try {
			toReturn=sub21.searchAssistant(id).toString();
		}catch( Exception e) {
			toReturn= "fatal: el ID ingresado no se encuentra en la base de datos";
		}
		return toReturn;
	}
	public String buscarParticipant(int id) throws NullPointerException{

		String toReturn="";
		try {
			toReturn=sub21.searchParticipant(id).toString();
		}catch( Exception e) {
			toReturn="fatal: el ID ingresado no se encuentra en la base de datos";
		}
		return toReturn;
	}

	public WorldCup getSub21() {
		return sub21;
	}

	public void setSub21(WorldCup sub21) {
		this.sub21 = sub21;
	}
	
}
