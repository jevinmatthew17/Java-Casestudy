package casestudy;
import java.sql.*;
import java.util.Scanner;

public class create {
	public static void servicecreate()
	{
	
		String jdbcURL = "jdbc:mysql://localhost:3306/case_study";
        String username = "root";
        String password = "Mountain@2000";

			Connection con = null;
			
			Scanner a=new Scanner(System.in);
			int cou;
			String su;
		do {
			System.out.println("Create a record");
			 System.out.println("1 To enter Details");
			  System.out.println("2 Exit");
			  cou=a.nextInt();
			  switch(cou) {
			  case 1:
			
			    try {
				
				 con = DriverManager.getConnection(jdbcURL, username, password);
	             con.setAutoCommit(false);
				 
				Class.forName("com.mysql.cj.jdbc.Driver");
	
				

					
					Statement st = con.createStatement();
					
					System.out.println("Enter the following Details");
			         Scanner sc= new Scanner(System.in);
			         System.out.println("Enter Person ID");
			         int pid=sc.nextInt();
			         //String spid="'"+pid +"'";
			         System.out.println("Enter First Name");
			         String fname=sc.next();
			         //String sfname="'"+fname +"'";
			         System.out.println("Enter Last Name");
			         String lname=sc.next();
			         //String slname="'"+lname +"'";
			         System.out.println("Enter Gender(Male/Female)");
			         String gender=sc.next();
			         //String sgender="'"+gender +"'";
			         System.out.println("Enter SSN");
			         String ssn=sc.next();
			         
			         String sql="insert into person(PERSON_ID,First_Name,Last_Name,Gender,SSN) values(?,?,?,?,?)";
			         PreparedStatement statement=con.prepareStatement(sql); 
			
				        
					 statement.setInt(1, pid);
			         statement.setString(2, fname);
			         statement.setString(3, lname);
			         statement.setString(4, gender);
			         statement.setString(5, ssn);
			       
			         //statement.executeUpdate(sql);
			         statement.addBatch();
			         statement.executeBatch();
			         con.commit();
			         System.out.println(" records inserted in person\n"); 
						
					statement.close();
				     
						
			           create_contact obj =new create_contact();
			           create_contact.contact();
								
			           create_vehicle obj1 =new create_vehicle();
			           create_vehicle.vehicle();
			            
					con.close();
				}

				
				catch (Exception s) {
					s.printStackTrace();
					
					System.out.println(
						"SQL statement is not executed!");
				}
				
				 }
		}
			while(cou!=2);
			controller.main(null);
			
			
}
		

	}


