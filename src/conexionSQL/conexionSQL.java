/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionSQL;
import java.sql.*;


public class conexionSQL {
    private static final String URL = "jdbc:postgresql://localhost:5432/pankis"; // Cambia por tus detalles de conexión
    private static final String USUARIO = "postgres"; // Cambia por tu usuario
    private static final String CONTRASENA = "12345"; // Cambia por tu contraseña
    
    private Connection connection;

    public conexionSQL() {
        try {
            connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos PostgreSQL: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void cerrarConexion() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
    
    public boolean validarUsuario(String nombreUsuario, String contraseña) {
        String consulta = "SELECT * FROM usuarios WHERE nick_usuario = ? AND contra_usuario = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, nombreUsuario);
            stmt.setString(2, contraseña);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Si hay un resultado, las credenciales son correctas
        } catch (SQLException e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
            return false;
        }
    }
    
    
    
}
