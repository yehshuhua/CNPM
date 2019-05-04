/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.DAO.con;
import Model.KipHoc;
import Model.LichGiangDay;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ntnhu
 */
public class KipHocDAO extends DAO{

    public KipHocDAO() {
        getInstance();
    }
    public KipHoc TimKipHocTheoId(int id){
       KipHoc KH=null;
        String sql="Select * FROM tblkiphoc WHERE id = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            rs.absolute(1);
            if(rs.getInt("id")>0){
                KH=new KipHoc();
                KH.setKipHocId(id);
                KH.setGioBatDau(rs.getInt("gioBatDau"));
                KH.setGioKetThuc(rs.getInt("gioKetThuc"));
                KH.setThu(rs.getInt("thu"));                
            }
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KH;
    }
}
