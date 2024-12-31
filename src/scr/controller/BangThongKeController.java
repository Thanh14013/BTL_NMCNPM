
package scr.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import scr.dao.connect_to_db;


public class BangThongKeController {
    private JLabel jtfdvcc;
    private JLabel jtfqlcc;
    private JLabel jtftn;
    private JLabel jtfslxm;
    private JLabel jtfslot;
    private JLabel jtftiht;
    
    private int mahokhau;

    public BangThongKeController(JLabel jtfdvcc, JLabel jtfqlcc, JLabel jtftn, JLabel jtfslxm, JLabel jtfslot, JLabel jtftiht, int mahokhau) {
        this.jtfdvcc = jtfdvcc;
        this.jtfqlcc = jtfqlcc;
        this.jtftn = jtftn;
        this.jtfslxm = jtfslxm;
        this.jtfslot = jtfslot;
        this.jtftiht = jtftiht;
        this.mahokhau = mahokhau;

    }
    public void setEvent(){
         Connection cons = connect_to_db.getConnection();
        String sql= "SELECT * FROM hokhau_khoanphi WHERE mahokhau = ?;";
        try{
            ResultSet rs;
            try (PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                ps.setInt(1,mahokhau);
                ps.execute();
                String[] str = new String[6];
                int i=0;
                rs = ps.executeQuery();
                while (rs.next()){
                        str[i] ="" + rs.getDouble("sotien");
                        i++;
                }
                jtfdvcc.setText(str[0]);
                jtfqlcc.setText(str[1]);
                jtftn.setText(str[2]);
                jtfslxm.setText(str[3]);
                jtfslot.setText(str[4]);  
                jtftiht.setText(str[5]);
                jtfdvcc.revalidate();
                jtfdvcc.repaint();
                jtfqlcc.revalidate();
                jtfqlcc.repaint();
                jtftn.revalidate();
                jtftn.repaint();
                jtfslxm.revalidate();
                jtfslxm.repaint();
                jtfslot.revalidate();
                jtfslot.repaint();
                jtftiht.revalidate();
                jtftiht.repaint();
            }
            cons.close();
            rs.close();
        } catch (SQLException e){
        }
    }
    
}
