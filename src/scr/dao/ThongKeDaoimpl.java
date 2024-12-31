
package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import scr.model.ThongKe;


public class ThongKeDaoimpl implements ThongKeDao {

    @Override
    public List<ThongKe> getListThongKe() {
        Connection cons = connect_to_db.getConnection();
        String sql2 = """
        UPDATE thongke t
        JOIN (
            SELECT mahokhau, SUM(sotien) AS total_sotien
            FROM hokhau_khoanphi
            WHERE makhoanphi BETWEEN 1 AND 6
            GROUP BY mahokhau
        ) hk ON t.mahokhau = hk.mahokhau
        SET t.tongsotien = hk.total_sotien
    """;
        try (PreparedStatement ps2 = cons.prepareStatement(sql2)) {
        int rowsAffected = ps2.executeUpdate();
        System.out.println("Cập nhật thành công số hàng: " + rowsAffected);
        } catch (SQLException e) {       
            }
        String sql= "SELECT * FROM thongke";
        List<ThongKe> list= new ArrayList<>();
        try{
            ResultSet rs;
            try (PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                rs = ps.executeQuery();
                while (rs.next()){
                    ThongKe tk = new ThongKe();
                    tk.setMaHoKhau(rs.getInt("mahokhau"));
                    tk.setTenChuHo(rs.getString("tenchuho"));
                    tk.setTongSoTien(rs.getDouble("tongsotien"));
                    tk.setConLai(rs.getDouble("conlai"));
                    tk.setTungay(rs.getDate("tungay"));
                    tk.setDenngay(rs.getDate("dengay"));
                    tk.setTinhtrang(rs.getString("tinhtrang"));
                    list.add(tk);
                }
            }
            cons.close();
            rs.close();
        } catch (SQLException e){
        }
        return list;
    }
    
    
}
