package modelo;

import java.sql.ResultSet;
import conexion.SqliteConnection;

public class ClienteDAO {

    public void insertarCliente(Cliente nuevoCliente, SqliteConnection conexionBD) {
        String sentencia = "INSERT INTO Clientes (identificacion, nombres, apellidos) VALUES('" + nuevoCliente.getIdentificacion() + "', '"+ nuevoCliente.getNombres() + "', '" + nuevoCliente.getApellidos() + "')";
        conexionBD.ejecutarSentencia(sentencia);
    }

    public String mostrarClientes(SqliteConnection conexionBD) {
        String salida = "";
        try {
            ResultSet resultadoClientes = conexionBD.ejecutarConsulta("SELECT * FROM Clientes ORDER BY identificacion LIMIT 10");
            while (resultadoClientes.next()) {
                String identificacion = resultadoClientes.getString("identificacion");
                String nombres = resultadoClientes.getString("nombres");
                String apellidos = resultadoClientes.getString("apellidos");
                salida = salida.concat(identificacion + " - " + nombres + " - " + apellidos + "\n");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return salida;
    }

}
