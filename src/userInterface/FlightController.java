package userInterface;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import model.Flight;
import model.ListOfFlights;

public class FlightController {
  
    @FXML
    private GridPane grid;

    @FXML
    private TextField txtNumberOfFlights;
    
    @FXML
    private TextField txtFilter;

    @FXML
    private VBox date;
    
    @FXML
    private VBox time;

    @FXML
    private VBox airlines;

    @FXML
    private VBox numFlights;

    @FXML
    private VBox destinations;
    
    @FXML
    private VBox gates;
    
    @FXML
    private Label page;

    @FXML
    private ComboBox<String> filter;
    
    private ListOfFlights fligths;
    
    private Flight firstFlight;
    
    @FXML
    void initialize() {
    	filter.getItems().add("Time");
    	filter.getItems().add("Date");
    	filter.getItems().add("Airline");
    	filter.getItems().add("Flight");
    	filter.getItems().add("Destination");
    	filter.getItems().add("Gate");
    }
    
    @FXML
    public void searchFlight(ActionEvent event) {
    	clearTable();
    	String f = filter.getValue();
    	String value = txtFilter.getText();
    	try {
    		fligths.binarySort(f, value);
    	}catch(NullPointerException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("Flight");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please Introduce a Value to Search");
        	info.show();
    	}
    	showTable();
    }
    
    /** Metodo: previousPage(ActionEvent event)
	 * Descripción:Este metodo se encarga de paginar hacia atras los n vuelos que se
	 * generan<br>
	 * @param event :ActionEvent
	 * <b>post: </b>Muestra los n vuelos previos en la Interfaz.
    */
    @FXML
    public void previousPage(ActionEvent event) {
    	int p = Integer.parseInt(page.getText())-1;
    	if(p>0) {
    		page.setText(p+"");
        	clearTable();
        	showTable();
    	}
    }
    
    /** Metodo: nextPage(ActionEvent event)
	 * Descripción:Este metodo se encarga de paginar hacia adelante los n vuelos que se
	 * generan<br>
	 * @param event :ActionEvent
	 * <b>post: </b>Muestra los n vuelos hacia adelante en la Interfaz.
    */
    @FXML
    public void nextPage(ActionEvent event) {
    	int n = Integer.parseInt(page.getText())+1;
    	if(n<fligths.getFlight().size()/18 +2) {
    		page.setText(n+"");
        	clearTable();
        	showTable();
    	}
    }

    /** Metodo: generateFlights(ActionEvent event)
	 * Descripción:Este metodo se encarga de generar vuelos de manera aleatoria en los VBox<br>
	 * @param event :ActionEvent
	 * <b>post: </b>Se genera una lista de vuelos de manera aleatoria en los VBox.
    */
    @FXML
    public void generateFlights(ActionEvent event) {
    	clearTable();
    	grid.setVisible(true);
    	fligths = new ListOfFlights(new ArrayList<Flight>());
    	ArrayList<Flight> flight = fligths.getFlight();
    	
    	int numberFlight = 0;
    	try {
    		numberFlight = Integer.parseInt(txtNumberOfFlights.getText());
    	}catch(NumberFormatException e) {
    		Alert info = new Alert(AlertType.ERROR);
        	info.setTitle("Fligths");
        	info.setHeaderText(null);
        	info.initStyle(StageStyle.UTILITY);
        	info.setContentText("Please Introduce a Number of Flights");
        	info.show();
    	} 
    	
    	for (int i = 0; i < numberFlight ; i++) {
    		Flight fl = new Flight(fligths.getRandomDate(),fligths.getRandomTime(), fligths.getRandomAirline(), fligths.getRandomFlight(), fligths.getRandomDestination(), fligths.randomGate());
    		if(firstFlight == null) {
    			firstFlight = fl;
    		}else {
    			Flight current = firstFlight;
    			while(current.getNextFlight() != null) {
    				current = current.getNextFlight();
    			}
    			current.setNextFlight(fl);
    			fl.setPreviousFlight(current);
    		}

		}   	
    	showTable();
    }
    
    /**
	 * Metodo: clearTable()
	 * Descripción:Este metodo se encarga de limpiar la información en los VBox<br>
	 * <b>post: </b>La información de los VBox se limpia
     */
    public void clearTable() {
    	time.getChildren().clear();
    	date.getChildren().clear();
		airlines.getChildren().clear();
		numFlights.getChildren().clear();
		destinations.getChildren().clear();
		gates.getChildren().clear();
    }
    
