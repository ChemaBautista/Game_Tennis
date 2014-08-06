/* @Rewrite by Ferbook */
package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class PanelPelota extends JPanel implements Runnable {

    
    private int pelotaX = 10, pelotaY = 100, jug1X = 10, jug1Y = 100, jug2X = 230, jug2Y = 100;
    Thread hilo;
    int derecha     = 5; 
    int izquierda   = -5; 
    int arriba      = 5; 
    int abajo       = -5; 
    int ancho, alto; 
    int contPlay1 = -1, contPlay2 = -1; 
    boolean player1FlagArr, player1FlagAba, player2FlagArr, player2FlagAba;
    boolean juego, gameOver;
    Idioma lenguaje;
    Puntaje pts;

    public PanelPelota(Idioma lenguaje,Puntaje pts) {
        this.lenguaje = lenguaje;
        this.pts = pts;
        juego   = true;
        hilo    = new Thread(this);
        hilo.start();
    }

    
    public void paintComponent(Graphics gc) {
        setOpaque(false);
        super.paintComponent(gc);
    
        gc.setColor(Color.black);
        gc.fillOval(pelotaX, pelotaY, 8, 8);
    
        gc.fillRect(jug1X, jug1Y, 10, 25);
        gc.fillRect(jug2X, jug2Y, 10, 25);
    
        gc.drawString(lenguaje.getTextoJugador1() + pts.getPuntaje1(), 25, 10);
        gc.drawString(lenguaje.getTextoJugador2() + pts.getPuntaje2(), 150, 10);

        if (gameOver) {gc.drawString(lenguaje.getTextoFin(), 60, 125);}
    }

    
    public void dibujarPelota(int nx, int ny) {
        pelotaX     = nx;
        pelotaY     = ny;
        this.ancho  = this.getWidth();
        this.alto   = this.getHeight();
        repaint();
    }

    // Aquí recibimos de la clase de contenedor juego la tecla pulsada.
    public void keyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            // Bandera barra 1 al presionadar telca W,S
            case KeyEvent.VK_W:player1FlagArr = true;break;
            case KeyEvent.VK_S:player1FlagAba = true;break;
            // Bandera barra 2 al presionadar telca Up,Down
            case KeyEvent.VK_UP:player2FlagArr = true;break;
            case KeyEvent.VK_DOWN:player2FlagAba = true;break;
        }
    }

    
    public void keyReleased(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            // Bandera barra 1 al liberar telca W,S
            case KeyEvent.VK_W:player1FlagArr = false;break;
            case KeyEvent.VK_S:player1FlagAba = false;break;
            // Bandera barra 2 al liberar telca Up,Down
            case KeyEvent.VK_UP:player2FlagArr = false;break;
            case KeyEvent.VK_DOWN:player2FlagAba = false;break;
        }
    }

    // Mover Jugador 1
    public void moverPlayer1() {
        if (player1FlagArr == true && jug1Y >= 0) {jug1Y += abajo;}
        if (player1FlagAba == true && jug1Y <= (this.getHeight() - 25)) {jug1Y += arriba;}
        dibujarPlayer1(jug1X, jug1Y);
    }

    // Mover Jugador 2
    public void moverPlayer2() {
        if (player2FlagArr == true && jug2Y >= 0) {jug2Y += abajo;}
        if (player2FlagAba == true && jug2Y <= (this.getHeight() - 25)) {jug2Y += arriba;}
        dibujarPlayer2(jug2X, jug2Y);
    }

    // Posicion X,Y Jugador 1
    public void dibujarPlayer1(int x, int y) {
        this.jug1X = x;
        this.jug1Y = y;
        repaint();
    }
    
    // Posicion X,Y Jugador 2
    public void dibujarPlayer2(int x, int y) {
        this.jug2X = x;
        this.jug2Y = y;
        repaint();
    }

    public void run() {
        boolean izqDer = false;
        boolean arrAba = false;

        while (true) {
            if (juego) {
                if (izqDer) { 
                    pelotaX += derecha;
                    if (pelotaX >= (ancho - 8)) {izqDer = false;}
                } else {
                    pelotaX += izquierda;
                    if (pelotaX <= 0) {izqDer = true;}
                }
                if (arrAba) {
                    pelotaY += arriba;
                    if (pelotaY >= (alto - 8)) {arrAba = false;}

                } else {
                    
                    pelotaY += abajo;
                    if (pelotaY <= 0) {arrAba = true;}
                }
                dibujarPelota(pelotaX, pelotaY);
                
                try {Thread.sleep(50);} catch (InterruptedException ex) {}

                moverPlayer1(); 
                moverPlayer2();

                // Incremento de Puntuacion Jugador 1
                if (pelotaX >= (ancho - 8)) {pts.setPuntaje1();}

                // Incremento de Puntuacion Jugador 2
                if (pelotaX == 0) {pts.setPuntaje2();}

                // Banderas para Determinar el Fin del Juego
                if (pts.getPuntaje1() == 10 || pts.getPuntaje2() == 10) {
                    juego    = false;
                    gameOver = true;
                }

                // La Pelota choca con la barra de Jugador 1
                if (pelotaX == jug1X + 10 && pelotaY >= jug1Y && pelotaY <= (jug1Y + 25)) {
                    izqDer = true;
                }

                // La Pelota choca con la barra de Jugador 2
                if (pelotaX == (jug2X - 5) && pelotaY >= jug2Y && pelotaY <= (jug2Y + 25)) {
                    izqDer = false;
                }
            }
        }
    }

}
