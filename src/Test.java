/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;

/**
 *
 * @author User
 */
public class Test {
    public static void main(String[] args)  {
        
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // before running app run in mysql the following command: source path/to/db/start.txt
        // ========================================================

        //for testing the data base connection 
        // ========================================================
        ConfigDb db = new ConfigDb();
        Connection conn = db.getConnection();
        if(conn != null){
            System.out.println("Connection successful!");
        } else {
            System.out.println("Connection failed.");
        }
        // ========================================================
       SignUp f1 ;
       
        f1 = new SignUp();
            
         f1.pack();
         f1.setVisible(true);
    
    }
}
