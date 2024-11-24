package model;

public class NopTienModel {
	private int maNopTien;
	private int maNguoiNop;
	private int ngayNop;
	private String tenKhoanPhi;
	
	public NopTienModel() {}
	
	public NopTienModel(int maNopTien, int maNguoiNop, int ngayNop, String tenKhoanPhi) {
		this.maNopTien = maNopTien;
		this.maNguoiNop = maNguoiNop;
		this.ngayNop = ngayNop;
		this.tenKhoanPhi = tenKhoanPhi;
	}
	
	public int getMaNopTien() {
		return maNopTien;
	}
	
	public void setMaNopTien(int maNopTien) {
		this.maNopTien = maNopTien;
	}
	
	public int getMaNguoiNop() {
		return maNguoiNop;
	}
	
	public void setMaNguoiNop(int maNguoiNop) {
		this.maNguoiNop = maNguoiNop;
	}
	
	public int getNgayNop() {
		return ngayNop;
	}
	
	public void setNgayNop(int ngayNop) {
		this.ngayNop = ngayNop;
	}
	
	public String getTenKhoanPhi() {
		return tenKhoanPhi;
	}
	
	public void setTenKhoanPhi(String tenKhoanPhi) {
		this.tenKhoanPhi = tenKhoanPhi;
	}
	
}
