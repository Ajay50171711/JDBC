package lab_27;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Customer_data {
    public static void main(String[] args) {
        try {
            // Establish a connection to the MySQL database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_27", "root", "Ajay@123");
            Statement stm = con.createStatement();

            // Uncomment and use one of the following queries to perform specific operations

            // Inserting data into the customer table
            // String s = "INSERT INTO customer VALUES(1, 'Ajay', 'malad', 932699, 'Shimla', 171001, 'India')";
            // String s = "INSERT INTO customer VALUES(2, 'Kamlesh', 'goregaon', 729239, 'Shimla', 179061, 'India')";

            // Updating data in the customer table
            // String s = "UPDATE customer SET City='Shillong' WHERE Custno=1";

            // Deleting data from the customer table
            // String s = "DELETE FROM customer WHERE Custno=2";

            // Uncomment the query of your choice and execute it
            // stm.execute(s);
            // System.out.println("Query executed");

            // Fetching and displaying data from the customer table
            String selectQuery = "SELECT * FROM customer";
            ResultSet rs = stm.executeQuery(selectQuery);
            while (rs.next()) {
                int id = rs.getInt("Custno");
                String name = rs.getString("Custname");
                String address = rs.getString("Custaddress");
                int phoneNo = rs.getInt("Phoneno");
                String city = rs.getString("City");
                int pincode = rs.getInt("Pincode");
                String country = rs.getString("Country");
                System.out.println(id + " " + name + " " + address + " " + phoneNo + " " + city + " " + pincode + " " + country);
            }

            // Close the ResultSet, Statement, and Connection
            rs.close();
            stm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
