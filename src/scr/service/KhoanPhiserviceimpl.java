
package scr.service;

import java.util.List;
import scr.dao.KhoanPhiDao;
import scr.dao.KhoanPhiDaoimpl;
import scr.model.KhoanPhi;

public class KhoanPhiserviceimpl implements KhoanPhiService {
    private KhoanPhiDao kpdao= null;
    
    public KhoanPhiserviceimpl(){
        this.kpdao = new KhoanPhiDaoimpl();
    }

    @Override
    public List<KhoanPhi> getList() {
        return kpdao.getListKhoanPhi();
    }

    @Override
    public int createOrUpdate(KhoanPhi hokhau) {
        return kpdao.createOrUpdate(hokhau);
    }

    @Override
    public void delete(KhoanPhi hokhau) {
        kpdao.delete(hokhau);
    }
}
