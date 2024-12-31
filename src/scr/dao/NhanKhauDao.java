
package scr.dao;

import java.util.List;
import scr.model.NhanKhau;

public interface NhanKhauDao {
    public List<NhanKhau> getListNhanKhau();
    public int createOrUpdate(NhanKhau nhankhau);
    public void delete(NhanKhau nhankhau);
}
