
package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import scr.model.HoKhau;



public class HoKhauDaoimpl implements HoKhauDao {

    @Override
    public List<HoKhau> getListHoKhau() {
        Connection cons = connect_to_db.getConnection();
        String sql= "SELECT * FROM hokhau";
        List<HoKhau> list= new ArrayList<>();
        try{
            ResultSet rs;
            try (PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                rs = ps.executeQuery();
                while (rs.next()){
                    HoKhau hk = new HoKhau();
                    hk.setMaHoKhau(rs.getInt("mahokhau"));
                    hk.setSoThanhVien(rs.getInt("sothanhvien"));
                    hk.setDiaChi(rs.getString("diachi"));
                    hk.setMaChuHo(rs.getInt("machuho"));
                    hk.setTenChuHo(rs.getString("tenchuho"));
                    hk.setDienTich(rs.getDouble("dientich"));
                    hk.setSlot(rs.getInt("sloto"));
                    hk.setSlxemay(rs.getInt("slxemay"));
                    list.add(hk);
                }
            }
            cons.close();
            rs.close();
        } catch (SQLException e){
        }
        return list;
        
    }
    @Override
public int createOrUpdate(HoKhau hokhau) {
    int generatedKey = 0;
    try (Connection cons = connect_to_db.getConnection()) {
        String checkSql = "SELECT COUNT(*) FROM hokhau WHERE mahokhau = ?";
        try (PreparedStatement checkStmt = cons.prepareStatement(checkSql)) {
            checkStmt.setInt(1, hokhau.getMaHoKhau());
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) == 0) {
                    String maxSql = "SELECT MAX(mahokhau) FROM hokhau";
                    try (PreparedStatement maxStmt = cons.prepareStatement(maxSql);
                         ResultSet maxRs = maxStmt.executeQuery()) {
                        if (maxRs.next()) {
                            hokhau.setMaHoKhau(maxRs.getInt(1) + 1);
                        } else {
                            hokhau.setMaHoKhau(1); 
                        }
                        maxStmt.close();
                        maxRs.close();
                    }
                }
                rs.close();
            }
            checkStmt.close();
        }
        String sql = "INSERT INTO hokhau(mahokhau, sothanhvien, diachi, machuho, tenchuho, dientich, sloto, slxemay) " +
                     "VALUES(?, ?, ?, ?, ?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE " +
                     "sothanhvien = VALUES(sothanhvien), diachi = VALUES(diachi), machuho = VALUES(machuho), " +
                     "tenchuho = VALUES(tenchuho), dientich = VALUES(dientich), sloto = VALUES(sloto), slxemay = VALUES(slxemay)";
        String sql2 ="UPDATE hokhau_khoanphi SET sotien = ? WHERE mahokhau=? AND makhoanphi = ?";
        try (PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, hokhau.getMaHoKhau());
            ps.setInt(2, hokhau.getSoThanhVien());
            ps.setString(3, hokhau.getDiaChi());
            ps.setInt(4, hokhau.getMaChuHo());
            ps.setString(5, hokhau.getTenChuHo());
            ps.setDouble(6, hokhau.getDienTich());
            ps.setInt(7, hokhau.getSlot());
            ps.setInt(8, hokhau.getSlxemay());
            
            ps.execute();

            generatedKey = hokhau.getMaHoKhau(); 
            
            ps.close();
        }
        
        try (PreparedStatement ps2 = cons.prepareStatement(sql2)){
            
            ps2.setDouble(1, 70000*hokhau.getSlxemay());
            ps2.setInt(2, hokhau.getMaHoKhau());
            ps2.setInt(3, 4);
            ps2.executeUpdate();
            
            ps2.setDouble(1, 1200000*hokhau.getSlot());
            ps2.setInt(2, hokhau.getMaHoKhau());
            ps2.setInt(3, 5);
            ps2.executeUpdate();
           
            ps2.close();
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error updating HoKhau data", e);
    }

    return generatedKey;
}
   @Override

    public void delete(HoKhau hokhau) {
    try (Connection cons = connect_to_db.getConnection()) {
        cons.setAutoCommit(false); // Bắt đầu giao dịch

        // Câu lệnh SQL để xóa dữ liệu
        String sql = "DELETE FROM hokhau WHERE mahokhau = ?";
        String sql2 = "DELETE FROM thongke WHERE mahokhau = ?";
        String sql3 = "DELETE FROM hokhau_khoanphi WHERE mahokhau = ?";
        String sql4 = "DELETE FROM nhankhau WHERE mahokhau = ?";
        // Xóa từ bảng hokhau
        try (PreparedStatement ps = cons.prepareStatement(sql)) {
            ps.setInt(1, hokhau.getMaHoKhau());
            int rowsDeleted = ps.executeUpdate(); // Kiểm tra số hàng bị xóa
            if (rowsDeleted == 0) {
                throw new SQLException("Không tìm thấy hồ sơ để xóa trong bảng hokhau.");
            }
        }

        // Xóa từ bảng thongke
        try (PreparedStatement ps1 = cons.prepareStatement(sql2)) {
            ps1.setInt(1, hokhau.getMaHoKhau());
            ps1.executeUpdate();
        }
        try (PreparedStatement ps2 = cons.prepareStatement(sql3)) {
            ps2.setInt(1, hokhau.getMaHoKhau());
            ps2.executeUpdate();
        }
        try (PreparedStatement ps3 = cons.prepareStatement(sql4)) {
            ps3.setInt(1, hokhau.getMaHoKhau());
            ps3.executeUpdate();
        }

        cons.commit();
    } catch (SQLException ex) {
        Logger.getLogger(HoKhauDaoimpl.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
