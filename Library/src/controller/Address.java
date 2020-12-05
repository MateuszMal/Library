package controller;

public class Address {

	private String street;
	private String number;
	private String town;
	
	public Address(String street, String number, String town) {
		super();
		this.street = street;
		this.number = number;
		this.town = town;
	}

	public String getStreet() {
		return street;
	}

	public String getNumber() {
		return number;
	}

	public String getTown() {
		return town;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", number=" + number + ", town=" + town + "]";
	}

	
}
