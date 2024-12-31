package scr.utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import scr.model.HoKhau;


public class HoKhauTable {
    public DefaultTableModel setTableHoKhau(List<HoKhau> listItem, String[] listColumn){
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
        HoKhau nk= null;
        for (int i=0;i <num;i++){
            nk= listItem.get(i);
            obj = new Object[columns];
            obj[0] = nk.getMaHoKhau();
            obj[1] = nk.getSoThanhVien();
            obj[3] = nk.getDiaChi();
            obj[2] = nk.getMaChuHo();
            obj[4] = nk.getTenChuHo();
            obj[5] = nk.getDienTich();
            obj[6] = nk.getSlot();
            obj[7] = nk.getSlxemay();
            dtm.addRow(obj);
        }
        return dtm;
    }
}
