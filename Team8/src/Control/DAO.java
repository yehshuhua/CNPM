/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ntnhu
 */
public class DAO {
    //public de test
    public static Connection con;

    public DAO() {
    }
    
    protected static void getInstance(){
        if(con==null){
            String dbUrl="jdbc:mysql://localhost:3306/qltc";
            String dbClass = "com.mysql.cj.jdbc.Driver";
            try{
                Class.forName(dbClass);
                con=DriverManager.getConnection(dbUrl,"root","lienlien");
            }catch(Exception e){
            e.printStackTrace();
            }              
        }
    }
}