
package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {
    private JPanel jContentPane = null;
    private PanelPelota panel   = null; 

    private PanelPelota getPanel(Idioma lenguaje,Puntaje pts) {
        if (panel == null) {
            panel = new PanelPelota(lenguaje,pts); 
        }
        return panel;
    }

    /* Constructor */
    public Game(Idioma lenguaje,Puntaje pts) {
        super();
        initialize(lenguaje,pts);
       
        this.addKeyListener(new KeyAdapter() {
         
            public void keyPressed(KeyEvent evt) {
                formKeyPressed(evt);
            }
        
            public void keyReleased(KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
    }

    
    private void formKeyPressed(KeyEvent evt) {
        panel.keyPressed(evt);
    }

    
    private void formKeyReleased(KeyEvent evt) {
        panel.keyReleased(evt);
    }

    
    private void initialize(Idioma lenguaje,Puntaje pts) {
        this.setResizable(false);
        this.setBounds(new Rectangle(312, 184, 250, 250));
        this.setMinimumSize(new Dimension(250, 250));
        this.setMaximumSize(new Dimension(250, 250));
        this.setContentPane(getJContentPane(lenguaje,pts));
        this.setTitle("Juego Tenis");
    }

    
    private JPanel getJContentPane(Idioma lenguaje,Puntaje pts) {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getPanel(lenguaje,pts), BorderLayout.CENTER);
        }
        return jContentPane;
    }

}
