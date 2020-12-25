package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	
	public ArrayList<String> readlines(File f) {

		ArrayList<String> stringList = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				stringList.add(line);
				System.out.println(line);
			}
			br.close();
			fr.close();
		} 
		
		catch (IOException io) {
			System.out.println(io.getMessage());
		}

		catch (Exception se) {
			System.err.println(se.getMessage());
		}
		return stringList;
	}
	
	public String readWithBuffer(File f, int charBuffer) {
		char buff[] = new char[charBuffer];
		
		try {
			FileReader stream = new FileReader(f);
			stream.read(buff, 0, charBuffer);
		}
		
		catch (FileNotFoundException io) {
			System.out.println(io.getMessage());
		}
		
		catch (IOException io) {
			System.out.println(io.getMessage());
		}
		
		String readingText = new String(buff);
		System.out.println("Odczyta³em: " + readingText);
		return readingText;
	}
}
