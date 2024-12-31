
package scr.controller;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
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
import scr.model.LichSu;
import scr.service.LichSuService;
import scr.service.LichSuServiceimpl;
import scr.utility.LichSuTable;


public class LichSuController {
    private JPanel jpnView;
    private JTextField jtfSearch;
    
    private LichSuTable lichsutable=null;
    private List<LichSu> listItem;
    private DefaultTableModel model;
    private JTable table;
    private final String[] Columns = {"Mã Nhân Khẩu","Tên người đóng", "Ngày Đóng" ,"Số tiền"};
    private LichSuService lichsuservice= null;
    
    private TableRowSorter<TableModel> rowSorter = null;

    public LichSuController(JPanel jpnView,JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        this.lichsuservice = new LichSuServiceimpl();
        this.lichsutable = new LichSuTable();
        
        listItem= lichsuservice.getList();
        model = lichsutable.setTableLichSu(listItem, Columns);
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
        
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
}
}
