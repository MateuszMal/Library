package controller;

import java.util.ArrayList;

public class Tabloid extends Newspaper {
	
	private String advertisement;
	private ArrayList<String> advertisementList;

	public Tabloid(String title, Author author, int numberOfPages) {
		super(title, author, numberOfPages);
		// TODO Auto-generated constructor stub
	}

	public void addAdvertisement(String advertString) {
		advertisementList.add(advertString);
	}

	public String getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(String advertisement) {
		this.advertisement = advertisement;
	}

	public ArrayList<String> getAdvertisementList() {
		return advertisementList;
	}

	public void removeFromList(int n) {
		advertisementList.remove(n);
	}

}
