public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("La Tienda de Ropa");

        Producto productoUno = new Producto();

        productoUno.setNombre("Falda");
        productoUno.setPrecio(70000);
        productoUno.mostrar();

    }
}
