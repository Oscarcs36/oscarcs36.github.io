package jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?zeroDataTimeBehavior=convertToNull&useTimezone=true&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "oscar1375";

    private static BasicDataSource dataSource;

    public static DataSource getDataSoure(){
        if(dataSource == null){
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            //Definimos el tamaño inicial del pool de conexiones
            dataSource.setInitialSize(5);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSoure().getConnection();
    }

    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
