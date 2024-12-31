
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
import scr.model.ThongKe;
import scr.service.ThongKeService;
import scr.service.ThongKeserviceimpk;
import scr.utility.ThongKeTable;
import scr.view.BangThongKeJFrame;
import scr.view.LichSuFrame;
import scr.view.ThongKeJFrame;


public class ThongKeController {
    public JPanel jpnView;
    private JButton btnok;
    private JButton btnls;
    private JTextField jtfSearch;
    private JTextField jtfSearch2;
    private ThongKeTable thongketable = null;
    
    private final String[] Columns = {"Mã Hộ Khẩu", "Tên Chủ Hộ", "Tổng Số Tiền", "Còn Lại","Từ Ngày","Đến Ngày","Tình Trạng"};
    private ThongKeService thongkeservice= null;
    
    private TableRowSorter<TableModel> rowSorter = null;

    public ThongKeController(JPanel jpnView, JButton btnok, JTextField jtfSearch, JTextField jtfSearch2,JButton btnls ) {
        
        this.jpnView = jpnView;
        this.btnok = btnok;
        this.jtfSearch = jtfSearch;
        this.jtfSearch2 = jtfSearch2;
        this.btnls = btnls;
        
        this.thongkeservice = new ThongKeserviceimpk();
        this.thongketable = new ThongKeTable();
    }
    
     public void SetDataToTable(){
        List<ThongKe> listItem= thongkeservice.getList();
        DefaultTableModel model = thongketable.setTableThongKe(listItem, Columns);
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
                int x = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
                Double z = Double.valueOf(model.getValueAt(selectedRowIndex, 3).toString());
                ThongKeJFrame frame = new ThongKeJFrame(x,z);
                frame.setTitle("Thông tin");
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (NumberFormatException ex) {
            } catch (SQLException ex) {
                Logger.getLogger(ThongKeController.class.getName()).log(Level.SEVERE, null, ex);
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
         btnok.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                int mahokhau = Integer.parseInt(jtfSearch2.getText());
                BangThongKeJFrame frame = new BangThongKeJFrame(mahokhau);
                frame.setTitle("Thông tin");
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
         btnls.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                LichSuFrame frame = new LichSuFrame();
                frame.setTitle("Lịch Sử Giao Dịch");
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
