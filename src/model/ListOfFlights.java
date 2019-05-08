package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListOfFlights {
	
	//ATTRIBUTES
	List<Flight> flights;
	
	//CONSTRUCTOR
	public ListOfFlights(List<Flight> listofflights) {
		flights = new ArrayList<Flight>();
	}
	
	//METHODS GETTERS & SETTERS
	public ArrayList<Flight> getFlight() {
		return (ArrayList<Flight>) flights;
	}
	
	/** Metodo: getRandomDate():Date
	 * Descripción:Este metodo se encarga de genera una muestra de datos de fecha aleatorios<br>
	 * <b>post: </b> Genera n datos aleatorios de fecha
	 * @return date
    */	
	public Date getRandomDate() {
		Random rnd = new Random();
		int days = rnd.nextInt(31);
		int month = rnd.nextInt(12);
		int year = rnd.nextInt(20);
		year += 2019;
		if(month==2) {
			days = rnd.nextInt(28);
		}
		if(days ==0) {
			++days ;
		}
		
		if(month ==0) {
			++month;
		}
		Date date = new Date(year, month, days);
	
		return date;
	}
	
	/** Metodo: getRandomTime():Time
	 * Descripción:Este metodo se encarga de genera una muestra de datos de tiempos aleatorios<br>
	 * <b>post: </b> Genera n datos aleatorios de tiempo
	 * @return time
    */
	public Time getRandomTime() {
		Random rnd = new Random();
		int hour = rnd.nextInt(12);
		int minute = rnd.nextInt(59);
		int hourclock = rnd.nextInt(2);
		Time time = new Time(hour, minute, hourclock);
		return time;
	}
	
	/** Metodo: getRandomFlight()
	 * Descripción:Este metodo se encarga de genera una muestra de datos de numeros de vuelos aleatorios<br>
	 * <b>post: </b> Genera n datos aleatorios de numeros de vuelos
	 * @return f
    */
	public String getRandomFlight() {
		String f = "";
		Random rnd = new Random();
		f = randomGate();
		int numbers = rnd.nextInt(999);
		if(numbers<99) {
			f += "0"+ numbers;
		}else if(numbers<9) {
			f += "00"+numbers;		
		}else {
			f += numbers;
		}
		
		return f;
	}
	
	/** Metodo: getRandomAirline()
	 * Descripción:Este metodo se encarga de genera una muestra de datos de aerolineas aleatorias<br>
	 * <b>post: </b> Genera n datos aleatorios de aerolineas
	 * @return a
    */
	public String getRandomAirline() {
		String a = "";
		Random rnd = new Random();
		int value = rnd.nextInt(8);
		for (int i = 0; i < Airlines.values().length; i++) {
			if(value == i) {
				a = Airlines.values()[i].name();
			}
		}
		return a;
	}
	
	/** Metodo: getRandomDestination()
	 * Descripción:Este metodo se encarga de genera una muestra de datos de destinos aleatorios<br>
	 * <b>post: </b> Genera n datos aleatorios de destinos
	 * @return d
    */
	public String getRandomDestination() {
		String d = "";
		Random rnd = new Random();
		int value = rnd.nextInt(8);
		for (int i = 0; i < Destinations.values().length; i++) {
			if(value == i) {
				d = Destinations.values()[i].getName();
			}
		}
		return d;
	}
	
	/** Metodo: getRandomGate()
	 * Descripción:Este metodo se encarga de genera una muestra de datos de gates aleatorios<br>
	 * <b>post: </b> Genera n datos aleatorios de gates
	 * @return c
    */
	public String randomGate() {
		char c = 'a';
		String alphabet =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		c = alphabet.charAt(rnd.nextInt(26));
		alphabet = ""+c;
		return alphabet;
	}
	
	//ALGORITHMS SORT 
	/**
	 * Metodo: insertionSortTime(ArrayList<Flight> flights)
	 * Descripción:Organiza la lista de vuelos por TIME usando el ALGORITMO DE INSERCIÓN <br>
	 * @param flights :ArrayList<Flight>
     * <b>post: </b>La lista de vuelos está ordenada por TIME mediante el ALGORITMO DE INSERCIÓN
     */
	public void insertionSortTime(ArrayList<Flight> flights) {
		for(int i=1; i<flights.size();i++) {
			for(int j=i;j>0 && flights.get(j-1).getTime().compareTo(flights.get(j).getTime())<0;j--){
				Flight temporal=flights.get(j);
				flights.set(j, flights.get(j-1));
				flights.set(j-1, temporal);
			}
		}
	}
	
	/**
	 * Metodo: insertionSortDate(ArrayList<Flight> flights)
	 * Descripción:Organiza la lista de vuelos por DATE usando el ALGORITMO DE INSERCIÓN <br>
	 * @param flights :ArrayList<Flight>
     * <b>post: </b>La lista de vuelos está ordenada por DATE mediante el ALGORITMO DE INSERCIÓN
     */
	public void insertionSortDate(ArrayList<Flight> flights) {
		for(int i=1; i<flights.size();i++) {
			for(int j=i;j>0 && flights.get(j-1).getDate().compareTo(flights.get(j).getDate())<0;j--){
				Flight temporal=flights.get(j);
				flights.set(j, flights.get(j-1));
				flights.set(j-1, temporal);
			}
		}
	}
		
	/**
	 * Metodo: selectionSortAirline(ArrayList<Flight> flights)
	 * Descripción:Organiza la lista de vuelos por AIRLINE usando el ALGORITMO DE SELECCIÓN <br>
	 * @param flights :ArrayList<Flight>
     * <b>post: </b>La lista de vuelos está ordenada por AIRLINE mediante el ALGORITMO DE SELECCIÓN
     */
	public void selectionSortAirline(ArrayList<Flight> flights) {
		for (int i = 0; i < flights.size()-1; i++) {
			String minAirline = flights.get(i).getAirline();
			int minpos = i;
			for (int j = i+1; j < flights.size(); j++) {
				String currentAirline = flights.get(j).getAirline();
				if(currentAirline.compareTo(minAirline)<0) {
					minAirline = currentAirline;
					minpos = j;
				}
			}
			Flight temporal = flights.get(minpos);
			flights.set(minpos, flights.get(i));
			flights.set(i, temporal);
		}
	}
	
	/**
	 * Metodo: selectionSortFlight(ArrayList<Flight> flights)
	 * Descripción:Organiza la lista de vuelos por Flight usando el ALGORITMO DE SELECCIÓN <br>
	 * @param flights :ArrayList<Flight>
     * <b>post: </b>La lista de vuelos está ordenada por Flights mediante el ALGORITMO DE SELECCIÓN
     */
	public void selectionSortFlight(ArrayList<Flight> flights) {
    	for (int i = 0; i < flights.size()-1; i++) {
			String minFlight = flights.get(i).getNumFlight();
			int minpos = i;
			for (int j = i+1; j < flights.size(); j++) {
				String currentFlight = flights.get(j).getNumFlight();
				if(currentFlight.compareTo(minFlight)<0) {
					minFlight = currentFlight;
					minpos = j;
				}
			}
			Flight temporal = flights.get(minpos);
			flights.set(minpos, flights.get(i));
			flights.set(i, temporal);
		}
    }
	
	/**
	 * Metodo: selectionSortDestination(ArrayList<Flight> flights)
	 * Descripción:Organiza la lista de vuelos por DESTINATION usando el ALGORITMO DE SELECCIÓN <br>
	 * @param flights :ArrayList<Flight>
     * <b>post: </b>La lista de vuelos está ordenada por DESTINATION mediante el ALGORITMO DE SELECCIÓN
     */
	public void selectionSortDestination(ArrayList<Flight> flights) {
    	for (int i = 0; i < flights.size()-1; i++) {
			String minDestination = flights.get(i).getDestination();
			int minpos = i;
			for (int j = i+1; j < flights.size(); j++) {
				String currentDestiny = flights.get(j).getDestination();
				if(currentDestiny.compareTo(minDestination)<0) {
					minDestination = currentDestiny;
					minpos = j;
				}
			}
			Flight temporal = flights.get(minpos);
			flights.set(minpos, flights.get(i));
			flights.set(i, temporal);
		}
    }
	
	/**
	 * Metodo: selectionSortDestination(ArrayList<Flight> flights)
	 * Descripción:Organiza la lista de vuelos por GATE usando el ALGORITMO DE BURBUJA <br>
	 * @param flights :ArrayList<Flight>
     * <b>post: </b>La lista de vuelos está ordenada por GATE mediante el ALGORITMO DE BURBUJA
     */
	public void bubbleSortGate(ArrayList<Flight> flights) {
		if(flights.size()>1) {
			for (int i=0; i<flights.size();i++) {
				for (int j=0;j<flights.size()-i-1;j++) {
					String mayorGate= flights.get(j).getGate();
					String currentGate=flights.get(j+1).getGate();
					if(mayorGate.compareTo(currentGate)>0) {
						Flight temporal=flights.get(j);
						flights.set(j, flights.get(j+1));
						flights.set(j+1, temporal);
					}
				}
			}
		}
	}
		
	/**
	 * Metodo: searchFlightByAirline( String a )
	 * Descripción:Este metodo se encargar de buscar un vuelo por AIRLINE 
	 * de FORMA SECUENCIALbr>
	 * @param a: String
	 * @return position
	 * <b>post: </b>Retorna la posicion del AIRLINE que se ingreso como parametro a buscar
     */
	public int searchFlightByAirline( String a ){
        int position = -1;
        boolean stop = false;

        for( int i = 0; i < flights.size( ) && !stop; i++ ){
            Flight f = ( Flight )flights.get( i );
            String airlineF = f.getAirline();

            if( airlineF.equalsIgnoreCase(a)){
                position = i;
                stop = true;
            }
        }

        return position;
    }
	
	/**todo: searchFlightByGate( String a )
	 * Descripción:Este metodo se encargar de buscar un vuelo por GATE 
	 * de FORMA SECUENCIALbr>
	 * @param a: String
	 * @return position
	 * <b>post: </b>Retorna la posicion del Gate que se ingreso como parametro a buscar
    */
	public int searchFlightByGate( String g ){
       int position = -1;
       boolean stop = false;

       for( int i = 0; i < flights.size( ) && !stop; i++ ){
           Flight f = ( Flight )flights.get( i );
           String GateF = f.getGate();

           if( GateF.equalsIgnoreCase(g)){
               position = i;
               stop = true;
           }
       }
       return position;
   }
		
	//ALGORITHM SORT BINARY
	public Flight binarySort(String filter, String value){
		int high = flights.size()-1;
		int low = 0;
		int mid = -1;
		boolean stop = false;
		switch (filter) {
		
		case "Time":
			for (int i = 0; i < flights.size() && stop == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getTime().toString().equalsIgnoreCase(value)) {
					stop = true;
				}else if(flights.get(mid).getTime().toString().compareTo(value)<0) {
					high = mid-1;
				}else if(flights.get(mid).getTime().toString().compareTo(value)>0) {
					low = mid+1;
				}
			}
			break;
			
		case "Date":
			for (int i = 0; i < flights.size() && stop == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getDate().toString().equalsIgnoreCase(value)) {
					stop = true;
				}else if(flights.get(mid).getDate().toString().compareTo(value)<0) {
					high = mid-1;
				}else if(flights.get(mid).getDate().toString().compareTo(value)>0) {
					low = mid+1;
				}
			}
			break;
			
		case "Airline":
			for (int i = 0; i < flights.size() && stop == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getAirline().equalsIgnoreCase(value)) {
					stop = true;
				}else if(flights.get(mid).getAirline().compareTo(value)<0) {
					high = mid-1;
				}else if(flights.get(mid).getAirline().compareTo(value)>0) {
					low = mid+1;
				}
			}
			break;
			
		case "Flight":
			for (int i = 0; i < flights.size() && stop == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getNumFlight().equalsIgnoreCase(value)) {
					stop = true;
				}else if(flights.get(mid).getNumFlight().compareTo(value)<0) {
					high = mid-1;
				}else if(flights.get(mid).getNumFlight().compareTo(value)>0) {
					low = mid+1;
				}
			}
			break;
			
		case "Destination":
			
			for (int i = 0; i < flights.size() && stop == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getDestination().equalsIgnoreCase(value)) {
					stop = true;
				}else if(flights.get(mid).getDestination().compareTo(value)>0) {
					high = mid-1;
				}else if(flights.get(mid).getDestination().compareTo(value)<0) {
					low = mid+1;
				}
			}
			break;
			
		case "Gate":
			
			for (int i = 0; i < flights.size() && stop == false ; i++) {
				mid = (low+high)/2;
				if(flights.get(mid).getGate().equalsIgnoreCase(value)) {
					stop = true;
				}else if(flights.get(mid).getGate().compareTo(value)<0) {
					high = mid-1;
				}else if(flights.get(mid).getGate().compareTo(value)>0) {
					low = mid+1;
				}
			}
			break;
			
		default:
			mid = -1; 
			break;
		}
		Flight f =  flights.get(mid);
		flights.clear();
		flights.add(f);
		return f;
	}
}