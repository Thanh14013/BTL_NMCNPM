
package scr.service;

import java.util.List;
import scr.dao.NhanKhauDao;
import scr.dao.NhanKhauDaoimpl;
import scr.model.NhanKhau;

public class NhanKhauserviceimpl implements NhanKhauService {
    private NhanKhauDao nkdao= null;

    public NhanKhauserviceimpl() {
        this.nkdao= new NhanKhauDaoimpl();
    }

    @Override
    public List<NhanKhau> getList() {
        return nkdao.getListNhanKhau();
    }

    @Override
    public int createOrUpdate(NhanKhau nhankhau) {
        return nkdao.createOrUpdate(nhankhau);
    }

    @Override
    public void delete(NhanKhau nhankhau) {
        nkdao.delete(nhankhau);
    }

}
