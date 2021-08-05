import modelo.*;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexion.SqliteConnection;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("*La Tienda de Ropa**");

        // Producto productoUno = new Producto();

        // productoUno.setNombre("Falda");
        // productoUno.setPrecio(70000);
        // productoUno.mostrar();

        /*Se crea conexión a la base de datos*/
        SqliteConnection conexionBD = new SqliteConnection();

        //////////// Ejemplo consulta /////////////////////
        ResultSet resultado = conexionBD.ejecutarConsulta("SELECT * FROM PRODUCTOS");
        while(resultado.next()) {
            String codiBarras = resultado.getString("CodigoBarras");
            String nomProducto = resultado.getString("nombre");
            float precioProd = resultado.getFloat("precio");

            System.out.println(codiBarras + " " + nomProducto + " $" + precioProd);
        }

        ///////////////-- Creación y consulta de clientes --/////////////////////

        /*JOptionPane*/
        String ident = JOptionPane.showInputDialog(null, "Ingrese la identificación del cliente", "LA TIENDA DE ROPA", JOptionPane.QUESTION_MESSAGE);
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente", "LA TIENDA DE ROPA", JOptionPane.QUESTION_MESSAGE);
        String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del cliente", "LA TIENDA DE ROPA", JOptionPane.QUESTION_MESSAGE);

        /*Objeto cliente*/
        Cliente nuevoCliente = new Cliente(ident, nombre, apellido);

        /*Objeto ClienteDAO para insertar cliente*/
        ClienteDAO cli1 = new ClienteDAO();
        cli1.insertarCliente(nuevoCliente, conexionBD);

        /*Consulta cliente*/
        String clientes = cli1.mostrarClientes(conexionBD);
        JOptionPane.showMessageDialog(null, clientes, "Listado de clientes", JOptionPane.INFORMATION_MESSAGE);

    }

}
