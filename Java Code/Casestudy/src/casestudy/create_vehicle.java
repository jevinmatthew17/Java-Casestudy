package casestudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class create_vehicle {

	public static void vehicle()
	{
		String jdbcURL = "jdbc:mysql://localhost:3306/case_study";
        String username = "root";
        String password = "Mountain@2000";

			Connection con = null;
			Scanner a=new Scanner(System.in);
			
			    	 	try {

					 con = DriverManager.getConnection(jdbcURL, username, password);
		             con.setAutoCommit(false);
					 
					Class.forName("com.mysql.cj.jdbc.Driver");
		
			
				 
					System.out.println("Enter the following Details for CAR Information:");
			         Scanner sc= new Scanner(System.in);
			         System.out.println("Enter your Person ID:");
			         int pid=sc.nextInt();
			         System.out.println("Enter your Car Making:");
				        String car_make=sc.next();
				        //String rcar_make="'"+car_make +"'";
				        System.out.println("Enter your Car Model:");
				        String car_model=sc.next();
				        //String rcar_model="'"+car_model +"'";
				        System.out.println("Enter your Car Model Year:");
				        String car_model_year=sc.next();
				        //String rcar_model_year="'"+car_model_year +"'";
				        System.out.println("Enter your Car VIN:");
				        String car_vin=sc.next();
				        //String rcar_vin="'"+car_vin +"'";		      
				        PreparedStatement statement2=con.prepareStatement("insert into vehicle_info(PERSON_ID,car_make,car_model,car_model_year,car_VIN) values(?,?,?,?,?)"); 
				        statement2.setInt(1, pid);
				        statement2.setString(2, car_make);
				        statement2.setString(3, car_model);
				        statement2.setString(4, car_model_year);
				        statement2.setString(5, car_vin);
				        
				        
				        System.out.println(" records inserted in vehicle\n"); 
				        
				        statement2.addBatch();
				        statement2.executeBatch();
				 
				        con.commit();
				        statement2.close();
					
					
					con.close();	
			}
			     
			catch (Exception e) {

				
				e.printStackTrace();
			}
				
	}
}
