/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Inicio extends JFrame {
    JComboBox combo;

    public Inicio() {
    
        this.getContentPane().setLayout(new FlowLayout());
        this.setBounds(100, 100, 100, 100);

        JButton button1 = new JButton();
        button1.setText("Iniciar");

        combo = new JComboBox();
        combo.addItem("Espaniol");
        combo.addItem("Ingles");
        combo.addItem("Japones");

        add(combo);
     
        add(button1);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Idioma lenguaje = new Idioma();
                        Puntaje pts = new Puntaje();
                        String lenguajeSeleccionado=combo.getSelectedItem().toString();
                        lenguaje.setIdiomaSelecionado(lenguajeSeleccionado);
                        Game claseJuego = new Game(lenguaje,pts);
                        claseJuego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        claseJuego.setVisible(true);
                    }
                });
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Inicio thisClass = new Inicio();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }

}
