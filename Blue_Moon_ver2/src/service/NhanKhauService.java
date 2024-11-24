package service;

import java.util.ArrayList;
import java.util.List;

import model.NhanKhauModel;

public class NhanKhauService {
	
	private List<NhanKhauModel> nhanKhauList = new ArrayList<>();
	
	public NhanKhauService() {}
	
	public boolean add(NhanKhauModel model) {
		return nhanKhauList.add(model);
	}
	
	public boolean del(int maNhanKhau) {
		return nhanKhauList.removeIf(nhanKhau -> nhanKhau.getMaNhanKhau() == maNhanKhau);
	}
	
	public boolean update(String hoTen, int tuoi, int maNhanKhau, int cmnd, int sdt, int maHoKhau) {
		for (NhanKhauModel nhanKhau : nhanKhauList) {
			if (nhanKhau.getMaNhanKhau() == maNhanKhau) {
				nhanKhau.setHoTen(hoTen);
				nhanKhau.setTuoi(tuoi);
				nhanKhau.setCmnd(cmnd);
				nhanKhau.setSdt(sdt);
				nhanKhau.setMaHoKhau(maHoKhau);
				return true;
			}
		}
		return false;
	}
	
	public List<NhanKhauModel> getListNhanKhau() {
		return nhanKhauList;
	}
}