    /**
	 * Metodo: showTable()
	 * Descripción:Este metodo se encarga de mostrar la información en los VBox<br>
	 * <b>post: </b>Se puede visualizar la informacion cargada en la tabla.
     */
    public void showTable() {
    	//ArrayList<Flight> flight = fligths.getFlight();
    	Flight flight= firstFlight;
    	int pages = flight.ge/18;
    	
    	for(int j=0; j<=pages; j++) {
    		if(j+1 == Integer.parseInt(page.getText())) {	
    			for (int i = 18*j; i < 18+(18*j) && flight!=null; i++) {
    					Label timeF = new Label("\t"+flight.getTime().toString());
    					Label dateF = new Label("\t"+flight.getDate().toString());
    					Label airlineF = new Label("\t"+flight.getAirline());
    					Label numF = new Label("\t"+flight.getNumFlight());
    					Label destinationF = new Label("\t"+flight.getDestination());
    					Label gateF = new Label("\t"+flight.getGate());			
    					time.getChildren().add(timeF);
    					date.getChildren().add(dateF);
    					airlines.getChildren().add(airlineF);
    					numFlights.getChildren().add(numF);
    					destinations.getChildren().add(destinationF);
    					gates.getChildren().add(gateF);
    					flight=flight.getNextFlight();
    			}
    		}
    	}
    }
    // SORT METHODS
    /**
	 * Metodo: sortByTime(ActionEvent event)
	 * Descripción:Mediante el evento que se produce en el botón TIME en la Interfaz,se muestra la 
	 * lista de vuelos organizados  invocando el metodo selectionSortTime que ordena mediante el 
	 * ALGORITMO DE SELECCIÓN <br>
	 * @param event:ActionEvent
     * <b>post: </b>Genera la lista de vuelos ordenada por TIME 
     */
    @FXML
    void sortByTime(ActionEvent event)  throws InvocationTargetException{
    	clearTable();
    	fligths.insertionSortTime(fligths.getFlight());
    	showTable();
    }
    
    @FXML
    public void sortByDate(ActionEvent event) throws InvocationTargetException{
    	clearTable();
    	fligths.insertionSortDate(fligths.getFlight());
		showTable();
    }
    
    /**
	 * Metodo: sortByAirline(ActionEvent event)
	 * Descripción:Mediante el evento que se produce en el botón AIRLINE en la Interfaz,se muestra la 
	 * lista de vuelos organizados  invocando el metodo selectionSortAirline que ordena mediante el 
	 * ALGORITMO DE SELECCIÓN <br>
	 * @param event:ActionEvent
     * <b>post: </b>Genera la lista de vuelos ordenada por AIRLINE 
     */
    @FXML
    void sortByAirline(ActionEvent event)  throws InvocationTargetException{
    	clearTable();
    	fligths.selectionSortAirline(fligths.getFlight());
    	showTable();	
    }
    
    /**
	 * Metodo: sortByFlight(ActionEvent event)
	 * Descripción:Mediante el evento que se produce en el botón FLIGHT en la Interfaz,se muestra la 
	 * lista de vuelos organizados  invocando el metodo selectionSortFlight que ordena mediante el 
	 * ALGORITMO DE SELECCIÓN <br>
	 * @param event:ActionEvent
     * <b>post: </b>Genera la lista de vuelos ordenada por FLIGHT 
     */
    @FXML
    void sortByFlight(ActionEvent event)  throws InvocationTargetException{
    	clearTable();
    	ArrayList<Flight> flight = fligths.getFlight();
    	fligths.selectionSortFlight(flight);
    	showTable();
    }
    
    /**
	 * Metodo: sortByDestination(ActionEvent event)
	 * Descripción:Mediante el evento que se produce en el botón DESTINATION en la Interfaz,se muestra la 
	 * lista de vuelos organizados  invocando el metodo selectionSortDestination que ordena mediante el 
	 * ALGORITMO DE SELECCIÓN <br>
	 * @param event:ActionEvent
     * <b>post: </b>Genera la lista de vuelos ordenada por DESTINATION
     */
    @FXML
    void sortByDestination(ActionEvent event)  throws InvocationTargetException{
    	clearTable();
    	fligths.selectionSortDestination(fligths.getFlight());
    	showTable();
    }
    
    /**
	 * Metodo: sortByGate(ActionEvent event)
	 * Descripción:Mediante el evento que se produce en el botón GATE en la Interfaz,se muestra la 
	 * lista de vuelos organizados  invocando el metodo bubbleSortGate que ordena mediante el 
	 * ALGORITMO DE BURBURJA <br>
	 * @param event:ActionEvent
     * <b>post: </b>Genera la lista de vuelos ordenada por GATE
     */
    @FXML
    void sortByGate(ActionEvent event)  throws InvocationTargetException{
    	clearTable();
    	fligths.bubbleSortGate(fligths.getFlight());
    	showTable();
    }
}