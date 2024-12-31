
package scr.utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import scr.model.KhoanPhi;


public class KhoanPhiTable {
    public DefaultTableModel setTableKhoanPhi(List<KhoanPhi> listItem, String[] listColumn){
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
        KhoanPhi kp= null;
        for (int i=0;i <num;i++){
            kp= listItem.get(i);
            obj = new Object[columns];
            obj[0] = kp.getMaKhoanPhi();
            obj[1] = kp.getTenKhoanPhi();
            obj[2] = kp.getSoTien();
            obj[3] = kp.getLoaiKhoanPhi();

            dtm.addRow(obj);
        }
        return dtm;
    }
    
}
