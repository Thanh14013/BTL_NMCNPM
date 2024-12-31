
package scr.service;

import java.util.List;
import scr.dao.LichSuDao;
import scr.dao.LichSuDaoimpl;
import scr.model.LichSu;


public class LichSuServiceimpl implements LichSuService {

    private LichSuDao lsdao= null;
    
    public LichSuServiceimpl(){
        this.lsdao = new LichSuDaoimpl();
    }
    @Override
    public List<LichSu> getList() {
        return lsdao.getListLichSu();
    }
    
}
