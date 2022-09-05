package casestudy;
import java.sql.*;
import java.util.Scanner;

public class ssn {
	public static void sssn()
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
				
				System.out.println("Enter SSN");
				String ssn_no=sc.next();
				String service_ssn = "'"+ssn_no+"'";
				
				

				String data = String.format("SELECT * FROM person join contact_info on person.person_id = contact_info.person_id where ssn = %s ;",service_ssn);
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
				 
				 String sql1=String.format("SELECT * FROM person JOIN vehicle_info ON person.person_id = vehicle_info.person_id Where ssn= %s ",service_ssn);
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

			
			catch (Exception s) {
				System.out.println("enter");
				
				s.printStackTrace();
			}

		search.servicesearch();
	}
}





