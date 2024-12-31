package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import scr.model.NhanKhau;

public class NhanKhauDaoimpl implements NhanKhauDao {

    @Override
    public List<NhanKhau> getListNhanKhau() {
        Connection cons = connect_to_db.getConnection();
        String sql= "SELECT * FROM nhankhau";
        List<NhanKhau> list= new ArrayList<>();
        try{
            ResultSet rs;
            try (PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                rs = ps.executeQuery();
                while (rs.next()){
                    NhanKhau nk = new NhanKhau();
                    nk.setMaNhanKhau(rs.getInt("manhankhau"));
                    nk.setHoTen(rs.getString("hoten"));
                    nk.setCMND(rs.getString("CMND"));
                    nk.setMaHoKhau(rs.getInt("mahokhau"));
                    nk.setSDT(rs.getString("SĐT"));
                    nk.setTinhTrang(rs.getString("tinhtrang"));
                    nk.setNgaySinh(rs.getDate("ngaysinh"));
                    list.add(nk);
                }
            }
            cons.close();
            rs.close();
        } catch (SQLException e){
        }
        return list;
  
    }
    @Override

//    public int createOrUpdate(NhanKhau nhankhau) {
//    try {
//        ResultSet rs;
//        int generatedKey = 0;
//        try (Connection cons = connect_to_db.getConnection()) {
//            String sql2 = "UPDATE hokhau SET sothanhvien = sothanhvien +1 WHERE mahokhau = ?";
//            
//            String sql = "INSERT INTO nhankhau(manhankhau, hoten, ngaysinh, CMND, SĐT, mahokhau, tinhtrang) " +
//                         "VALUES(?, ?, ?, ?, ?, ?, ?) " +
//                         "ON DUPLICATE KEY UPDATE manhankhau = VALUES(manhankhau), hoten = VALUES(hoten), " +
//                         "ngaysinh = VALUES(ngaysinh), CMND = VALUES(CMND), SĐT = VALUES(SĐT), mahokhau = VALUES(mahokhau), tinhtrang = VALUES(tinhtrang);";
//            try (PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
//                ps.setInt(1, nhankhau.getMaNhanKhau());
//                ps.setString(2, nhankhau.getHoTen());
//                ps.setDate(3, nhankhau.getNgaySinh());
//                ps.setString(4, nhankhau.getCMND());
//                ps.setString(5, nhankhau.getSDT());
//                ps.setInt(6, nhankhau.getMaHoKhau());
//                ps.setString(7, nhankhau.getTinhTrang());
//                ps.executeUpdate();
//
//                rs = ps.getGeneratedKeys();
//                if (rs.next()) {
//                    generatedKey = rs.getInt(1);
//                }
//            }
//            
//            try (PreparedStatement ps2 = cons.prepareStatement(sql2)) {
//                    
//                    ps2.setInt(1,nhankhau.getMaHoKhau());
//                    
//                    ps2.close();           
//                }
//            
//        }
//        return generatedKey;
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    }
//    return 0;
//}
    public int createOrUpdate(NhanKhau nhankhau) {
    int generatedKey = 0;
    String sqlInsertOrUpdate = "INSERT INTO nhankhau(manhankhau, hoten, ngaysinh, CMND, SĐT, mahokhau, tinhtrang) " +
                                "VALUES(?, ?, ?, ?, ?, ?, ?) " +
                                "ON DUPLICATE KEY UPDATE hoten = VALUES(hoten), " +
                                "ngaysinh = VALUES(ngaysinh), CMND = VALUES(CMND), SĐT = VALUES(SĐT), " +
                                "mahokhau = VALUES(mahokhau), tinhtrang = VALUES(tinhtrang)";
    String sqlUpdateHoKhau = "UPDATE hokhau SET sothanhvien = sothanhvien + 1 WHERE mahokhau = ?";

    try (Connection cons = connect_to_db.getConnection()) {
        boolean isNewRecord = false;

        // Kiểm tra xem có phải bản ghi mới không
        try (PreparedStatement psCheck = cons.prepareStatement("SELECT 1 FROM nhankhau WHERE manhankhau = ?")) {
            psCheck.setInt(1, nhankhau.getMaNhanKhau());
            try (ResultSet rs = psCheck.executeQuery()) {
                isNewRecord = !rs.next(); // Nếu không tìm thấy bản ghi, thì đây là bản ghi mới
            }
        }

        // Thêm hoặc cập nhật nhân khẩu
        try (PreparedStatement ps = cons.prepareStatement(sqlInsertOrUpdate, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, nhankhau.getMaNhanKhau());
            ps.setString(2, nhankhau.getHoTen());
            ps.setDate(3, nhankhau.getNgaySinh());
            ps.setString(4, nhankhau.getCMND());
            ps.setString(5, nhankhau.getSDT());
            ps.setInt(6, nhankhau.getMaHoKhau());
            ps.setString(7, nhankhau.getTinhTrang());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    generatedKey = rs.getInt(1);
                }
            }
        }

        // Cập nhật số thành viên trong bảng hộ khẩu nếu là bản ghi mới
        if (isNewRecord) {
            try (PreparedStatement ps2 = cons.prepareStatement(sqlUpdateHoKhau)) {
                ps2.setInt(1, nhankhau.getMaHoKhau());
                ps2.executeUpdate();
            }
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return generatedKey;
}


    @Override
