package scr.controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import scr.model.KhoanPhi;
import scr.service.KhoanPhiserviceimpl;
import scr.service.KhoanPhiService;
import scr.utility.KhoanPhiTable;
import scr.view.KhoanPhiJFrame;
import scr.view.PhiTienIchJFrame;
import scr.view.PhiTuNguyenJFrame;
import scr.view.XoaKhoanPhiJFrame;


public class KhoanPhiController {
    private JPanel jpnView;
    private JTextField jtfSearch;
    private JButton btntienich;
    private JButton btntunguyen;
    private JButton btnAdd;
    private JButton btnDel;
    private KhoanPhiTable khoanphitable = null;
    private final String[] Columns = {"Mã Khoản Phí", "Tên Khoản Phí", "Số Tiền", "Loại Khoản Phí"};
    
    private KhoanPhiService khoanphiservice = null; 
    private TableRowSorter<TableModel> rowSorter = null;

    public KhoanPhiController(JPanel jpnView, JTextField jtfSearch,JButton btntienich, JButton btntunguyen, JButton btnAdd, JButton btnDel) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        this.btntienich = btntienich;
        this.btntunguyen = btntunguyen;
        this.btnAdd = btnAdd;
        this.btnDel = btnDel;
        this.khoanphiservice = new KhoanPhiserviceimpl();
        this.khoanphitable = new KhoanPhiTable();
    }
   
    
    public void SetDataToTable(){
        List<KhoanPhi> listItem= khoanphiservice.getList();
        DefaultTableModel model = khoanphitable.setTableKhoanPhi(listItem, Columns);
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
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
            // Kiểm tra bảng
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int selectedRowIndex = table.getSelectedRow();
            selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
            
            try {
                // Tạo đối tượng KhoanPhi từ dòng được chọn
                KhoanPhi khoanphi = new KhoanPhi();
                khoanphi.setMaKhoanPhi(Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString()));
                khoanphi.setTenKhoanPhi(model.getValueAt(selectedRowIndex, 1).toString());
                khoanphi.setSoTien(Integer.parseInt(model.getValueAt(selectedRowIndex, 2).toString()));
                khoanphi.setLoaiKhoanPhi(model.getValueAt(selectedRowIndex, 3).toString());
                
                // Mở JFrame
                KhoanPhiJFrame frame = new KhoanPhiJFrame(khoanphi);
                frame.setTitle("Thông tin Khoản Phí");
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
        btntienich.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    PhiTienIchJFrame frame = new PhiTienIchJFrame();
                    frame.setTitle("Phí tiện ích sinh hoạt hàng tháng");
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(KhoanPhiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
       });
        btntunguyen.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    PhiTuNguyenJFrame frame = new PhiTuNguyenJFrame();
                    frame.setTitle("Khoản Quyên Góp");
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(KhoanPhiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            };
            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
           
        });
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KhoanPhi khoanphi = new KhoanPhi();
                KhoanPhiJFrame frame = new KhoanPhiJFrame(khoanphi);
                frame.setTitle("Thông tin khoản phí");
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
       });
        
       btnDel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
                try {
                    XoaKhoanPhiJFrame frame = new XoaKhoanPhiJFrame();
                    frame.setTitle("Xóa khoản phí");
                    frame.setResizable(false);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(KhoanPhiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
       });
    }
}
