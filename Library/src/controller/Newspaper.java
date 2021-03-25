package controller;

import java.util.ArrayList;

public class Newspaper extends Book {
	
	private int numberOfPages;
	private ArrayList<String> articlesTitles;

	public Newspaper(String title, Author author, int numberOfPages) {
		super(title, author);
		this.numberOfPages = numberOfPages;
		// TODO Auto-generated constructor stub
	}
	
	public void addArticle(String title) {
		articlesTitles.add(title);
	}

	public ArrayList<String> getArticlesTitles() {
		return articlesTitles;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
}
