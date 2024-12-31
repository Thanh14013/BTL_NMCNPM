
package scr.controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import scr.model.NhanKhau;
import scr.service.NhanKhauService;
import scr.service.NhanKhauserviceimpl;
import scr.utility.NhanKhauTable;
import scr.view.NhanKhauJFram;
import scr.view.XoaNhanKhauJFram;



public class NhanKhauController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private JButton btnDel;
    
    private NhanKhauTable nhankhautable=null;
    private List<NhanKhau> listItem;
    private DefaultTableModel model;
    private JTable table;
    private final String[] Columns = {"Mã Nhân Khẩu", "Họ Tên","Ngày Sinh" ,"CMND" , "SĐT","Mã Hộ Khẩu", "Tình Trạng"};
    private NhanKhauService nhankhauservice= null;
    
    private TableRowSorter<TableModel> rowSorter = null;

    public NhanKhauController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch, JButton btnDel) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.btnDel= btnDel; 
        
        this.nhankhauservice = new NhanKhauserviceimpl();
        this.nhankhautable = new NhanKhauTable();
        
        listItem= nhankhauservice.getList();
        model = nhankhautable.setTableNhanKhau(listItem, Columns);
        table = new JTable(model);
    }
    
    public void SetDataToTable(){
        

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
            
    });
    table.getColumnModel().getColumn(0).setMaxWidth(120);
    table.getColumnModel().getColumn(0).setMinWidth(120);
    table.getColumnModel().getColumn(0).setPreferredWidth(80);
    table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (e.getClickCount() ==2 && table.getSelectedRow()!= -1){
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int selectedRowIndex = table .getSelectedRow();
                selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                
                NhanKhau nhankhau= new NhanKhau();
                nhankhau.setMaNhanKhau((int) model.getValueAt(selectedRowIndex, 0));
                nhankhau.setHoTen(model.getValueAt(selectedRowIndex, 1).toString());
                nhankhau.setCMND(model.getValueAt(selectedRowIndex, 3).toString());
                nhankhau.setSDT(model.getValueAt(selectedRowIndex, 4).toString());
                nhankhau.setMaHoKhau((int)model.getValueAt(selectedRowIndex, 5));
                nhankhau.setTinhTrang(model.getValueAt(selectedRowIndex, 6).toString());
                nhankhau.setNgaySinh((Date) model.getValueAt(selectedRowIndex, 2));
                
                NhanKhauJFram frame = new NhanKhauJFram(nhankhau);
                frame.setTitle("Thông tin nhân khẩu");
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                table.revalidate();
                table.repaint();
            }
            }
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }
    
    public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                NhanKhauJFram frame = new NhanKhauJFram(new NhanKhau());
                frame.setTitle("Thông tin nhân khẩu");
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                table.revalidate();
                table.repaint();
            };
            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        btnDel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                XoaNhanKhauJFram frame = new XoaNhanKhauJFram();
                frame.setTitle("Xóa nhân khẩu");
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                table.revalidate();
                table.repaint();
            };
            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });
        
        
        
    }
    
}
