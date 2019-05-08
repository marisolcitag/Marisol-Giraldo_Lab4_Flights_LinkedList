package model;

public class Date implements Comparable<Date>{
	
	//ATRIBUTTES
	private int day;
	private int month;
	private int year;
	
	//CONSTRUCTOR
	public Date(int d, int m, int y) {
		this.day = d;
		this.month = m;
		this.year = y;
	}

	//METHODS GETTERS & SETTERS
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}	
	
	public String toString() {
		String date = ""+day;
		date += "/"+month;
		date += "/"+year;
		return date;
	}
	
	//COMPARE TO (ORDEN NATURAL)
	@Override
	public int compareTo(Date d) {
		int comparation = 0;
		if(year > d.year) {
			comparation = 1;
		}
		else if(year < d.year) {
			comparation = -1;
		}
		else {
			if(month > d.month) {
				comparation = 1;
			}
			else if(month < d.month) {
				comparation = -1;
			}
			else {
				if(day > d.day) {
					comparation = 1;
				}
				else if(day < d.day ) {
					comparation = -1;
				}
			}
		}
		return comparation;
	}
}