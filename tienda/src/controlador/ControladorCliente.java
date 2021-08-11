package controlador;

import conexion.SqliteConnection;
import modelo.Cliente;
import modelo.ClienteDAO;

public class ControladorCliente {

    public void crearCliente(Cliente nuevoCliente, SqliteConnection conexionBD) {
        ClienteDAO cli1 = new ClienteDAO();
        cli1.insertarCliente(nuevoCliente, conexionBD);
    }

    public String listarClientes(SqliteConnection conexionBD) {
        ClienteDAO cli1 = new ClienteDAO();
        String clientes = cli1.mostrarClientes(conexionBD);
        return clientes;
    }

    public String listarProductosCliente(String idenCliente, SqliteConnection conexionBD) {
        ClienteDAO cli1 = new ClienteDAO();
        String productos = cli1.listarProductosPorCliente(idenCliente, conexionBD);
        return productos;
    }

}
