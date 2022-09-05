package casestudy;
import java.io.*;
import java.sql.*; 

public class Vehicle_info {

    public static void insertvehicle() {
         String jdbcURL = "jdbc:mysql://localhost:3306/case_study";
         String username = "root";
         String password = "Mountain@2000";
         String csvFilePath = "C:\\Users\\LJevin\\Downloads\\Java_Case_Study.csv";
         
         
         Connection connection = null;



        try {



            connection = DriverManager.getConnection(jdbcURL, username, password);
             connection.setAutoCommit(false);



            String sql = "INSERT INTO vehicle_info (Person_ID, Car_make,Car_Model,Car_Model_year, Car_VIN) VALUES (?, ?, ?, ?, ?)";
             PreparedStatement statement = connection.prepareStatement(sql);



            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
             String lineText = null;




             lineReader.readLine(); // skip header line



            while ((lineText = lineReader.readLine()) != null) {
                 String[] data = lineText.split(",");
                 String person_id = data[0];
                 String car_make = data[6];
                 String car_model = data[7];
                 String car_model_year = data[8];
                 String car_vin = data.length == 12 ? data[9] : "";



                statement.setString(1, person_id);
                 statement.setString(2, car_make);
                 statement.setString(3, car_model);
                 statement.setString(4, car_model_year);
                 statement.setString(5, car_vin);
                 
                 



                statement.addBatch();



               
                     statement.executeBatch();
                 
             }



            lineReader.close();



            // execute the remaining queries
             statement.executeBatch();



            connection.commit();
             connection.close();



        } catch (IOException ex) {
             System.err.println(ex);
         } catch (SQLException ex) {
             ex.printStackTrace();



            try {
                 connection.rollback();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
    }
}
