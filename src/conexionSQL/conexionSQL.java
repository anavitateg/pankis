/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public boolean agregarCategoria(String nombreCategoria) {
        String consulta = "INSERT INTO categorias (nombre_categoria) VALUES (?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, nombreCategoria);
            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0; // Si se insertó al menos una fila, la operación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al agregar categoría: " + e.getMessage());
            return false;
        }
    }
    
    
     public boolean agregarUnidad(String nombreUnidad, String prefijoUnidad) {
        String consulta = "INSERT INTO unidades (nombre_unidad, prefijo_unidad) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, nombreUnidad);
            stmt.setString(2, prefijoUnidad);
            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0; // Si se insertó al menos una fila, la operación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al agregar unidad: " + e.getMessage());
            return false;
        }
    }
     
    public boolean registrarAccidente(String nombreUnidad, String prefijoUnidad) {
        String consulta = "INSERT INTO unidades (nombre_unidad, prefijo_unidad) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, nombreUnidad);
            stmt.setString(2, prefijoUnidad);
            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0; // Si se insertó al menos una fila, la operación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al agregar unidad: " + e.getMessage());
            return false;
        }
    } 
     
     public List<String> obtenerCategorias() {
        List<String> categorias = new ArrayList<>();
        String consulta = "SELECT nombre_categoria FROM categorias";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                categorias.add(rs.getString("nombre_categoria"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener categorías: " + e.getMessage());
        }
        return categorias;
    }
     
     public List<String> obtenerUnidades() {
        List<String> categorias = new ArrayList<>();
        String consulta = "SELECT nombre_unidad FROM unidades";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                categorias.add(rs.getString("nombre_unidad"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener categorías: " + e.getMessage());
        }
        return categorias;
    }
     
     
     
}
