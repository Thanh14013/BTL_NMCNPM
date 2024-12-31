package scr.dao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class connect_to_db {
    public static Connection getConnection() {
            Connection cons = null;
            String url = "jdbc:mysql://localhost:3306/quanlychungcu";
            var user = "root";
            var password = "";
            try {
                cons = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex){
                    Logger.getLogger(connect_to_db.class.getName()).log(Level.SEVERE, null,ex);
                    }
            return cons;
    }
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}

