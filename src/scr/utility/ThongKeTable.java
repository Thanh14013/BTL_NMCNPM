
package scr.utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import scr.model.ThongKe;


public class ThongKeTable {
    public DefaultTableModel setTableThongKe(List<ThongKe> listItem, String[] listColumn){
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        ThongKe tk= null;
        for (int i=0;i <num;i++){
            tk= listItem.get(i);
            obj = new Object[columns];
            obj[0] = tk.getMaHoKhau();
            obj[1] = tk.getTenChuHo();
            obj[2] = tk.getTongSoTien();
            obj[3] = tk.getConLai();
            obj[4] = tk.getTungay();
            obj[5] = tk.getDenngay();
            obj[6] = tk.getTinhtrang();
            dtm.addRow(obj);
        }
        return dtm;
    }
}
