package model;

public class NhanKhauModel {
	private String hoTen;
	private int tuoi;
	private int maNhanKhau;
	private int cmnd;
	private int sdt;
	private int maHoKhau;
	
	public NhanKhauModel() {}
	
	public NhanKhauModel(String hoTen, int tuoi, int maNhanKhau, int cmnd, int sdt, int maHoKhau) {
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.maNhanKhau = maNhanKhau;
		this.cmnd = cmnd;
		this.sdt = sdt;
		this.maHoKhau = maHoKhau;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public int getTuoi() {
		return tuoi;
	}
	
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	
	public int getMaNhanKhau() {
		return maNhanKhau;
	}
	
	public void setMaNhanKhau(int maNhanKhau) {
		this.maNhanKhau = maNhanKhau;
	}
	
	public int getCmnd() {
		return cmnd;
	}
	
	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}
	
	public int getSdt() {
		return sdt;
	}
	
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	
	public int getMaHoKhau() {
		return maHoKhau;
	}
	
	public void setMaHoKhau(int maHoKhau) {
		this.maHoKhau = maHoKhau;
	}
	
	
}
