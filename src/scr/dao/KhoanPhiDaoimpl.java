
package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import scr.model.KhoanPhi;


public class KhoanPhiDaoimpl implements KhoanPhiDao {
    
    

    @Override
    public List<KhoanPhi> getListKhoanPhi() {
         Connection cons = (Connection) connect_to_db.getConnection();
        String sql= "SELECT * FROM khoanphi";
        List<KhoanPhi> list= new ArrayList<>();
        try{
            ResultSet rs;
            try (PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                rs = ps.executeQuery();
                while (rs.next()){
                    KhoanPhi kp = new KhoanPhi();
                    kp.setMaKhoanPhi(rs.getInt("makhoanphi"));
                    kp.setTenKhoanPhi(rs.getString("tenkhoanphi"));
                    kp.setSoTien(rs.getInt("sotien"));
                    kp.setLoaiKhoanPhi(rs.getString("loaikhoanphi"));
                    list.add(kp);
                }
            }
            cons.close();
            rs.close();
        } catch (SQLException e){
        }
        return list;
    }

    @Override
    public int createOrUpdate(KhoanPhi khoanphi) {
        try{
            ResultSet rs;
            int generatedKey;
            try (Connection cons = connect_to_db.getConnection()) {
                String sql="INSERT INTO khoanphi(makhoanphi,tenkhoanphi, sotien, loaikhoanphi) VALUES(?, ?, ?, ?) ON DUPLICATE KEY UPDATE makhoanphi = VALUES(makhoanphi), tenkhoanphi = VALUES(tenkhoanphi), sotien = VALUES(sotien), loaikhoanphi = VALUES(loaikhoanphi);";
                try (PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    ps.setInt(1, khoanphi.getMaKhoanPhi());
                    ps.setString(2, khoanphi.getTenKhoanPhi());
                    ps.setLong(3, khoanphi.getSoTien());
                    ps.setString(4, khoanphi.getLoaiKhoanPhi());
                    ps.execute();
                    rs = ps.getGeneratedKeys();
                    generatedKey = 0;
                    if (rs.next()) {
                        generatedKey = rs.getInt(1);
                    }
                    ps.close();           
                }
            cons.close();
            }
            rs.close();
            return generatedKey;
        }catch (SQLException ex) {
        }
        return 0;
        

    }

    @Override
    public void delete(KhoanPhi khoanphi) {
         try{
            ResultSet rs;
            try (Connection cons = connect_to_db.getConnection()) {
                String sql="DELETE from khoanphi where makhoanphi = ? ;";
                try (PreparedStatement ps = cons.prepareStatement(sql)) {
                    ps.setInt(1, khoanphi.getMaKhoanPhi());
                    ps.execute();
                    rs = ps.getGeneratedKeys();                   
                    ps.close();           
                }
            cons.close();
            }
            rs.close();     
        }catch (SQLException ex) {
        }
        
    }
    
}
