package Dataproviders;


import org.testng.annotations.DataProvider;
import java.sql.*;
import java.util.*;

public class DBDataProvider {

    @DataProvider(name = "FormDataFromDB")
    public Object[][] getFormDataFromDB() throws Exception {
        String url = "jdbc:mysql://localhost:3306/demoqa";
        String username = "root";
        String password = "Srirampraveen01@";

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT firstname, lastname, email, gender, mobile FROM formdata");

        List<Object[]> records = new ArrayList<>();
        while (rs.next()) {
            records.add(new Object[]{
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("email"),
                rs.getString("gender"),
                rs.getString("mobile")
            });
        }
        conn.close();

        return records.toArray(new Object[records.size()][]);
    }
}
