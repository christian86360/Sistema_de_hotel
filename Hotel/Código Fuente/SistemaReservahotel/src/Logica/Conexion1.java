
package Logica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

/**
 *
 * @author LugoMaroquin
 */
public class Conexion1 {

    static Connection contacto = null;
    public static String usuario;
    public static String password;
    public static boolean  status=false;

    public static Connection getConexion() {
        status=false;
        String url = "jdbc:sqlserver://DESKTOP-QI6AUGP:1433;databaseName=hotel_Conejo69";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion....revisar Driver" + e.getMessage(),
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }

        try {
            contacto = DriverManager.getConnection(url,Conexion1.usuario,Conexion1.password);
            status=true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }
    
    
    
    
    public static void setcuenta(String usuario, String password){
        Conexion1.usuario=usuario;
        Conexion1.password=password;
    }
    public static boolean getstatus(){
        return status;
    }
    public static ResultSet Consulta(String consulta){
        Connection con= getConexion();
        try{
        Statement declara;
        declara=con.createStatement();
        ResultSet respuesta=declara.executeQuery(consulta);
        return respuesta;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage(),
            "Error de conexion",JOptionPane.ERROR_MESSAGE);
        }
        return null;
                
    }

}

