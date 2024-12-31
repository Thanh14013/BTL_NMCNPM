
package scr.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import scr.dao.connect_to_db;
import scr.view.MainJFrame;
import scr.view.ThongKeJFrame;


public class LoginController {
    private JTextField jtfusername;
    private JTextField  jtfpassword;
    private JButton btnlogin;
    private JLabel jlbMsg;
    private JDialog login;

    public LoginController(JDialog login, JTextField jtfusername, JTextField jtfpassword, JButton btnlogin, JLabel jlbMsg) {
        this.jtfusername = jtfusername;
        this.jtfpassword = jtfpassword;
        this.btnlogin = btnlogin;
        this.jlbMsg = jlbMsg;
        this.login= login;
    }
    
    public void setEvent() throws SQLException{
        java.sql.Connection cons = connect_to_db.getConnection();
        String sql="SELECT username, password FROM taikhoan;";
        PreparedStatement ps = cons.prepareStatement(sql);
        btnlogin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){              
                try { 
                    String username = jtfusername.getText();
                    String password = jtfpassword.getText();
                    if ((username.length()==0)||(password.length()==0)){
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                        System.out.println("222");
                        jlbMsg.repaint();
                        jlbMsg.revalidate();
                    }
                else{
                    boolean check =false;   
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()){
                        String x = rs.getString("username");
                        String y = rs.getString("password");
                        
                        if ((x.equals(username))&&(y.equals(password))) {
                           
                            check = true;
                            break;
                        }
                    }  
                    if(check == false){
                        jlbMsg.setText("Tài khoản hoặc mật khẩu không đúng!");
                        System.out.println("111");
                        jlbMsg.repaint();
                        jlbMsg.revalidate();
                    }
                    else{
                        login.dispose();
                        MainJFrame frame = new MainJFrame();
                        frame.setTitle("Quản lý chung cư");
                        frame.setVisible(true);
                    }
                    }
                                      
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
