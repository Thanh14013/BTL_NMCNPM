package service;

import java.util.ArrayList;
import java.util.List;

import model.HoKhauModel;

public class HoKhauService {
	private List<HoKhauModel> hoKhauList = new ArrayList<>();
	
	public HoKhauService() {}
	
	public boolean add(HoKhauModel model) {
		return hoKhauList.add(model);
	}
	
	public boolean del(int maHo) {
		return hoKhauList.removeIf(hoKhau -> hoKhau.getMaHoKhau() == maHo);
	}
	
	public boolean update(int maHo, int soThanhVien, String diaChi, String tenChuHo) {
		for (HoKhauModel hoKhau : hoKhauList) {
			if (hoKhau.getMaHoKhau() == maHo) {
				hoKhau.setSoThanhVien(soThanhVien);
				hoKhau.setDiaChi(diaChi);
				return true;
			}
		}
		return false;
	}
	
	public List<HoKhauModel> getListHoKhau() {
		return hoKhauList;
	}
	
	public HoKhauModel getHoKhau(int maHo) {
		for (HoKhauModel hoKhau : hoKhauList) {
			if (hoKhau.getMaHoKhau() == maHo) {
				return hoKhau;
			}
		}
		return null;
	}
	
	public int getMaHoKhau() {
		int max = 0;
		for (HoKhauModel hoKhau : hoKhauList) {
			if (hoKhau.getMaHoKhau() > max) {
				max = hoKhau.getMaHoKhau();
			}
		}
		return max + 1;
	}
	
	public List<HoKhauModel> search(String search) {
		List<HoKhauModel> result = new ArrayList<>();
		for (HoKhauModel hoKhau : hoKhauList) {
			if (hoKhau.getTenChuHo().toLowerCase().contains(search.toLowerCase())) {
				result.add(hoKhau);
			}
		}
		return result;
	}
	
	public List<HoKhauModel> search(int maHo) {
		List<HoKhauModel> result = new ArrayList<>();
		for (HoKhauModel hoKhau : hoKhauList) {
			if (hoKhau.getMaHoKhau() == maHo) {
				result.add(hoKhau);
			}
		}
		return result;
	}
	
	public List<HoKhauModel> searchBySoThanhVien(int soThanhVien) {
		List<HoKhauModel> result = new ArrayList<>();
		for (HoKhauModel hoKhau : hoKhauList) {
			if (hoKhau.getSoThanhVien() == soThanhVien) {
				result.add(hoKhau);
			}
		}
		return result;
	}
	
	public List<HoKhauModel> searchByDiaChi(String diaChi) {
		List<HoKhauModel> result = new ArrayList<>();
		for (HoKhauModel hoKhau : hoKhauList) {
			if (hoKhau.getDiaChi().toLowerCase().contains(diaChi.toLowerCase())) {
				result.add(hoKhau);
			}
		}
		return result;
	}
	
	
}
