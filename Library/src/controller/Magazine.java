package controller;

public class Magazine extends Book{
	
	private int issuingPeriod;

	public Magazine(String title, Author author, int issuingPeriod) {
		super(title, author);
		this.issuingPeriod = issuingPeriod;
		// TODO Auto-generated constructor stub
	}

	public int getIssuingPeriod() {
		return issuingPeriod;
	}

	public void setIssuingPeriod(int issuingPeriod) {
		this.issuingPeriod = issuingPeriod;
	}

	
}
