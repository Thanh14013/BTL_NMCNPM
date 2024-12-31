
package scr.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import scr.dao.connect_to_db;

public class MainController {
    private JLabel  jlbSoHoKhau;
    private JLabel  jlbSoNhanKhau;
    private JLabel  jlbSoTamTru;
    private JLabel  jlbSoTamVang;

    public MainController(JLabel jlbSoHoKhau, JLabel jlbSoNhanKhau, JLabel jlbSoTamTru, JLabel jlbSoTamVang) {
        this.jlbSoHoKhau = jlbSoHoKhau;
        this.jlbSoNhanKhau = jlbSoNhanKhau;
        this.jlbSoTamTru = jlbSoTamTru;
        this.jlbSoTamVang = jlbSoTamVang;
    }
    
    public void setView(){
        Connection cons = connect_to_db.getConnection();
        String sql1 = "Select count(*) from hokhau;";
        String sql2= "Select count(*) from nhankhau;";
        String sql3= "Select count(*) from nhankhau where tinhtrang = 'Tạm Trú';";
        String sql4= "Select count(*) from nhankhau where tinhtrang = 'Tạm Vắng';";
        try{
                PreparedStatement ps1 = (PreparedStatement) cons.prepareStatement(sql1);  
                PreparedStatement ps2 = (PreparedStatement) cons.prepareStatement(sql2);              
                PreparedStatement ps3 = (PreparedStatement) cons.prepareStatement(sql3);              
                PreparedStatement ps4 = (PreparedStatement) cons.prepareStatement(sql4);              

                ResultSet rs1,rs2,rs3,rs4;
                
                rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    jlbSoHoKhau.setText("" + rs1.getInt(1));
                    jlbSoHoKhau.repaint();
                    jlbSoHoKhau.revalidate();
                }
                rs1.close();
                ps1.close();
                rs2 = ps2.executeQuery();
                if (rs2.next()) { // Kiểm tra có kết quả không
                    jlbSoNhanKhau.setText(" " + rs2.getInt(1));
                    jlbSoNhanKhau.repaint();
                    jlbSoNhanKhau.revalidate();
                }
                rs2.close();  
                ps2.close();                
                rs3 = ps3.executeQuery();
                if (rs3.next()) { // Kiểm tra có kết quả không
                    jlbSoTamTru.setText(" " + rs3.getInt(1));
                    jlbSoTamTru.repaint();
                    jlbSoTamTru.revalidate();
                }              
                rs3.close();  
                ps3.close();
                rs4 = ps4.executeQuery();
                if (rs4.next()) { // Kiểm tra có kết quả không
                    jlbSoTamVang.setText("" + rs4.getInt(1));
                    jlbSoTamVang.repaint();
                    jlbSoTamVang.revalidate();
                }
                rs4.close();  
                ps4.close();
                cons.close();
            
        } catch (SQLException e){
                }
        
    }

}
