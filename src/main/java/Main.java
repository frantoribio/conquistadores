import models.Juego;
import models.Jugador;

public class Main {
    public static void main(String[] args) {
        Juego catan = new Juego();
        Jugador pc = new Jugador();
        Jugador humano = new Jugador();

        catan.llenarMapa();
        catan.imprimirMapa();


    }
}
