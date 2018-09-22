/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author LugoMarroquin
 */
public class conexion {
    public String db="sistemaventas";
//public String url="jdbc:mysql://192.168.0.8/" +db;   
 public String url="jdbc:mysql://localhost/" +db;   
    //public String url="jdbc:mysql://127.0.0.1/" +db;
   // public String user="christian";
    //public String pass="123";
 public String user="root";
 public String pass="";

    public conexion() {
    }
    
    public Connection conectar(){
        Connection link=null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
           link=DriverManager.getConnection(this.url, this.user, this.pass);
            //link=DriverManager.getConnection("jdbc:mysql://localhost/basereserva","root","12345678");
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            
        }
        
        return link;
    }
    
   
    
    
}
