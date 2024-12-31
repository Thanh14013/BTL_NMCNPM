
package scr.service;

import java.util.List;
import scr.model.KhoanPhi;


public interface KhoanPhiService {
    public List<KhoanPhi> getList();
    public int createOrUpdate(KhoanPhi khoanphi);
    public void delete(KhoanPhi khoanphi);
}
