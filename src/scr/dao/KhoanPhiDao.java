/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scr.dao;

import java.util.List;
import scr.model.KhoanPhi;

/**
 *
 * @author admin
 */
public interface KhoanPhiDao {
    public List<KhoanPhi> getListKhoanPhi();
    public int createOrUpdate (KhoanPhi khoanphi);
    public void delete(KhoanPhi khoanphi);

}
