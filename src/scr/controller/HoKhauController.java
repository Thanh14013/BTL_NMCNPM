package scr.controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import scr.model.HoKhau;
import scr.service.HoKhauService;
import scr.service.HoKhauserviceimpl;
import scr.utility.HoKhauTable;
import scr.view.HoKhauJFrame;
import scr.view.XoaHoKhauJFram;



public class HoKhauController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    private JButton btnDel;
    private JPanel HoKhauJpanel;
    
    private HoKhauTable hokhautable = null;
    private final String[] Columns = {"Mã Hộ Khẩu", "Số Thành Viên", "Mã Chủ Hộ", "Số Phòng", "Tên Chủ Hộ","Diện Tích", "Số Lượng Ô Tô", "Số Lượng Xe Máy"};
    
    private HoKhauService hokhauservice = null; 
    private TableRowSorter<TableModel> rowSorter = null;

        public HoKhauController(JPanel HoKhauJpanel, JPanel jpnView, JButton btnAdd, JTextField jtfSearch, JButton btnDel) {
            this.jpnView = jpnView;
            this.btnAdd = btnAdd;
            this.jtfSearch = jtfSearch;
            this.btnDel = btnDel;
            this.HoKhauJpanel = HoKhauJpanel;
            hokhauservice = new HoKhauserviceimpl();
            hokhautable = new HoKhauTable();
        }

 public void SetDataToTable(){
        List<HoKhau> listItem= hokhauservice.getList();
        DefaultTableModel model = hokhautable.setTableHoKhau(listItem, Columns);
        JTable table = new JTable(model);

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
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int selectedRowIndex = table.getSelectedRow();
            selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

            HoKhau hokhau = new HoKhau();
            hokhau.setMaHoKhau((int) model.getValueAt(selectedRowIndex, 0));
            hokhau.setSoThanhVien((int) model.getValueAt(selectedRowIndex, 1));
            hokhau.setDiaChi(model.getValueAt(selectedRowIndex, 3).toString());
            hokhau.setMaChuHo((int) model.getValueAt(selectedRowIndex, 2));
            hokhau.setTenChuHo(model.getValueAt(selectedRowIndex, 4).toString());
            hokhau.setDienTich((Double) model.getValueAt(selectedRowIndex, 5));
            hokhau.setSlot((int) model.getValueAt(selectedRowIndex, 6));
            hokhau.setSlxemay((int) model.getValueAt(selectedRowIndex, 7));

            HoKhauJFrame frame = new HoKhauJFrame(HoKhauJpanel,hokhau);
            frame.setTitle("Thông tin hộ khẩu");
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
                HoKhauJFrame frame = new HoKhauJFrame(HoKhauJpanel, new HoKhau());
                frame.setTitle("Thông tin hộ khẩu");
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
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
                XoaHoKhauJFram frame = new XoaHoKhauJFram();
                frame.setTitle("Xóa nhân khẩu");
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
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