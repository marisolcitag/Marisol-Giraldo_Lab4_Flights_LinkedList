package model;

public enum Destinations {
	
	//ATTRIBUTES
	BOGOTA("Bogota"),
	MEDELLIN("Medellin"),
	CALI("Cali"),
	MIAMI("Miami"),
	LASVEGAS("Las Vegas"),
	SANFRANCISCO("San Francisco"), 
	CIUDADDEMEXICO("Ciudad de Mexico"),
	PANAMA("Panama"),	
	PARIS("Paris");
	
	private String name;
	
	//CONSTRUCTOR
	private Destinations(String n) {
		this.name = n;
	}
	
	//METHODS GETTERS & SETTERS
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return Destinations.values().length;
	}
}