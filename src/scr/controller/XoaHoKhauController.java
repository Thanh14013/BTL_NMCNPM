/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scr.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import scr.model.HoKhau;
import scr.service.HoKhauService;
import scr.service.HoKhauserviceimpl;

/**
 *
 * @author admin
 */
public class XoaHoKhauController {
    private JButton btnok;
    private JLabel jtfMsg;
    private JTextField jtfmahokhau;
    private HoKhau hokhau;
    private HoKhauService hokhauservice;

    public XoaHoKhauController(JButton btnok, JLabel jtfMsg, JTextField jtfmahokhau) {
        this.btnok = btnok;
        this.jtfMsg = jtfMsg;
        this.jtfmahokhau = jtfmahokhau;
        
        this.hokhauservice = new HoKhauserviceimpl();
        hokhau = new HoKhau();
    }
    public void setEvent(){
        btnok.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try{
                    jtfMsg.setText("Xóa thành công!!");
                    hokhau.setMaHoKhau(Integer.parseInt(jtfmahokhau.getText()));
                    hokhauservice.delete(hokhau);
                }catch (NumberFormatException ex) {
                    jtfMsg.setText(ex.toString());
                }
            }
            
        });
    }
}
