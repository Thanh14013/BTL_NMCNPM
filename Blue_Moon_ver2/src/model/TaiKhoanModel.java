package model;

public class TaiKhoanModel {
	private String username;
	private String password;
	private String hoten;
	private String email;
	private int maTaiKhoan;
	public TaiKhoanModel() {}
	
	public TaiKhoanModel(String username, String password, String hoten, String email, int maTaiKhoan) {
		this.username = username;
		this.password = password;
		this.hoten = hoten;
		this.email = email;
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}
	
	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	
}
