
package scr.service;

import java.util.List;
import scr.dao.ThongKeDao;
import scr.dao.ThongKeDaoimpl;
import scr.model.ThongKe;


public class ThongKeserviceimpk  implements ThongKeService {

    private ThongKeDao thongkedao = null;
    
    public ThongKeserviceimpk(){
        this.thongkedao = new ThongKeDaoimpl();
    }
    
    @Override
    public List<ThongKe> getList() {
        return thongkedao.getListThongKe();
    }
    
}
