
package scr.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import scr.model.KhoanPhi;
import scr.service.KhoanPhiService;
import scr.service.KhoanPhiserviceimpl;


public class XoaKhoanPhiController {
     private JButton btnok;
    private JLabel jtfMsg;
    private JTextField jtfmakhoanphi;
    private KhoanPhi khoanphi;
    private KhoanPhiService khoanphiservice;

    public XoaKhoanPhiController(JButton btnok, JLabel jtfMsg, JTextField jtfmakhoanphi) {
        this.btnok = btnok;
        this.jtfMsg = jtfMsg;
        this.jtfmakhoanphi = jtfmakhoanphi;
        
        this.khoanphiservice = new KhoanPhiserviceimpl();
        khoanphi = new KhoanPhi();
    }
    public void setEvent(){
        btnok.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try{
                    jtfMsg.setText("Xóa thành công!!");
                    khoanphi.setMaKhoanPhi(Integer.parseInt(jtfmakhoanphi.getText()));
                    khoanphiservice.delete(khoanphi);
                }catch (NumberFormatException ex) {
                    jtfMsg.setText(ex.toString());
                }
            }
            
        });
    }
}
