/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pankis;
import conexionSQL.conexionSQL;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class Pankis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        login l= new login();
        
        l.setVisible(true);
        
        conexionSQL con=new conexionSQL();
        Connection connection = con.getConnection();

        if (connection != null) {
            System.out.println("Conexión exitosa a la base de datos PostgreSQL");

            // Puedes ejecutar consultas u otras operaciones aquí
            
            con.cerrarConexion();
        } else {
            System.out.println("No se pudo establecer conexión a la base de datos");
        }
        
    }
    
}
