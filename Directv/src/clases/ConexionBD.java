
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jose Luis
 */
public class ConexionBD {
    
    static String bd      = "inmobiliaria";
    static String usuario = "root";
    static String clave   = "cinar";
    static String url     = "jdbc:mysql://localhost/"+bd;
    
    public static Connection conexion = null;
    
    public static Connection conectarBD()
    {
    
        try 
        {
            // Obtenemos el driver para Mysql
            
            Class.forName("com.mysql.jdbc.Driver");
            
            // Obtenemos la conexion
            
            conexion = DriverManager.getConnection(url,usuario,clave);
            
            if( conexion != null )
            {
                System.out.println("Conexin a la Base de Datos: "+bd+" OK \n");
            }
            
        }
        catch (ClassNotFoundException | SQLException e) {
            
            System.out.println("Error al conectar con la BD:");
            System.out.println("Error: "+e.getMessage());
        }
        
        return conexion;
 
    } // ConectarBD
            
    
    public static void desconectarBD()
    {
        
        conexion = null;
        
    } // desconectarBD;
            
    
    
    
    
    
}
