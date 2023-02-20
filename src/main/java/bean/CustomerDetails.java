package bean;


import java.sql.Date;
public class CustomerDetails {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	public String CurrentLocation;
	
	public String Destination;
	
	public int NumberofTickets;
	
	public java.sql.Date tdate;
	
	public CustomerDetails(int id,String firstName, String lastName, String email , String CurrentLocation, String Destination,int NumberofTickets, Date tdate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.CurrentLocation=CurrentLocation;
		this.Destination=Destination;
		this.NumberofTickets=NumberofTickets;
		this.tdate=tdate;
	}

	
	public CustomerDetails(String firstName, String lastName, String email , String CurrentLocation, String Destination,int NumberofTickets, Date tdate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.CurrentLocation=CurrentLocation;
		this.Destination=Destination;
		this.NumberofTickets=NumberofTickets;
		this.tdate=tdate;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCurrentLocation() {
		return CurrentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		CurrentLocation = currentLocation;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public int getNumberofTickets() {
		return NumberofTickets;
	}

	public void setNumberofTickets(int numberofTickets) {
		NumberofTickets = numberofTickets;
	}


	public Date getTdate() {
		return tdate;
	}


	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	
}
