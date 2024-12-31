
package scr.model;

import java.sql.Date;


public class ThongKe {
    private int MaHoKhau;
    private String TenChuHo;
    private double TongSoTien;
    private double ConLai;
    private Date tungay;
    private Date denngay;
    private String tinhtrang;

    public int getMaHoKhau() {
        return MaHoKhau;
    }

    public void setMaHoKhau(int MaHoKhau) {
        this.MaHoKhau = MaHoKhau;
    }

    public String getTenChuHo() {
        return TenChuHo;
    }

    public void setTenChuHo(String TenChuHo) {
        this.TenChuHo = TenChuHo;
    }

    public double getTongSoTien() {
        return TongSoTien;
    }

    public void setTongSoTien(double TongSoTien) {
        this.TongSoTien = TongSoTien;
    }

    public double getConLai() {
        return ConLai;
    }

    public void setConLai(double ConLai) {
        this.ConLai = ConLai;
    }

    public Date getTungay() {
        return tungay;
    }

    public void setTungay(Date tungay) {
        this.tungay = tungay;
    }

    public Date getDenngay() {
        return denngay;
    }

    public void setDenngay(Date denngay) {
        this.denngay = denngay;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
    
    
}
