package scr.service;

import scr.model.NhanKhau;
import java.util.List;

public interface  NhanKhauService {
    public List<NhanKhau> getList();
    public int createOrUpdate(NhanKhau nhankhau);
    public void delete(NhanKhau nhankhau);

}