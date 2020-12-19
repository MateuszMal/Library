package model;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Xml {
	

	private ArrayList<String> xmlString = new ArrayList<String>();
	private WriteFile wf = new WriteFile();
	XStream xstream = new XStream(new DomDriver());


	public void toXstream(ArrayList object, File f) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			xstream.toXML(object, fw);
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
		public static ArrayList fromXmltoList(File f) {
			XStream xstream = new XStream(new DomDriver());
			XStream.setupDefaultSecurity(xstream);
			xstream.addPermission(AnyTypePermission.ANY);
			return (ArrayList) xstream.fromXML(f);
		}
}

