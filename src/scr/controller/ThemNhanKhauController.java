package scr.controller;

import scr.model.NhanKhau;
import scr.service.NhanKhauService;
import scr.service.NhanKhauserviceimpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import scr.dao.connect_to_db;
import java.sql.PreparedStatement;
public class ThemNhanKhauController {
    private JButton bntSubmit;
    private JTextField jtfmanhankhau;
    private JTextField jtfhoten;
    private JTextField jtfsdt;
    private JTextField jtfcmnd;
    private JTextField jtfmahokhau;
    private JComboBox jtftinhtrang;
    private JLabel jlbMsg;
    private JDateChooser jdcngaysinh;
            
    private  NhanKhau nhankhau=null;
    private NhanKhauService nhankhauservice=null;

    public ThemNhanKhauController(JButton bntSubmit, JTextField jtfmanhankhau, JTextField jtfhoten, JTextField jtfsdt, JTextField jtfcmnd, JTextField jtfmahokhau, JComboBox jtftinhtrang, JDateChooser jdcngaysinh, JLabel jlbMsg) {
        this.bntSubmit = bntSubmit;
        this.jtfmanhankhau = jtfmanhankhau;
        this.jtfhoten = jtfhoten;
        this.jtfsdt = jtfsdt;
        this.jtfcmnd = jtfcmnd;
        this.jtfmahokhau = jtfmahokhau;
        this.jtftinhtrang = jtftinhtrang;
        this.jlbMsg = jlbMsg;
        this.jdcngaysinh = jdcngaysinh;
        
        this.nhankhauservice = new NhanKhauserviceimpl();
    }
    
    public void setView(NhanKhau nhankhau){
        this.nhankhau= nhankhau;

        jtfmanhankhau.setText(""+ nhankhau.getMaNhanKhau());
        jtfmahokhau.setText("" +nhankhau.getMaHoKhau());
        jtfhoten.setText(nhankhau.getHoTen());
        jtfsdt.setText(nhankhau.getSDT());
        jtfcmnd.setText(nhankhau.getCMND());
        jdcngaysinh.setDate(nhankhau.getNgaySinh());
        jtftinhtrang.setSelectedItem(nhankhau.getTinhTrang());
        
        setEven();
        
    }
    
    public void setEven(){
         bntSubmit.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e){
                 try{
                     if (!checkNotNull()) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                     nhankhau.setHoTen(jtfhoten.getText().trim());
                     nhankhau.setNgaySinh(new java.sql.Date(jdcngaysinh.getDate().getTime()));
                     nhankhau.setMaHoKhau(Integer.parseInt(jtfmahokhau.getText()));
                     nhankhau.setCMND(jtfcmnd.getText());
                     nhankhau.setSDT(jtfsdt.getText());
                     nhankhau.setTinhTrang((String) jtftinhtrang.getSelectedItem());                    
                         int lastId= nhankhauservice.createOrUpdate(nhankhau);
                         if (lastId !=0){
                             nhankhau.setMaNhanKhau(lastId);
                             jtfmanhankhau.setText(""+ nhankhau.getMaNhanKhau());
                            jlbMsg.setText("Cập nhật thành công!");
                            } 
                    } 
//                    try (Connection cons = connect_to_db.getConnection()){
//                        String sql1 = "UPDATE hokhau SET sothanhvien = sothanhvien + 1 WHERE mahokhau = ?";
//                        try (PreparedStatement ps1 = cons.prepareStatement(sql1)) {
//                        ps1.setInt(1, nhankhau.getMaHoKhau());
//                        ps1.executeUpdate();
//                   }catch (SQLException ex) {
//                    }
//                           
//                 }
//                 catch (SQLException ex) {
//                    Logger.getLogger(ThemNhanKhauController.class.getName()).log(Level.SEVERE, null, ex);
//                }
             }catch (NumberFormatException ex) {
                    jlbMsg.setText(ex.toString());
                }
             }
             @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bntSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bntSubmit.setBackground(new Color(100, 221, 23));
            }
         });
    }
    private boolean checkNotNull() {
            return jtfhoten.getText() != null && !jtfhoten.getText().equalsIgnoreCase("");
    }
}
