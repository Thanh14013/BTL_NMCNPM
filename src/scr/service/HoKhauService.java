
package scr.service;

import java.util.List;
import scr.model.HoKhau;


public interface HoKhauService {
    public List<HoKhau> getList();
    public int createOrUpdate(HoKhau hokhau);
    public void delete(HoKhau hokhau);
}
