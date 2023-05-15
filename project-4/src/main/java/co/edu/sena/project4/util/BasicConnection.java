package co.edu.sena.project4.util;

import java.sql.*;

public class BasicConnection {
    public static void main(String[] args){
        String URL = "jdbc:mysql://LocalHost:3306/MyApp?severTimezone=America/Bogota";
        String username = "root";
        String password = "";

        String sql = null;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try{
            sql = "SELECT *FROM MyApp.users_tbl";
            con = DriverManager.getConnection(URL, username, password);
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()){
                System.out.print(rs.getString("user_name"));
                System.out.print(" | ");
                System.out.print(rs.getString("user_lastname"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                stm.close();
                con.close();
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
