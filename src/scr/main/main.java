/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package scr.main;
import java.sql.SQLException;
import scr.view.DangNhapJDialog;

/**
 *
 * @author admin
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
          DangNhapJDialog login = new DangNhapJDialog(null, true);
          login.setTitle("Đăng Nhập");
          login.setResizable(true);
          login.setLocationRelativeTo(null);
          login.setVisible(true); 

            
    }
    
}
