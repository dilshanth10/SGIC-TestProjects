package ExamplePackage;

import java.sql.*;
import java.util.*;

public class ConnectionManager {

    static Connection con;
    static String url;

    public static Connection getConnection() {

        try {
            String url = "jdbc:mysql://localhost/leavesystem?useSSL=false";
            // assuming "DataSource" is your DataSource name

            Class.forName("com.mysql.cj.jdbc.Driver");

            try {
                con = DriverManager.getConnection(url, "root", "manager");

                // assuming your SQL Server's	username is "username"               
                // and password is "password"
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return con;
    }
}
