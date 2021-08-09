import conexion.SqliteConnection;
import vista.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("*La Tienda de Ropa**");
        /*Se crea conexión a la base de datos*/
        SqliteConnection conexionBD = new SqliteConnection();
        Menu menuPrincipal = new Menu();
        menuPrincipal.generarMenu(conexionBD);

        // Producto productoUno = new Producto();

        // productoUno.setNombre("Falda");
        // productoUno.setPrecio(70000);
        // productoUno.mostrar();

        //////////// Ejemplo consulta /////////////////////
/*         ResultSet resultado = conexionBD.ejecutarConsulta("SELECT * FROM PRODUCTOS");
        while(resultado.next()) {
            String codiBarras = resultado.getString("CodigoBarras");
            String nomProducto = resultado.getString("nombre");
            float precioProd = resultado.getFloat("precio");

            System.out.println(codiBarras + " " + nomProducto + " $" + precioProd);
        } */

        ///////////////-- Creación y consulta de clientes --/////////////////////
        /*JOptionPane*/
        // String prueba = JOptionPane.showInputDialog(null, "Cuál su nombre?", "Nuevo cliente", JOptionPane.QUESTION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Hola Mundo", "SALUDO", JOptionPane.WARNING_MESSAGE);

    }

}
