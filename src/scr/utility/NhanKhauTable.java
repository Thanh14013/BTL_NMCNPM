
package scr.utility;

import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import scr.model.NhanKhau;

public class NhanKhauTable {
    
    public DefaultTableModel setTableNhanKhau(List<NhanKhau> listItem, String[] listColumn){
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 2 ? Date.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int num = listItem.size();
        NhanKhau nk= null;
        for (int i=0;i <num;i++){
            nk= listItem.get(i);
            obj = new Object[columns];
            obj[0] = nk.getMaNhanKhau();
            obj[1] = nk.getHoTen();
            obj[3] = nk.getCMND();
            obj[2] = nk.getNgaySinh();
            obj[4] = nk.getSDT();
            obj[5] = nk.getMaHoKhau();
            obj[6] = nk.getTinhTrang();
            dtm.addRow(obj);
        }
        return dtm;
    }
}
