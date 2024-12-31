package scr.utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import scr.model.LichSu;


public class LichSuTable {
    public DefaultTableModel setTableLichSu(List<LichSu> listItem, String[] listColumn){
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
        LichSu ls= null;
        for (int i=0;i <num;i++){
            ls= listItem.get(i);
            obj = new Object[columns];
            obj[0] = ls.getMahokhau();
            obj[1] = ls.getTennguoidong();
            obj[2] = ls.getNgaydong();
            obj[3] = ls.getSotien();
            dtm.addRow(obj);
        }
        return dtm;
    }
}

