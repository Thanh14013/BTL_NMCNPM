
package scr.service;

import java.util.List;
import scr.dao.HoKhauDao;
import scr.dao.HoKhauDaoimpl;
import scr.model.HoKhau;


public class HoKhauserviceimpl implements HoKhauService {
    
    private HoKhauDao hkdao= null;
    
    public HoKhauserviceimpl(){
        this.hkdao = new HoKhauDaoimpl();
    }

    @Override
    public List<HoKhau> getList() {
        return hkdao.getListHoKhau();
    }

    @Override
    public int createOrUpdate(HoKhau hokhau) {
        return hkdao.createOrUpdate(hokhau);
    }

    @Override
    public void delete(HoKhau hokhau) {
        hkdao.delete(hokhau);
    }

    
}
