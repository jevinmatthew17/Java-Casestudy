package casestudy;
import java.sql.*;
import java.util.Scanner;
import java.io.*;

public class create_contact {
	public static void contact()
	{
	
		String jdbcURL = "jdbc:mysql://localhost:3306/case_study";
        String username = "root";
        String password = "Mountain@2000";

			Connection con = null;

			
			try {
				
				 con = DriverManager.getConnection(jdbcURL, username, password);
	             con.setAutoCommit(false);
				 
				Class.forName("com.mysql.cj.jdbc.Driver");
	
				

					
					System.out.println("Enter Details for CONTACT Information:");
					Scanner sc= new Scanner(System.in);
					System.out.println("Enter your Person ID:");
					int pid=sc.nextInt();
					System.out.println("Enter your Email ID:");
					String mail=sc.next();
					//String rmail="'"+mail +"'";
					System.out.println("Enter your Address:");
					String address=sc.next();
					//String raddress="'"+address +"'";
					System.out.println("Enter your Phone Number:");
					String phno=sc.next();
					//String rphno="'"+phno +"'";
					PreparedStatement statement1=con.prepareStatement("insert into contact_info(PERSON_ID,email,address,phone_no)  values(?,?,?,?)"); 
					statement1.setInt(1, pid);
					statement1.setString(2, mail);
					statement1.setString(3, address);
					statement1.setString(4, phno);
					//statement1.executeUpdate();  
					System.out.println(" records inserting in contact\n"); 
					
					statement1.addBatch();
			        statement1.executeBatch();
			 
			        con.commit();
			        statement1.close();
			        
					con.close();
				

				
				

				
			}
			catch (Exception e) {

				System.out.println("Person ID mismatching");
				//e.printStackTrace();
			}
		
	}

}
 

