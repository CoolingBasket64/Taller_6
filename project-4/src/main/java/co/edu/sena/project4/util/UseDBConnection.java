package co.edu.sena.project4.util;

import java.sql.*;


public class UseDBConnection {
    private static Connection getConnection() throws SQLException {
        return DBConnection.getConnection();
    }
    public static void main(String[] args) throws SQLException {
        try(Connection con = getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM MyApp.users_tbl")) {
            while (rs.next()) {
                System.out.print(rs.getString("user_name"));
                System.out.print(" | ");
                System.out.print(rs.getString("user_lastname"));
            }
        }
    }
}
