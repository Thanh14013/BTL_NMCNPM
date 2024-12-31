
package scr.dao;

import java.util.List;
import scr.model.HoKhau;

public interface HoKhauDao {
    public List<HoKhau> getListHoKhau();
    public int createOrUpdate(HoKhau hokhau);
    public void delete(HoKhau hokhau);
}
