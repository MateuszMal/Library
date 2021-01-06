package database;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import database.WriteFile;

public class Serialization {

	private ArrayList<String> csvStringList = new ArrayList<String>();
	private ArrayList<String> xmlString = new ArrayList<String>();
	private WriteFile wf = new WriteFile();
	XStream xstream = new XStream(new DomDriver());

	public void changeToCsv(ArrayList<String> object, File f) {
		// Pobiera ArrayList, przygotowywuje je do zapisu jako csv
		for(String o : object) {
			String s = stringPrepare(o);
			this.csvStringList.add(s);
		}
		for(String s : csvStringList) {
			wf.appendToFile(f, s);
		}
	}
	
	public String stringPrepare(String s) {
		//Usuwa zbedne znaki z Stringa i dodaje ':' po kazdym slowie
		s = s.replace(",", "");
		s = s.replace("[", "");
		s = s.replace("]", "");
		s = s.replace(" " , "; ");

		return s;
	}
	
	public boolean toXstream(ArrayList object, File f) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			xstream.toXML(object, fw);
			return true;
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ArrayList<String> getXmlString() {
		return xmlString;
	}
	
	public ArrayList<String> getCsvStringList() {
		return csvStringList;
	}

}