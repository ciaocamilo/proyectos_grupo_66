import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {


    public Ventana() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);

        JMenuBar mb = new JMenuBar();
        // Creando MenuBar y agregando componentes
        JMenu m1 = new JMenu("ARCHIVO");
        JMenu m2 = new JMenu("Ayuda");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Abrir");
        JMenuItem m12 = new JMenuItem("Guardar como");
        m1.add(m11);
        m1.add(m12);
        // Creando el panel en la parte inferior
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Introducir texto");
        JTextField tf = new JTextField(10);
        JButton send = new JButton("Enviar");
        JButton reset = new JButton("Restablecer");
        panel.add(label);
        panel.add(tf);
        panel.add(send);
        panel.add(reset);
        // Área de texto en el centro
        JTextArea ta = new JTextArea();

        // Agregar componentes al marco.
        this. getContentPane().add(BorderLayout.SOUTH, panel);
        this. getContentPane().add(BorderLayout.NORTH, mb);
        this. getContentPane().add(BorderLayout.CENTER, ta);
        this. setVisible(true);
    }

}
