package database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	public void overWriteFile(File f, String tekstDoZapisania) {

		try {
			FileWriter fw = new FileWriter(f);
			fw.write(tekstDoZapisania);
			fw.close();
		}

		catch (IOException io) {
			System.out.println(io.getMessage());
		}

		catch (Exception se) {
			System.err.println(se.getMessage());
		}
	}
	
	public void appendToFile(File f, String tekstDoZpisania) {
		
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(tekstDoZpisania);
			fw.write("\n");
			fw.close();
		}
		
		catch (IOException io) {
			System.out.println(io.getMessage());
		}

		catch (Exception se) {
			System.err.println(se.getMessage());
		}
	}
}
