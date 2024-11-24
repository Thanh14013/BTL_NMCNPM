package service;

import java.util.ArrayList;
import java.util.List;

import model.TaiKhoanModel;

public class TaiKhoanService {
	
	private List<TaiKhoanModel> taiKhoanList = new ArrayList<>();
	
	public TaiKhoanService() {}
	
	public boolean add(TaiKhoanModel model) {
		return taiKhoanList.add(model);
	}
	
	public boolean del(int maTaiKhoan) {
		return taiKhoanList.removeIf(taiKhoan -> taiKhoan.getMaTaiKhoan() == maTaiKhoan);
	}
	
	public boolean update(String username, String password, String hoten, String email, int maTaiKhoan) {
		for (TaiKhoanModel taiKhoan : taiKhoanList) {
			if (taiKhoan.getMaTaiKhoan() == maTaiKhoan) {
				taiKhoan.setPassword(password);
				taiKhoan.setHoten(hoten);
				taiKhoan.setEmail(email);
				taiKhoan.setUsername(username);
				return true;
			}
		}
		return false;
	}
}
