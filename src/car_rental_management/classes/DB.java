/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car_rental_management.classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author user
 */
public class DB {
    
    private static String serverName = "localhost";
    private static String userName = "root";
    private static String dbName = "java_car_renatl";
    private static int port = 3306;
    private static String pass = "";
    
    //function to create and return connection
    public static Connection getConnection()
    {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + port + "/" + dbName, userName, pass);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
       return connection;
    }
    
    public static boolean testConnection() {
    try (Connection conn = getConnection()) {
        if (conn != null) {
            // Run a test query
            try (java.sql.Statement stmt = conn.createStatement()) {
                ResultSet rs;
                rs = stmt.executeQuery("SELECT 1");
                if (rs.next()) {
                    return true; // Connection is valid
                }
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false; // Connection failed
}
    
}
