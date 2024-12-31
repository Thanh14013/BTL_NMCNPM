
package scr.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import scr.model.LichSu;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LichSuDaoimpl implements LichSuDao {

    @Override
    public List<LichSu> getListLichSu() {
         Connection cons = connect_to_db.getConnection();
        String sql= "SELECT * FROM lichsu";
        List<LichSu> list= new ArrayList<>();
        try{
            ResultSet rs;
            try (PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                rs = ps.executeQuery();
                while (rs.next()){
                    LichSu ls = new LichSu();
                    ls.setMahokhau(rs.getInt("mahokhau"));
                    ls.setTennguoidong(rs.getString("tennguoidong"));
                    ls.setNgaydong(rs.getDate("ngaydong"));
                    ls.setSotien(rs.getDouble("sotien"));
                    list.add(ls);
                }
            }
            cons.close();
            rs.close();
        } catch (SQLException e){
        }
        return list;
        
    }
    
}
