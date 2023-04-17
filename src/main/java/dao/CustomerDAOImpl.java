package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import Database.Connections;
import bean.CustomerDetails;


public class CustomerDAOImpl {
	
	private static Connection conn = null;
	
	public boolean insertCustomer(CustomerDetails bean) throws ClassNotFoundException, SQLException, Exception {
		
		try {
			int id=bean.getId();
			int result=0;
			String firstName = bean.getFirstName();
			String lastName = bean.getLastName();
			String email = bean.getEmail();
			String CurrentLocation=bean.getCurrentLocation();
			String Destination = bean.getDestination();
			int NumberofTickets=bean.getNumberofTickets();
			Date tdate = bean.getTdate();
			boolean val=validateticketcount(CurrentLocation,Destination,NumberofTickets,tdate);
			if(val==false)
			{
				System.out.println("Invalid Location or Count is more");
				return false;
			}
			String insertstmt = "insert into CustomerDetails values(?,?,?,?,?,?,?,?)";
			conn = Connections.getDBConnection();
			PreparedStatement pstatement = conn.prepareStatement(insertstmt);
			pstatement.setInt(1, id);
			pstatement.setString(2, firstName);
			pstatement.setString(3, lastName);
			pstatement.setString(4, email);
			pstatement.setString(5, CurrentLocation);
			pstatement.setString(6, Destination);
			pstatement.setInt(7, NumberofTickets);
			pstatement.setDate(8, (java.sql.Date) tdate);
			result = pstatement.executeUpdate();
			
			return result>0;
		}catch (Exception e) {
			throw e;
		} finally {

			Connections.getDBCloseConnection();
		}
		
		
	}
	
	public boolean validateticketcount(String CurrentLocation,String Destination, int NumberofTickets, Date date) throws Exception {
		
		try {
			String query="";
			query = "SELECT totalcount FROM TicketType where LOWER(source) like Lower('%" + CurrentLocation + "%') and LOWER(Destination) like Lower('%" + Destination + "%')";			
			conn = Connections.getDBConnection();
			PreparedStatement pstatement = conn.prepareStatement(query);
			ResultSet resultSet = pstatement.executeQuery();
			int tcount=0;
			while (resultSet.next()) {
			tcount=resultSet.getInt("totalcount");
			}
			if(tcount==0)
				return false;
			int ccount=0;
			

			query = "SELECT sum(NumberofTickets) as ccount FROM CustomerDetails where LOWER(CurrentLocation) like Lower('%" + CurrentLocation + "%') and LOWER(Destination) like Lower('%" + Destination + "%') and tdate like ('%"+ date +"%')";			
			conn = Connections.getDBConnection();
			PreparedStatement pstatement1 = conn.prepareStatement(query);
			ResultSet resultSet1 = pstatement1.executeQuery();
			while (resultSet1.next()) {
			ccount=resultSet1.getInt("ccount");
			}
			
			if(ccount+NumberofTickets>tcount)
			{
				System.out.println("Ticket Count Exceeds");
				return false;
			}
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
		
		
		public List<CustomerDetails> readCustomers() throws ClassNotFoundException, SQLException {
			try {
				//return readUser(DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE);
				System.out.println("Inside read user");
				List<CustomerDetails> customer = new ArrayList<>();
				String query = "SELECT * FROM CustomerDetails";
				conn = Connections.getDBConnection();
				PreparedStatement pstatement = conn.prepareStatement(query);
				ResultSet resultSet = pstatement.executeQuery();
				System.out.println("Query Executed");
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String firstName = resultSet.getString("firstName");
					System.out.println(firstName);
					String lastName = resultSet.getString("lastName");
					String email = resultSet.getString("email");
					String CurrentLocation=resultSet.getString("CurrentLocation");
					String Destination=resultSet.getString("Destination");
					int NumberofTickets=resultSet.getInt("NumberofTickets");
					Date tdate=resultSet.getDate("tdate");
					CustomerDetails customers = new CustomerDetails( id, firstName, lastName, email, CurrentLocation, Destination, NumberofTickets,tdate);
					customer.add(customers);
					
				}
				
				return customer;
				
			} catch (Exception e) {
				throw e;
			}
		}
		
		
		
		
		
	

}
