package member5_loggerutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// DBUtils is used to connect and fetch data from MySQL
public class DBUtils {

    // Get DB connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Change these to your DB values
            String url = "jdbc:mysql://localhost:3306/testdb";  
            String user = "root";  
            String pass = "password";  

            // Connect to DB
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Example method to run a query
    public static void getUsers() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                // Print first column data
                System.out.println(rs.getString(1));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
