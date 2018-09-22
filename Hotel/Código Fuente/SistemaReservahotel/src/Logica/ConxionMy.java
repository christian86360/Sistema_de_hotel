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
 * @author LugoMaroquin
 */
public class ConxionMy {
    Connection conect = null;
    public Connection conexion()
    {
        try{
        //Cargamos el Driver MYSQL
        Class.forName("org.gjt.mm.mysql.Driver");
       conect=DriverManager.getConnection("jdbc:mysql://localhost/sistemaventas","root","");
       
    }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "Error"+e);
            }
    return conect;
    }
}

