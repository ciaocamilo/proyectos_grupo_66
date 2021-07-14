import java.util.ArrayList;
import java.util.Scanner;

public class Prueba {

    public void generarLista() {
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
        }

    }

}
