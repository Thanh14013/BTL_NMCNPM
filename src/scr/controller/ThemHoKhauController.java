package scr.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import scr.dao.connect_to_db;
import scr.model.HoKhau;
import scr.service.HoKhauService;
import scr.service.HoKhauserviceimpl;
import java.sql.ResultSet;

public class ThemHoKhauController {
    private JButton bntSubmit;
    private JTextField jtfmahokhau;
    private JTextField jtfsothanhvien;
    private JTextField jtfdiachi;
    private JTextField jtfmachuho;
    private JTextField jtftenchuho;
    private JTextField jtfdientich;
    private JTextField jtfsloto;
    private JTextField jtfslxemay;
    private JLabel jlbMsg;    

    private HoKhau hokhau=null;
    private HoKhauService hokhauservice=null;
    private JPanel HoKhauJpanel;
    public ThemHoKhauController(JPanel HoKhauJpanel, JButton bntSubmit, JTextField jtfmahokhau, JTextField jtfsothanhvien, JTextField jtfdiachi, JTextField jtfmachuho, JTextField jtftenchuho, JTextField jtfdientich, JTextField jtfsloto, JTextField jtfslxemay, JLabel jlbMsg) {
        this.bntSubmit = bntSubmit;
        this.jtfmahokhau = jtfmahokhau;
        this.jtfsothanhvien = jtfsothanhvien;
        this.jtfdiachi = jtfdiachi;
        this.jtfmachuho = jtfmachuho;
        this.jtftenchuho = jtftenchuho;
        this.jtfdientich = jtfdientich;
        this.jtfsloto = jtfsloto;
        this.jtfslxemay = jtfslxemay;
        this.jlbMsg = jlbMsg;
        this.HoKhauJpanel = HoKhauJpanel;
        
        this.hokhauservice = new HoKhauserviceimpl();
    }
    
    public void setView(HoKhau hokhau){
        this.hokhau = hokhau;
        
        jtfmahokhau.setText("" + hokhau.getMaHoKhau());
        jtfsothanhvien.setText("" + hokhau.getSoThanhVien());
        jtfdiachi.setText(hokhau.getDiaChi());
        jtfmachuho.setText("" + hokhau.getMaChuHo());
        jtfdientich.setText("" +hokhau.getDienTich());
        jtftenchuho.setText(hokhau.getTenChuHo());
        jtfsloto.setText(""+ hokhau.getSlot());
        jtfslxemay.setText("" + hokhau.getSlxemay());
        
        setEvent();
    }
    
//    public void setEvent(){
//         bntSubmit.addMouseListener(new MouseAdapter() {
//             @Override
//             public void mouseClicked(MouseEvent e) {
//                try {
//                    if (!checkNotNull()) {
//                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
//                        return;
//                    }
//        hokhau.setSoThanhVien(Integer.parseInt(jtfsothanhvien.getText()));
//        hokhau.setDiaChi(jtfdiachi.getText().trim());
//        hokhau.setMaChuHo(Integer.parseInt(jtfmachuho.getText()));
//        hokhau.setDienTich(Double.parseDouble(jtfdientich.getText()));
//        hokhau.setTenChuHo(jtftenchuho.getText());
//        hokhau.setSlot(Integer.parseInt(jtfsloto.getText()));
//        hokhau.setSlxemay(Integer.parseInt(jtfslxemay.getText()));
//
//        // Xử lý createOrUpdate
//        int lastId = hokhauservice.createOrUpdate(hokhau);
//        jlbMsg.setText("Thành công!!");       
//    } catch (NumberFormatException ex) {
//        jlbMsg.setText("Lỗi định dạng số: " + ex.getMessage());
//    }
//               
//         String maHoKhauText = jtfmahokhau.getText();
//    String tenChuHo = jtftenchuho.getText();
//
//    // Kiểm tra dữ liệu đầu vào
//    if (maHoKhauText == null || maHoKhauText.trim().isEmpty() || tenChuHo == null || tenChuHo.trim().isEmpty()) {
//        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
//        return;
//    }
//
//    try {
//        int maHoKhau = Integer.parseInt(maHoKhauText);
//
//        try (java.sql.Connection cons = connect_to_db.getConnection();
//             PreparedStatement ps = cons.prepareStatement(
//                     "INSERT INTO thongke(mahokhau, tenchuho, tongsotien, conlai, tungay, dengay, tinhtrang) " +
//                     "VALUES (?, ?, 0, 0, '2025-01-02', '2025-01-02', 'Chưa Thanh Toán') ON DUPLICATE KEY UPDATE tenchuho = VALUES(tenchuho)"
//             )) {
//
//            ps.setInt(1, maHoKhau);
//            ps.setString(2, tenChuHo);
//
//            ps.executeUpdate();
//        }
//
//    } catch (NumberFormatException ex) {
//        JOptionPane.showMessageDialog(null, "Mã hộ khẩu phải là số hợp lệ!");
//    } catch (SQLException ex) {
//                }
//         
//     try {
//        int maHoKhau = Integer.parseInt(maHoKhauText);
//
//        try (java.sql.Connection cons = connect_to_db.getConnection();
//             PreparedStatement ps = cons.prepareStatement(
//                     "INSERT INTO hokhau_khoanphi(mahokhau, makhoanphi, sotien) " +
//                     "VALUES (?, ?, ?)"
//             )) {
//
//            ps.setInt(1, maHoKhau);
//            
//            ps.setInt(2, 1);
//            ps.setDouble(3, 5000*Double.parseDouble(jtfdientich.getText()));
//            ps.executeUpdate();
//            
//            ps.setInt(2, 2);
//            ps.setDouble(3, 7000*Double.parseDouble(jtfdientich.getText()));
//            ps.executeUpdate();
//            
//            ps.setInt(2, 3);
//            ps.setDouble(3, 0);
//            ps.executeUpdate();
//            
//            ps.setInt(2, 4);
//            ps.setDouble(3, 70000*Integer.parseInt(jtfslxemay.getText()));
//            ps.executeUpdate();
//            
//            ps.setInt(2, 5);
//            ps.setDouble(3,1200000*Integer.parseInt(jtfsloto.getText()));
//            ps.executeUpdate();
//            
//            ps.setInt(2, 6);
//            ps.setDouble(3, 0);
//            ps.executeUpdate();
//        }
//
//    } catch (NumberFormatException ex) {
//        JOptionPane.showMessageDialog(null, "Mã hộ khẩu phải là số hợp lệ!");
//    } catch (SQLException ex) {
//                }
//        
//    
//    
//    
//}
//
//         });
//         
//       
//    }
    public void setEvent() {
    bntSubmit.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                // Kiểm tra dữ liệu đầu vào
                if (!checkNotNull()) {
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    return;
                }

                hokhau.setSoThanhVien(Integer.parseInt(jtfsothanhvien.getText()));
                hokhau.setDiaChi(jtfdiachi.getText().trim());
                hokhau.setMaChuHo(Integer.parseInt(jtfmachuho.getText()));
                hokhau.setDienTich(Double.parseDouble(jtfdientich.getText()));
                hokhau.setTenChuHo(jtftenchuho.getText());
                hokhau.setSlot(Integer.parseInt(jtfsloto.getText()));
                hokhau.setSlxemay(Integer.parseInt(jtfslxemay.getText()));

                // Xử lý createOrUpdate
                int lastId = hokhauservice.createOrUpdate(hokhau);
                jlbMsg.setText("Thành công!!");
            } catch (NumberFormatException ex) {
                jlbMsg.setText("Lỗi định dạng số: " + ex.getMessage());
                return;
            }

