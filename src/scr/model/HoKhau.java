package scr.model;

public class HoKhau {
    private int MaHoKhau;
    private int SoThanhVien;
    private String DiaChi;
    private int MaChuHo;
    private String TenChuHo;
    private double DienTich;
    private int sltot;
    private int slxemay;

    public int getSlot() {
        return sltot;
    }

    public void setSlot(int sltot) {
        this.sltot = sltot;
    }

    public int getSlxemay() {
        return slxemay;
    }

    public void setSlxemay(int slxemay) {
        this.slxemay = slxemay;
    }
    
    public int getMaHoKhau() {
        return MaHoKhau;
    }
    public void setMaHoKhau(int MaHoKhau) {
        this.MaHoKhau = MaHoKhau;
    }
    public int getSoThanhVien() {
        return SoThanhVien;
    }
    public void setSoThanhVien(int SoThanhVien) {
        this.SoThanhVien = SoThanhVien;
    }
    public String getDiaChi() {
        return DiaChi;
    }
    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    public int getMaChuHo() {
        return MaChuHo;
    }
    public void setMaChuHo(int MaChuHo) {
        this.MaChuHo = MaChuHo;
    }
    public String getTenChuHo() {
        return TenChuHo;
    }
    public void setTenChuHo(String TenChuHo) {
        this.TenChuHo = TenChuHo;
    }
    public double getDienTich() {
        return DienTich;
    }
    public void setDienTich(double DienTich) {
        this.DienTich = DienTich;
    }
}
