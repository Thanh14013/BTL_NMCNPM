
package scr.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import scr.model.NhanKhau;
import scr.service.NhanKhauService;
import scr.service.NhanKhauserviceimpl;


public class XoaNhanKhauController {
    private JButton btnok;
    private JLabel jtfMsg;
    private JTextField jtfmanhankhau;
    private NhanKhau nhankhau;
    private NhanKhauService nhankhauservice;

    public XoaNhanKhauController(JButton btnok, JLabel jtfMsg, JTextField jtfmanhankhau) {
        this.btnok = btnok;
        this.jtfMsg = jtfMsg;
        this.jtfmanhankhau = jtfmanhankhau;
        
        this.nhankhauservice = new NhanKhauserviceimpl();
        nhankhau = new NhanKhau();
    }
    
    public void setEvent(){
        btnok.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try{
                    jtfMsg.setText("Xóa thành công!!");
                    nhankhau.setMaNhanKhau(Integer.parseInt(jtfmanhankhau.getText()));
                    nhankhauservice.delete(nhankhau);
                }catch (NumberFormatException ex) {
                    jtfMsg.setText(ex.toString());
                }
            }
            
        });
    }    
}
