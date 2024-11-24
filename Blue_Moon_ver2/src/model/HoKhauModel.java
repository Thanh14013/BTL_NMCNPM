package model;

public class HoKhauModel {
	private int maHoKhau;
	private int soThanhVien;
	private String diaChi;
	private String tenChuHo;
	private int maChuHo;
	
	public HoKhauModel() {}
	
	public HoKhauModel(int maHoKhau, int soThanhVien, String diaChi, String tenChuHo, int maChuHo) {
		this.maHoKhau = maHoKhau;
		this.soThanhVien = soThanhVien;
		this.diaChi = diaChi;
		this.tenChuHo = tenChuHo;
		this.maChuHo = maChuHo;
	}
	
	public int getMaHoKhau() {
		return maHoKhau;
	}
	
	public void setMaHoKhau(int maHoKhau) {
		this.maHoKhau = maHoKhau;
	}
	
	public int getSoThanhVien() {
		return soThanhVien;
	}
	
	public void setSoThanhVien(int soThanhVien) {
		this.soThanhVien = soThanhVien;
	}
	
	public String getDiaChi() {
		return diaChi;
	}
	
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public String getTenChuHo() {
		return tenChuHo;
	}
	
	public void setTenChuHo(String tenChuHo) {
		this.tenChuHo = tenChuHo;
	}
	
	public int getMaChuHo() {
		return maChuHo;
	}
	
	public void setMaChuHo(int maChuHo) {
		this.maChuHo = maChuHo;
	}
	
	
	
}
