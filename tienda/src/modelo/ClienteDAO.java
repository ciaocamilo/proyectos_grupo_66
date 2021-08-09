package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public String listarProductosPorCliente(String idenCliente, SqliteConnection conexionBD) {
        String salida = "";

            String queryProductos = "SELECT c.nombres || ' ' || c.apellidos AS 'Cliente', p.nombre, p.precio " +
                                    "FROM Clientes c JOIN Ventas v ON c.identificacion = v.idCliente " +
                                    "JOIN VentasProductos vp ON v.codigoVenta = vp.idVenta " +
                                    "JOIN Productos p ON vp.idProducto = p.codigoBarras " +
                                    "WHERE c.identificacion = '" + idenCliente + "'";
        try {
            ResultSet resultadoCliente = conexionBD.ejecutarConsulta(queryProductos);

            while (resultadoCliente.next()) {
                String nombreCliente = resultadoCliente.getString("Cliente");
                String nombreProducto = resultadoCliente.getString("nombre");
                float precioProducto = resultadoCliente.getFloat("precio");
                salida = salida.concat(nombreCliente + " - " + nombreProducto + " $" + precioProducto + "\n");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return salida;
    }

}
