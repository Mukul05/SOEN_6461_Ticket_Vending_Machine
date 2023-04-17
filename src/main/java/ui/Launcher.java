package ui;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

import bean.CustomerDetails;
import dao.CustomerDAOImpl;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CustomerDAOImpl customer=new CustomerDAOImpl();
			System.out.println(customer.readCustomers());
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			java.sql.Date sqlDate = new java.sql.Date(df.parse("02-19-2023").getTime());
			
			
			
			CustomerDetails c = new CustomerDetails("Arawn","Uchiha","arawnuchiha@gmail.com","Montreal","Toronto",1, sqlDate);
			boolean f=customer.insertCustomer(c);
			if(f==true)
				System.out.println("Inserted");
			else
				System.out.println("Not Inserted");
		}catch (ClassNotFoundException | SQLException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
