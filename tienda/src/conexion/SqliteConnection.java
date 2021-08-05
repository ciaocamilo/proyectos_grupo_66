package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteConnection {

    private Connection conn;

    public SqliteConnection () {

        String archivoDB = "base_de_datos/tienda.db"; // Debe contener la ubicación y nombre del archivo .db
        String url = "jdbc:sqlite:" + archivoDB;
        conn = null;

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("..Conectado a la Base de datos");
        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    public ResultSet ejecutarConsulta(String consulta) {
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return rs;
    }

    public int ejecutarSentencia(String sentencia) {
        int nFilas = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sentencia);
            nFilas = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return nFilas;
    }

    public void cerrarConexion() {
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
