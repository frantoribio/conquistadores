package models;

import java.util.Scanner;

public class Juego {

    private final int FILAS=3;
    private final int COLUMNAS=4;
    private final String [][] MAPA;
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
                    MAPA[i][j] = "{Casilla " + (i+1) + "-" + (j+1) + "  TRIGO " + tirarDado() + " ";
                    contadorTrigo++;
                }
                else if (recurso=="MADERA" && contadorMadera <= 3) {
                MAPA[i][j] = "{Casilla " + (i+1) + "-" + (j+1) + " MADERA " + tirarDado() + " ";
                contadorMadera++;
                }
                else if (recurso=="CARBON" && contadorCarbon <= 3) {
                MAPA[i][j] = "{Casilla " + (i+1) + "-" + (j+1) + " CARBON " + tirarDado() + " ";
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


    public void elegirCasilla() {
        Scanner scanner = new Scanner(System.in);
        boolean ok;
        int elegirFila=10;
        int elegirColumna=10;

        do {
            System.out.println("\nIntroduce un número de fila: ");
            try {
                elegirFila = scanner.nextInt()-1;
            }catch (Exception e){
                System.out.println("Introduce un entero");
                scanner.next();
            }
            System.out.println("\nIntroduce un número de columna: ");
            try {
                elegirColumna = scanner.nextInt()-1;
            }catch (Exception e){
                System.out.println("Introduce un entero");
                scanner.next();}
            ok = verificarCasilla(elegirFila,elegirColumna);
        } while (!ok);

        ocuparCasillaHumano(elegirFila,elegirColumna);

    }

    private void ocuparCasillaHumano(int elegirFila, int elegirColumna) {
        for (int i = 0; i < MAPA.length; i++) {
            for (int j= 0; j < MAPA[i].length; j++) {
            }
        }
        MAPA[elegirFila][elegirColumna]=MAPA[elegirFila][elegirColumna].concat("HUMANO} ");
        for (int i = 0; i < MAPA.length; i++) {
            System.out.println();
            for (int j = 0; j < MAPA[i].length; j++) {
                System.out.print(MAPA[i][j]);
            }
            System.out.println();
        }
    }

    public boolean verificarCasilla(int elegirFila, int elegirColumna) {
        boolean verificar = elegirFila > FILAS ||
                elegirColumna > COLUMNAS ||
                elegirFila == -1 || elegirColumna == -1;
        if (verificar) {
            System.out.println("Casilla incorrecta");
            return false;
        }else if (MAPA[elegirFila][elegirColumna].contains("PC HUMANO" )) {
            System.out.println("Esta casilla está ocupado");
            return false;
        }else
            return true;
    }
}
