
package scr.model;

import java.sql.Date;


public class LichSu {
    private int mahokhau;
    private Date ngaydong;
    private Double sotien;
    private String tennguoidong;

    public int getMahokhau() {
        return mahokhau;
    }

    public void setMahokhau(int mahokhau) {
        this.mahokhau = mahokhau;
    }
    public Date getNgaydong() {
        return ngaydong;
    }

    public void setNgaydong(Date ngaydong) {
        this.ngaydong = ngaydong;
    }

    public Double getSotien() {
        return sotien;
    }

    public void setSotien(Double sotien) {
        this.sotien = sotien;
    }

    public String getTennguoidong() {
        return tennguoidong;
    }

    public void setTennguoidong(String tennguoidong) {
        this.tennguoidong = tennguoidong;
    }
    
    
}