            String maHoKhauText = jtfmahokhau.getText();
            String tenChuHo = jtftenchuho.getText();

            // Kiểm tra mã hộ khẩu và tên chủ hộ
            if (maHoKhauText == null || maHoKhauText.trim().isEmpty() || tenChuHo == null || tenChuHo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
                return;
            }

            try (Connection cons = connect_to_db.getConnection()) {
                int maHoKhau = Integer.parseInt(maHoKhauText);
                double x = Double.parseDouble(jtfdientich.getText())*12000 + 70000*Integer.parseInt(jtfslxemay.getText())+1200000*Integer.parseInt(jtfsloto.getText());
                // Cập nhật bảng thongke
                try (PreparedStatement ps = cons.prepareStatement(
                        "INSERT INTO thongke(mahokhau, tenchuho, tongsotien, conlai, tungay, dengay, tinhtrang) " +
                        "VALUES (?, ?, 0, ?, '2025-01-02', '2025-01-02', 'Chưa Thanh Toán') ON DUPLICATE KEY UPDATE tenchuho = VALUES(tenchuho)")) {
                    ps.setInt(1, maHoKhau);
                    ps.setString(2, tenChuHo);
                    ps.setDouble(3, x);
                    ps.executeUpdate();
                }

                // Cập nhật bảng hokhau_khoanphi
                String checkExistQuery = "SELECT COUNT(*) FROM hokhau_khoanphi WHERE mahokhau = ? AND makhoanphi = ?";
                String insertQuery = "INSERT INTO hokhau_khoanphi(mahokhau, makhoanphi, sotien) VALUES (?, ?, ?)";
                
                try (PreparedStatement checkStmt = cons.prepareStatement(checkExistQuery);
                     PreparedStatement insertStmt = cons.prepareStatement(insertQuery)) {

                    for (int makhoanphi = 1; makhoanphi <= 6; makhoanphi++) {
                        double sotien = switch (makhoanphi) {
                            case 1 -> 5000 * Double.parseDouble(jtfdientich.getText());
                            case 2 -> 7000 * Double.parseDouble(jtfdientich.getText());
                            case 3 -> 0;
                            case 4 -> 70000 * Integer.parseInt(jtfslxemay.getText());
                            case 5 -> 1200000 * Integer.parseInt(jtfsloto.getText());
                            case 6 -> 0;
                            default -> 0;
                        };

                        // Kiểm tra bản ghi đã tồn tại chưa
                        checkStmt.setInt(1, maHoKhau);
                        checkStmt.setInt(2, makhoanphi);
                        try (ResultSet rs = checkStmt.executeQuery()) {
                            if (rs.next() && rs.getInt(1) == 0) { // Nếu chưa tồn tại
                                insertStmt.setInt(1, maHoKhau);
                                insertStmt.setInt(2, makhoanphi);
                                insertStmt.setDouble(3, sotien);
                                insertStmt.executeUpdate();
                            }
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Mã hộ khẩu phải là số hợp lệ!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi cơ sở dữ liệu: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    });
}

    private boolean checkNotNull() {
            return jtftenchuho.getText() != null && !jtftenchuho.getText().equalsIgnoreCase("");
    }
    
    
}

