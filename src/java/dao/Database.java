/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Database {
 
    public static Connection getConnection() {
        try {
            Class.forName("org.postgres.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            return con;
        } catch (ClassNotFoundException ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        } catch (SQLException ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
        }
    }
}
