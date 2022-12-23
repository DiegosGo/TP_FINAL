package data;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;

public class Conexion
{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/series?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USR = "root";
    private static final String JDBC_PASS = "admin";
    
    public static DataSource getDataSource() throws ClassNotFoundException {
        final BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/series?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true");
        ds.setUsername("root");
        ds.setPassword("admin");
        ds.setInitialSize(20);
        return (DataSource)ds;
    }
    
    public static Connection getConexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            return getDataSource().getConnection();
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void close(final ResultSet rs) throws SQLException {
        rs.close();
    }
    
    public static void close(final Statement st) throws SQLException {
        st.close();
    }
    
    public static void close(final Connection cn) throws SQLException {
        cn.close();
    }
}
