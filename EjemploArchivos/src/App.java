// import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        // int numBytes = 0;
        // char caracter;
        // System.out.println("\nEscribe el texto: ");
        // try {
        //     do {
        //         caracter = (char)System.in.read();
        //         System.out.print(caracter);
        //         numBytes++;
        //         } while (caracter != '\n');
        //             System.err.printf("%d bytes leidos %n", numBytes);
        // } catch (IOException e) {
        //     System.err.println(e);
        // }

        /*Escritura*/
        int[][] numeros = { { 1, 2, 3, 4, 5},
                            { 6, 7, 8, 9, 10},
                            {11, 12, 13, 14, 15},
                            {16, 17, 18, 19, 20},
                            {21, 22, 23, 24, 25}};
        var archivo = "Numeros.txt";
        var salida = new PrintWriter(archivo);

        for (int i=0; i< numeros.length; i++) {
            for (int j=0; j< numeros[i].length; j++)
            {
                salida.print(numeros[i][j] + ",");
            }
            salida.println("");
        }
        salida.close();

        // /*Lectura*/
        String nombre = "Numeros.txt";
        var archivo2 = new File(nombre);
        if (archivo2.exists()) {
            var lector = new Scanner(archivo2);
            System.out.println("Números del archivo");
            while (lector.hasNext()) {
                var numeros2 = new StringTokenizer(lector.next(),",");
            while (numeros2.hasMoreTokens()) {
                System.out.print(numeros2.nextToken() + "\t");
            }
            System.out.println("");
            }
            lector.close();
        } else {
            System.out.println("¡El archivo no existe!");
        }

        // Escritura de archivo
        var nombreArchivo = "Personas.miprueba";
        try {
            var archivo3 = new FileOutputStream(nombreArchivo);
            var oos = new ObjectOutputStream(archivo3);
            oos.writeObject(new Persona("552871883",
            "María", "Ruiz Ramos"));
            oos.writeObject(new Persona("403020104",
            "Juan", "González López"));
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("¡El archivo no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        };


        // Lectura de archivo
        // var nombreArchivo = "Personas.miprueba";
        try {
            var archivo3 = new FileInputStream(nombreArchivo);
            var ois = new ObjectInputStream(archivo3);
            var p1 = (Persona) ois.readObject();
            var p2 = (Persona) ois.readObject();
            ois.close();
            System.out.println("Cedula\t Nombre");
            System.out.println(p1.getAtributos());
            System.out.println(p2.getAtributos());
        } catch (FileNotFoundException e) {
            System.out.println("¡El archivo no existe!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        };



    }
}
