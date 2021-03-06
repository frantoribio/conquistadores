package models;

import java.util.Scanner;

public class Juego {

    private final int FILAS=3;
    private final int COLUMNAS=4;
    private final String [][] MAPA;
    private String recurso;

    public Juego() {
        int FILAS=this.FILAS;
        int COLUMNAS=this.COLUMNAS;
        this.MAPA = new String[FILAS][COLUMNAS];
    }

    public int tirarDado() {
        return (int)(Math.random()*6 + 1);
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
                    MAPA[i][j] = "{Casilla " + (i+1) + "-" + (j+1) + "  TRIGO " + tirarDado() + " -> ";
                    contadorTrigo++;
                }
                else if (recurso=="MADERA" && contadorMadera <= 3) {
                MAPA[i][j] = "{Casilla " + (i+1) + "-" + (j+1) + " MADERA " + tirarDado() + " -> ";
                contadorMadera++;
                }
                else if (recurso=="CARBON" && contadorCarbon <= 3) {
                MAPA[i][j] = "{Casilla " + (i+1) + "-" + (j+1) + " CARBON " + tirarDado() + " -> ";
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

    public void elegirCasillaHumano() {
        Scanner scanner = new Scanner(System.in);
        boolean ok;
        int elegirFila = 10;
        int elegirColumna = 10;
        do {
            System.out.println("\nIntroduce un n??mero de fila: ");
            try {
                elegirFila = scanner.nextInt()-1;
            }catch (Exception e){
                System.out.println("Introduce un entero");
                scanner.next();
            }
            System.out.println("\nIntroduce un n??mero de columna: ");
            try {
                elegirColumna = scanner.nextInt()-1;
            }catch (Exception e){
                System.out.println("Introduce un entero");
                scanner.next();}
            ok = verificarCasillaHumano(elegirFila,elegirColumna)&
                    comprobarRecursoHumano(elegirFila, elegirColumna);
        } while (!ok);
        ocuparCasillaHumano(elegirFila,elegirColumna);
    }

    private void ocuparCasillaHumano(int elegirFila, int elegirColumna) {
        for (String[] value : MAPA) {
            for (int j = 0; j < value.length; j++) {
            }
        }
        MAPA[elegirFila][elegirColumna] = MAPA[elegirFila][elegirColumna].concat("HUMANO} ");
        for (String[] strings : MAPA) {
            System.out.println();
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public boolean verificarCasillaHumano(int elegirFila, int elegirColumna) {
        boolean verificar = elegirFila > FILAS ||
                elegirColumna > COLUMNAS ||
                elegirFila == -1 || elegirColumna == -1;
        if (verificar) {
            System.out.println("Casilla incorrecta");
            return false;
        }else if (MAPA[elegirFila][elegirColumna].contains("PC") ||
                MAPA[elegirFila][elegirColumna].contains("HUMANO")) {
            System.out.println("Esta casilla est?? ocupada");
            return false;
        }else
            return true;
    }

    public boolean verificarCasillaPc(int filaRandom, int columnaRandom) {
        return !MAPA[filaRandom][columnaRandom].contains("PC") ||
                !MAPA[filaRandom][columnaRandom].contains("HUMANO");
    }

    public void elegirCasillaPc() {
        int filaRandom = (int)(Math.random()*3);
        int columnaRandom = (int)(Math.random()*4);
        if (verificarCasillaPc(filaRandom, columnaRandom)
                & comprobarRecursoPc(filaRandom,columnaRandom))
        System.out.println();
        System.out.println("Eligiendo el Pc.");
        ocuparCasillaPc(filaRandom,columnaRandom);
    }

    public void ocuparCasillaPc(int filaRandom, int columnaRandom) {
        for (String[] value : MAPA) {
            for (int j = 0; j < value.length; j++) {
            }
        }
        MAPA[filaRandom][columnaRandom] = MAPA[filaRandom][columnaRandom].concat("PC} ");
        for (String[] strings : MAPA) {
            System.out.println();
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public boolean comprobarRecursoPc(int filaRandom, int columnaRandom) {
        boolean ok = false;
        int casillaPcMadera = 0;
        int casillaPcCarbon = 0;
        int casillaPcTrigo = 0;
        for (String[] value : MAPA) {
            for (int j = 0; j < value.length; j++) {
                if (MAPA[filaRandom][columnaRandom].contains("PC")&
                        MAPA[filaRandom][columnaRandom].contains("TRIGO")){
                    casillaPcTrigo++;
                }
                else if (MAPA[filaRandom][columnaRandom].contains("PC")&
                        MAPA[filaRandom][columnaRandom].contains("MADERA")){
                    casillaPcMadera++;
                }else if (MAPA[filaRandom][columnaRandom].contains("PC")&
                        MAPA[filaRandom][columnaRandom].contains("CARBON"))
                    casillaPcCarbon++;
            }
        }
        if ((casillaPcTrigo > 2) || (casillaPcMadera > 2) || (casillaPcCarbon > 2 )){
            ok = false;
        } else ok = true;
        return ok;
    }

    public boolean comprobarRecursoHumano(int elegirFila, int elegirColumna) {
        boolean ok = false;
        int casillaHumanoMadera = 0;
        int casillaHumanoCarbon = 0;
        int casillaHumanoTrigo = 0;
        for (String[] value : MAPA) {
            for (int j = 0; j < value.length; j++) {
                if (MAPA[elegirFila][elegirColumna].contains("PC") &
                        MAPA[elegirFila][elegirColumna].contains("TRIGO")) {
                    casillaHumanoTrigo++;
                } else if (MAPA[elegirFila][elegirColumna].contains("PC") &
                        MAPA[elegirFila][elegirColumna].contains("MADERA")) {
                    casillaHumanoMadera++;
                } else if (MAPA[elegirFila][elegirColumna].contains("PC") &
                        MAPA[elegirFila][elegirColumna].contains("CARBON"))
                    casillaHumanoCarbon++;
            }
        }
        if ((casillaHumanoTrigo > 2) || (casillaHumanoMadera > 2) || (casillaHumanoCarbon > 2)) {
            ok = false;
            System.out.println("La elecci??n del recurso est?? completa, elige otro recurso");
        } else ok = true;
        return ok;
    }

}
