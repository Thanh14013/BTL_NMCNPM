package service;

import java.util.ArrayList;
import java.util.List;

import model.KhoanPhiModel;

public class KhoanPhiService {
	
	private List<KhoanPhiModel> khoanPhiList = new ArrayList<>();
	
	public KhoanPhiService() {}
	
	public boolean add(KhoanPhiModel model) {
		return khoanPhiList.add(model);
	}
	
	public boolean del(int maKhoanPhi) {
		return khoanPhiList.removeIf(khoanPhi -> khoanPhi.getMaKhoanPhi() == maKhoanPhi);
	}
	
	public boolean update(int maKhoanPhi, String tenKhoanPhi, int soTien) {
		for (KhoanPhiModel khoanPhi : khoanPhiList) {
			if (khoanPhi.getMaKhoanPhi() == maKhoanPhi) {
				khoanPhi.setTenKhoanPhi(tenKhoanPhi);
				khoanPhi.setSoTien(soTien);
				return true;
			}
		}
		return false;
	}
	
	public List<KhoanPhiModel> getListKhoanPhi() {
		return khoanPhiList;
	}
	
	
}
