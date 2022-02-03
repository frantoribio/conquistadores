package models;

public class Juego {

    final private int FILAS=3;
    final private int COLUMNAS=4;
    public final String [][] MAPA;
    private String recurso;

    public Juego() {
        int FILAS=3;
        int COLUMNAS=4;
        this.MAPA = new String[FILAS][COLUMNAS];
    }

    public int tirarDado() {
        int resultadoDado = (int)(Math.random()*6 +1);
        return resultadoDado;
    }
    public String recursoCasilla(){
        int numeroRandom = (int)(Math.random()*3+1);
        if (numeroRandom == 1) {
            recurso = "TRIGO";
        } else if (numeroRandom == 2){
            recurso = "MADERA";
        } else recurso = "CARBON";
        return recurso;
    }

    public void llenarMapa() {
        for (int i = 0; i < MAPA.length; i++) {
            for (int j= 0; j < MAPA[i].length; j++) {
                recursoCasilla();
                int contadorTrigo = 0;
                int contadorMadera = 0;
                int contadorCarbon = 0;
                if (recurso=="TRIGO" && contadorTrigo <= 3) {
                    MAPA[i][j] = "{Casilla " + (i+1) + "-" + (j+1) + "  TRIGO " + tirarDado() + "} ";
                    contadorTrigo++;
                }
                else if (recurso=="MADERA" && contadorMadera <= 3) {
                MAPA[i][j] = "{Casilla " + (i+1) + "-" + (j+1) + " MADERA " + tirarDado() + "} ";
                contadorMadera++;
                }
                else if (recurso=="CARBON" && contadorCarbon <= 3) {
                MAPA[i][j] = "{Casilla " + (i+1) + "-" + (j+1) + " CARBON " + tirarDado() + "} ";
                contadorCarbon++;
                }
            }
        }
    }
    public void imprimirMapa(){
        llenarMapa();
        for (int i = 0; i < MAPA.length; i++) {
            System.out.println();
            for (int j = 0; j < MAPA[i].length; j++){
                System.out.print(MAPA[i][j]);
            }
            System.out.println();
        }
    }
    public void elegirCasilla(){
        System.out.println("¿Qué casilla quieres ocupar?");

    }
}
