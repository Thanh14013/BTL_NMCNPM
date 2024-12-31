package scr.model;
import java.sql.Date;

public class NhanKhau {
    private int MaNhanKhau;
    private String HoTen;
    private Date NgaySinh;
    private String CMND;
    private String SDT;
    private int MaHoKhau;
    private String TinhTrang;

    
    public String getTinhTrang() {
        return TinhTrang;
    }
    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    public int getMaNhanKhau() {
        return MaNhanKhau;
    }
    public void setMaNhanKhau(int MaNhanKhau) {
        this.MaNhanKhau = MaNhanKhau;
    }
    public String getHoTen() {
        return HoTen;
    }
    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }
    public Date getNgaySinh() {
        return NgaySinh;
    }
    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    public String getCMND() {
        return CMND;
    }
    public void setCMND(String CMND) {
        this.CMND = CMND;
    }
    public String getSDT() {
        return SDT;
    }
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    public int getMaHoKhau() {
        return MaHoKhau;
    }
    public void setMaHoKhau(int MaHoKhau) {
        this.MaHoKhau = MaHoKhau;
    }
}
