package controller;

public final class LibraryHolder {
	
	/**
	 * Klasa Singleton - przechowuje LibraryManager jako uniwersalny obiekt dla 
	 * wszystkich instancji, ktore go wykorzystuja.
	 */
	private LibraryManager libManager;
	
	private final static LibraryHolder INSTANCE = new LibraryHolder();
	
	private LibraryHolder() {};
	
	public static LibraryHolder getInstance() {
		return INSTANCE;
	}
	
	public void setLibManager(LibraryManager libManager) {
		this.libManager = libManager;
	}
	
	public LibraryManager getLIbManager() {
		return libManager;
	}
}
