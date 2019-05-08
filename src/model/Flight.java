package model;

public class Flight implements Comparable<Flight>{
	
	//ATTRIBUTES
	private Date date;
	private Time time;
	private String airline;
	private String numFlight;
	private String destination;
	private String gate;
	
	private Flight next;
	private Flight previous;

	//CONSTRUCTOR
	public Flight(Date date, Time time, String airline, String numFlight, String destination, String gate) {
		this.date = date;
		this.time = time;
		this.airline = airline;
		this.numFlight = numFlight;
		this.destination = destination;
		this.gate = gate;
	}

	//METHODS GETTERS & SETTERS
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getAirline() {
		return this.airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getNumFlight() {
		return this.numFlight;
	}

	public void setNumFlight(String numFlight) {
		this.numFlight = numFlight;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getGate() {
		return this.gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	//COMPARE TO (ORDEN NATURAL)
	@Override
	public int compareTo(Flight flights) {
		int compare;
		if(airline.compareTo(airline)<0) {
			compare = -1;
		}else if(airline.compareTo(airline)>0) {
			compare = 1;
		}else {
			compare = 0;
		}
		return compare;
	}
	
	public Flight getNextFlight() {
		return next;
	}

	public void setNextFlight(Flight f) {
		this.next = f;
	}

	public Flight getPreviousFlight() {
		return previous;
	}

	public void setPreviousFlight(Flight f) {
		this.previous = f;
	}
}