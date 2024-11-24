package model;

public class KhoanPhiModel {
	private int maKhoanPhi;
	private String tenKhoanPhi;
	private int soTien;
	private String loaiKhoanPhi;
	
	public KhoanPhiModel() {}
	
	public KhoanPhiModel(int maKhoanPhi, String tenKhoanPhi, int soTien, String loaiKhoanPhi) {
		this.maKhoanPhi = maKhoanPhi;
		this.tenKhoanPhi = tenKhoanPhi;
		this.soTien = soTien;
		this.loaiKhoanPhi = loaiKhoanPhi;
	}
	
	public int getMaKhoanPhi() {
		return maKhoanPhi;
	}
	
	public void setMaKhoanPhi(int maKhoanPhi) {
		this.maKhoanPhi = maKhoanPhi;
	}
	
	public String getTenKhoanPhi() {
		return tenKhoanPhi;
	}
	
	public void setTenKhoanPhi(String tenKhoanPhi) {
		this.tenKhoanPhi = tenKhoanPhi;
	}
	
	public int getSoTien() {
		return soTien;
	}
	
	public void setSoTien(int soTien) {
		this.soTien = soTien;
	}
	
	public String getLoaiKhoanPhi() {
		return loaiKhoanPhi;
	}
	
	public void setLoaiKhoanPhi(String loaiKhoanPhi) {
		this.loaiKhoanPhi = loaiKhoanPhi;
	}
	
	
}
