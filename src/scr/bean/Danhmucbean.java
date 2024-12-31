package scr.bean;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Danhmucbean {
    private String kind;
    private JPanel jpn;
    private JLabel jlb;
    public Danhmucbean(){
    };
    public Danhmucbean(String kind,JPanel jpn,JLabel jlb ){
        this.kind= kind;
        this.jlb=jlb;
        this.jpn=jpn;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }
    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
    public String getKind() {
        return kind;
    }
    public JPanel getJpn() {
        return jpn;
    }
   public JLabel getJlb() {
        return jlb;
    } 
}
