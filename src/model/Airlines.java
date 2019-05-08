package model;

public enum Airlines {
	
	//ATTRIBUTES
	AMERICANAIRLINES("American Airlines"),
	AVIANCA("AVIANCA"),
	VIVACOLOMBIA("Viva Colombia"),
	COPAAIRLINES("Copa Airlines"), 
	AEROMEXICO("AeroMexico"), 
	LATAM("Latam"),
	UNITEDAIRLINES("United Airlines"),
	AIRFRANCE("Air France");
	
	private String name;
	
	//CONSTRUCTOR
	private Airlines(String n) {
		this.name = n;
	}
	
	//METHODS GETTERS & SETTERS
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return Airlines.values().length;
	}
}