package controller;

public final class LibraryHolder {
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
