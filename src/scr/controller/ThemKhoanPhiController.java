
package scr.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import scr.model.KhoanPhi;
import scr.service.KhoanPhiService;
import scr.service.KhoanPhiserviceimpl;

public class ThemKhoanPhiController {
    private JButton bntSubmit;
    private JTextField jtfmakhoanphi;
    private JTextField jtftenkhoanphi;
    private JTextField jtfsotien;
    private JTextField jtfloaikhoanphi;
    private JLabel jlbMsg;    

    private KhoanPhi khoanphi=null;
    private KhoanPhiService khoanphiservice=null;

    public ThemKhoanPhiController(JButton bntSubmit, JTextField jtfmakhoanphi, JTextField jtftenkhoanphi, JTextField jtfsotien, JTextField jtfloaikhoanphi, JLabel jlbMsg) {
        this.bntSubmit = bntSubmit;
        this.jtfmakhoanphi = jtfmakhoanphi;
        this.jtftenkhoanphi = jtftenkhoanphi;
        this.jtfsotien = jtfsotien;
        this.jtfloaikhoanphi = jtfloaikhoanphi;
        this.jlbMsg = jlbMsg;
        
        this.khoanphiservice = new KhoanPhiserviceimpl();
    }
    
    public void setView(KhoanPhi khoanphi){
        this.khoanphi = khoanphi;
        
        jtfmakhoanphi.setText("" + khoanphi.getMaKhoanPhi());
        jtftenkhoanphi.setText(khoanphi.getTenKhoanPhi());
        jtfsotien.setText(""+ khoanphi.getSoTien());
        jtfloaikhoanphi.setText(khoanphi.getLoaiKhoanPhi());
        
        setEvent();
    }
    public void setEvent(){
         bntSubmit.addMouseListener(new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e){
                 try{
                     if (!checkNotNull()) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                     khoanphi.setTenKhoanPhi(jtftenkhoanphi.getText().trim());
                     khoanphi.setSoTien(Integer.parseInt(jtfsotien.getText()));
                     khoanphi.setLoaiKhoanPhi(jtfloaikhoanphi.getText()); 
                         int lastId= khoanphiservice.createOrUpdate(khoanphi);
                         if (lastId !=0){
                             khoanphi.setMaKhoanPhi(lastId);
                             jtfmakhoanphi.setText("#"+ khoanphi.getMaKhoanPhi());
                            jlbMsg.setText("Cập nhật thành công!");
                            }      
                    } 
                 }
                 catch (NumberFormatException ex) {
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
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
         });
    }
    private boolean checkNotNull() {
            return jtftenkhoanphi.getText() != null && !jtftenkhoanphi.getText().equalsIgnoreCase("");
    }
}
