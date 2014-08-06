
package game;


public class Idioma {
    private String idiomaSelecionado = "";
    private String textoJugador1 = "";
    private String textoJugador2 = "";
    private String textoFin = "";
    private lenguaje opcion;
    
    public Idioma(){}
    
    public enum lenguaje { espaniol, ingles, japones};

    public void setIdiomaSelecionado(String idiomaSelecionado) {
        this.idiomaSelecionado = idiomaSelecionado;
        if(this.idiomaSelecionado.equals("Espaniol")){opcion = lenguaje.espaniol;}
        if(this.idiomaSelecionado.equals("Ingles")){opcion = lenguaje.ingles;}
        if(this.idiomaSelecionado.equals("Japones")){opcion = lenguaje.japones;}
    }

    public String getTextoJugador1() {
        switch(opcion){
            case espaniol:textoJugador1 = "JUGADOR 1:";break;
            case ingles:textoJugador1 = "PLAYER 1:";break;
            case japones:textoJugador1 = "プレーヤー 1:";break;
        }
        return textoJugador1;
    }

    public String getTextoJugador2() {
        switch(opcion){
            case espaniol:textoJugador2 = "JUGADOR 2:";break;
            case ingles:textoJugador2 = "PLAYER 2:";break;
            case japones:textoJugador2 = "プレーヤー 2:";break;
        }
        return textoJugador2;
    }

    public String getTextoFin() {
        switch(opcion){
            case espaniol:textoFin = "-- JUEGO TERMINADO --";break;
            case ingles:textoFin = "-- GAME OVER --";break;
            case japones:textoFin = "-- ゲームオーバー --";break;
        }
        return textoFin;
    }
    
    
    
}
