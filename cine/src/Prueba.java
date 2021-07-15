import java.util.ArrayList;
import java.util.InputMismatchException;
// import java.util.IndexOutOfBoundsException;
import java.util.Scanner;

public class Prueba {

    private ArrayList<Cliente> listaClientes;

    public Prueba(){
        listaClientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente pCliente){
        listaClientes.add(pCliente);
    }

    public void mostrarNombreClientes() {
        System.out.println("Nombre de clientes");
        for (int i = 0; i < listaClientes.size(); i++){
            System.out.println(listaClientes.get(i).getNombre());
        }
    }

    public void mostrarDatosClientes() {
        String cadenaClientes = "";
        System.out.println("\nDatos de clientes");
        for (int i = 0; i < listaClientes.size(); i++){
            String datos = "\nCédula: " + listaClientes.get(i).getCedula()
                            + "\nNombre: " + listaClientes.get(i).getNombre()
                            + "\nID: " + listaClientes.get(i).getId()
                            + "\n-----------------";
            cadenaClientes = cadenaClientes.concat(datos);
        }
        System.out.println(cadenaClientes);
    }

    public void generarLista() {
        // System.out.println("Ingresó al metodo prueba");
        try {
            ArrayList<Integer> listaNumeros = new ArrayList<>();

            Scanner sca = new Scanner(System.in);
            int numero = 0;
            while (numero >= 0) {
                System.out.println("Ingrese un número (Número negativo para salir): ");
                numero = sca.nextInt();
                if (numero >= 0) {
                    listaNumeros.add(numero);
                }
            }

            System.out.println();
            // Ciclo for
            for (int i = 0; i < listaNumeros.size(); i++) {
                System.out.println(listaNumeros.get(i));
                // System.out.println(listaNumeros.get(i+1));
            }

            System.out.println();

            // Ciclo for each
            listaNumeros.forEach((elemento) -> {
                System.out.println(elemento);
                // elemento = elemento * 2;
            });
        } catch(InputMismatchException e){ // Excepción de tipo de dato
            System.out.println("Solo se permiten números");
        } catch(Exception e2){ // Excepción general
            System.out.println("Se presentó error en la lista");
        }finally {
            System.out.println("Finalizó método");
        }
    }

}
