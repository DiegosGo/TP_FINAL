package data;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Series;
import java.util.List;

public class SeriesDAO
{
    private static final String SQL_SELECT = "SELECT * FROM lista";
    private static final String SQL_SELECT_BY_ID = "SELECT id, Nombre, Lanzamiento, Temporadas, Plataforma FROM lista WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO lista( Nombre, Lanzamiento, Temporadas, Plataforma) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE lista SET Nombre = ?, Lanzamiento = ?, Temporadas = ?, Plataforma = ?  WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM lista WHERE id = ?";
    
    public List<Series> seleccionar() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Series serie = null;
        final List<Series> series = new ArrayList<Series>();
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement("SELECT * FROM lista");
            rs = stmt.executeQuery();
            while (rs.next()) {
                final int id = rs.getInt("id");
                final String Nombre = rs.getString("Nombre");
                final int Lanzamiento = rs.getInt("Lanzamiento");
                final int Temporadas = rs.getInt("Temporadas");
                final String Plataforma = rs.getString("Plataforma");
                serie = new Series(id, Nombre, Lanzamiento, Temporadas, Plataforma);
                series.add(serie);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            
            
        }
        finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            }
            catch (SQLException ex2) {
                ex2.printStackTrace(System.out);
            }
        }
        return series;
    }
    
    public int insertar(final Series serie) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement("INSERT INTO lista( Nombre, Lanzamiento, Temporadas, Plataforma) VALUES(?, ?, ?, ?)");
            stmt.setString(1, serie.getNombre());
            stmt.setInt(2, serie.getLanzamiento());
            stmt.setInt(3, serie.getTemporadas());
            stmt.setString(4, serie.getPlataforma());
            registros = stmt.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
                Conexion.close(stmt);
                Conexion.close(conn);
            
            
        }
        finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            }
            catch (SQLException ex2) {
                ex2.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(final Series serie) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement("UPDATE lista SET Nombre = ?, Lanzamiento = ?, Temporadas = ?, Plataforma = ?  WHERE id = ?");
            stmt.setString(1, serie.getNombre());
            stmt.setInt(2, serie.getLanzamiento());
            stmt.setInt(3, serie.getTemporadas());
            stmt.setString(4, serie.getPlataforma());
            stmt.setInt(5, serie.getId());
            registros = stmt.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
                Conexion.close(stmt);
                Conexion.close(conn);
            
        }
        finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            }
            catch (SQLException ex2) {
                ex2.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int eliminar(final int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement("DELETE FROM lista WHERE id = ?");
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
                Conexion.close(stmt);
                Conexion.close(conn);
            
        }
        finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            }
            catch (SQLException ex2) {
                ex2.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public Series seleccionarPorId(final int id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Series serie = null;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement("SELECT id, Nombre, Lanzamiento, Temporadas, Plataforma FROM lista WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                final int idserie = rs.getInt("id");
                final String nombre = rs.getString("Nombre");
                final int lanzamiento = rs.getInt("Lanzamiento");
                final int temporadas = rs.getInt("Temporadas");
                final String plataforma = rs.getString("Plataforma");
                serie = new Series(idserie, nombre, lanzamiento, temporadas, plataforma);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
           
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            
        }
        finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            }
            catch (SQLException ex2) {
                ex2.printStackTrace(System.out);
            }
        }
        return serie;
    }
}