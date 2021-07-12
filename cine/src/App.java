import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Bienvenido al cine");

        // Cliente Uno

        Scanner sca = new Scanner(System.in);
        System.out.println("Ingrese su cédula: ");
        String cedula = sca.nextLine();
        System.out.println("Ingrese su nombre: ");
        String nombre = sca.nextLine();

        Cliente clienteUno = new Cliente();
        clienteUno.setCedula(cedula);
        clienteUno.setNombre(nombre);
        clienteUno.setId(1);
        clienteUno.generarSaludo();
        clienteUno.generarSaludo("Buenos días");
        clienteUno.mostrarDatos();
        float costo = clienteUno.calcularCosto(8000);

        System.out.println("Cédula: " + clienteUno.getCedula() + "\nNombre: "
                            + clienteUno.getNombre() + "\nID: " + clienteUno.getId()
                            + "\nCosto tiquete: " + costo);

        // Cliente Dos

        ClientePremium clienteDos = new ClientePremium();
        clienteDos.setCedula("11657777");
        clienteDos.setNombre("José");
        clienteDos.setNumeroTarjeta(100);
        clienteDos.mostrarDatos();

        System.out.println();
        float costoDos = clienteDos.calcularCosto(8000);

        System.out.println("Cédula: " + clienteDos.getCedula() + "\nNombre: "
        + clienteDos.getNombre() + "\nNúmero tarjeta: " + clienteDos.getNumeroTarjeta()
        + "\nCosto tiquete: " + costoDos);

    }
}