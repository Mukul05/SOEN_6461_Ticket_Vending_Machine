package bean;

public class TicketType {

	
	public String Source;
	public String Destination;
	public int totalcount;
	public String type;
	public String vehicle;
	public String tickettypeid;
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount (int totalcount) {
		this.totalcount = totalcount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getTickettypeid() {
		return tickettypeid;
	}
	public void setTickettypeid(String tickettypeid) {
		this.tickettypeid = tickettypeid;
	}
}