//    public void delete(NhanKhau nhankhau) {
//        try{
//            ResultSet rs;
//            try (Connection cons = connect_to_db.getConnection()) {
//                String s= "SELECT DISTINCT (mahokhau) FROM nhankhau WHERE manhankhau = ?";
//                String sql="DELETE from nhankhau where manhankhau = ? ;";
//                String sql1 = "UPDATE hokhau SET sothanhvien= sothanhvien-1 WHERE mahokhau = ?";
//                try (PreparedStatement ps = cons.prepareStatement(sql)) {
//                    ps.setInt(1, nhankhau.getMaNhanKhau());
//                    ps.execute();
//                    rs = ps.getGeneratedKeys();                   
//                    ps.close();           
//                }
//                try (PreparedStatement ps2 = cons.prepareStatement(s)){
//                    ps2.setInt(1, nhankhau.getMaHoKhau());   
//                    ResultSet rs2 = ps2.executeQuery();
//                    int mahokhau=0;
//                    while (rs2.next()){
//                       mahokhau = rs2.getInt("mahokhau");
//                    }
//                    try (PreparedStatement ps3 = cons.prepareStatement(sql1)){
//                        ps3.setInt(1, mahokhau);
//                        
//                        ps3.executeUpdate();
//                    }
//                
//            }
//            cons.close();
//            }
//            rs.close();     
//        }catch (SQLException ex) {
//        }
//    } 
    public void delete(NhanKhau nhankhau) {
    String queryGetHoKhau = "SELECT mahokhau FROM nhankhau WHERE manhankhau = ?";
    String queryDeleteNhanKhau = "DELETE FROM nhankhau WHERE manhankhau = ?";
    String queryUpdateHoKhau = "UPDATE hokhau SET sothanhvien = sothanhvien - 1 WHERE mahokhau = ?";
    
    try (Connection cons = connect_to_db.getConnection()) {
        // Lấy mahokhau của nhankhau
        int mahokhau = 0;
        try (PreparedStatement ps = cons.prepareStatement(queryGetHoKhau)) {
            ps.setInt(1, nhankhau.getMaNhanKhau());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    mahokhau = rs.getInt("mahokhau");
                }
            }
        }
        
        // Xoá nhân khẩu
        try (PreparedStatement ps = cons.prepareStatement(queryDeleteNhanKhau)) {
            ps.setInt(1, nhankhau.getMaNhanKhau());
            ps.executeUpdate();
        }
        
        // Giảm số lượng thành viên nếu tìm thấy mahokhau
        if (mahokhau != 0) {
            try (PreparedStatement ps = cons.prepareStatement(queryUpdateHoKhau)) {
                ps.setInt(1, mahokhau);
                ps.executeUpdate();
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Log lỗi để tiện theo dõi
    }
}

}
