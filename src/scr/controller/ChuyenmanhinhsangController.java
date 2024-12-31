package scr.controller;

import scr.view.NhanKhauJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import scr.bean.Danhmucbean;
import scr.view.HoKhauJPanel;
import scr.view.TaiKhoanJPanel;
import scr.view.ThongKeJPanel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import scr.view.KhoanPhiJPanel;
import scr.view.MainJPanel;

public class ChuyenmanhinhsangController {
    private JPanel root;
    private String kindSelected="";
    private List<Danhmucbean> listItem;
    public ChuyenmanhinhsangController(JPanel Jpnroot) {
        this.root = Jpnroot;
    }
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "Trang Chủ";
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new MainJPanel());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<Danhmucbean> listItem){
        this.listItem= listItem;
        for (Danhmucbean it: listItem){
            it.getJpn().addMouseListener(new LabelEvent(it.getKind(),it.getJpn(), it.getJlb()));
        }
    }
class LabelEvent implements MouseListener{
    private JPanel node;
    private String kind;
    private JPanel jpnItem;
    private JLabel jlbItem;

    public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
        this.kind = kind;
        this.jpnItem = jpnItem;
        this.jlbItem = jlbItem;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
         switch (kind){
            case "Hộ Khẩu" -> node = new HoKhauJPanel();
            case "Nhân Khẩu" -> node = new NhanKhauJPanel();
            case "Tài Khoản" -> node = new TaiKhoanJPanel();
            case "Thống Kê" -> {
                 try {
                     node = new ThongKeJPanel();
                 } catch (SQLException ex) {
                     Logger.getLogger(ChuyenmanhinhsangController.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
            case "Trang Chủ" -> node = new MainJPanel();
            case "Khoản Phí" -> node = new KhoanPhiJPanel();
            default -> node= new MainJPanel();
         }
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(node);
        root.validate();
        root.repaint();
        setChangeBackground(kind);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        kindSelected= kind;
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        jpnItem.setBackground(new Color(96,100,191));
        jlbItem.setBackground(new Color(96,100,191));   
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if (!kindSelected.equalsIgnoreCase(kind)){
            jpnItem.setBackground(Color.white);
            jlbItem.setBackground(Color.white);
        }
    }
    }
    private void setChangeBackground(String kind){
        for (Danhmucbean it: listItem){
            if (it.getKind().equalsIgnoreCase(kind)){
                it.getJpn().setBackground(new Color(96,100,191));
                it.getJlb().setBackground(new Color(96,100,191));
            }
            else{
                it.getJpn().setBackground(Color.white);
                it.getJlb().setBackground(Color.white);                
            }
        }
    }


}