package casestudy;
import java.sql.*;
import java.util.Scanner;

public class phone_no {
	public static void sphone()
	{
	String jdbcURL = "jdbc:mysql://localhost:3306/case_study";
    String username = "root";
    String password = "Mountain@2000";

		Connection con = null;
		int flag=0;
		
		try {
			
			 con = DriverManager.getConnection(jdbcURL, username, password);
             con.setAutoCommit(false);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement st = con.createStatement();
			
			Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter Phone_no");
			String sphone=sc.next();
			String service_phone = "'"+sphone+"'";
			
			

			String data = String.format("SELECT * FROM person join contact_info on person.person_id = contact_info.person_id where Phone_no = %s ;",service_phone);
			PreparedStatement ps = con.prepareStatement(data);
			ResultSet res = st.executeQuery(data.toString());

		
		
			
			 while (res.next()) {
				 	String person_id = res.getString("Person_id");
					String first_name = res.getString("first_name");
					String last_name = res.getString("last_name");
					String gender = res.getString("gender");
					String ssn = res.getString("ssn");
					String email = res.getString("email");
					String address = res.getString("address");
					String phone_no = res.getString("phone_no");
					
					

				// Beautification of output
				System.out.format("%5s %10s %10s %10s %10s %20s  %10s %10s\n",person_id,first_name,last_name,gender,ssn,email,address,phone_no);	 
			 }
			 
			 String sql1=String.format("SELECT * FROM contact_info JOIN vehicle_info ON contact_info.person_id = vehicle_info.person_id where Phone_no = %s",service_phone);
		     PreparedStatement ps1= con.prepareStatement(sql1);
		     ResultSet rs1= st.executeQuery(sql1.toString());
		     while(rs1.next()==true) {
		    	    String car_make= rs1.getString("car_make");
			        String car_model= rs1.getString("car_model");
			        String car_model_year= rs1.getString("car_model_year");
			        String car_vin= rs1.getString("car_vin");
			       
			       
			       System.out.format("%10s %10s %10s %10s\n",car_make,car_model,car_model_year,car_vin);
			      
			       flag=1;
		     }
			 
			
				if(flag==0)
				{
					System.out.println("not found");
				}
	        
				con.close();		
			
		}
		catch (Exception e) {

			
			e.printStackTrace();
		}
		search.servicesearch();
	}

}
