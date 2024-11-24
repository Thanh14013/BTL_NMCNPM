package service;

import java.util.ArrayList;
import java.util.List;

import model.NopTienModel;

public class NopTienService {
	
	private List<NopTienModel> nopTienList = new ArrayList<>();
	
	public NopTienService() {}
	
	public boolean add(NopTienModel model) {
		return nopTienList.add(model);
	}
	
	public boolean del(int maNopTien) {
		return nopTienList.removeIf(nopTien -> nopTien.getMaNopTien() == maNopTien);
	}
	
	public boolean update(int maNopTien, int maNguoiNop, int ngayNop, String tenKhoanPhi) {
		for (NopTienModel nopTien : nopTienList) {
            if (nopTien.getMaNopTien() == maNopTien) {
                nopTien.setMaNguoiNop(maNguoiNop);
                nopTien.setNgayNop(ngayNop);
                nopTien.setTenKhoanPhi(tenKhoanPhi);
                return true;
            }
        }
        return false;
	}
	
	public List<NopTienModel> getListNopTien() {
		return nopTienList;
	}
}
