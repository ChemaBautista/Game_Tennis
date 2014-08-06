/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

public class Puntaje {
    private int puntaje1 = -1;
    private int puntaje2 = -1;

    public Puntaje() {
    }

    public void setPuntaje1() {
        this.puntaje1++;
    }

    public void setPuntaje2() {
        this.puntaje2++;
    }

    public int getPuntaje1() {
        return puntaje1;
    }

    public int getPuntaje2() {
        return puntaje2;
    }
}
