package org.example.Practica2.dominio;

public class Tablero {
    private static int DIMENSION = 30;
    private int[][] estadoActual;
    private int[][] estadoSiguiente = new int[DIMENSION][DIMENSION];

    public void leerEstadoActual() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                System.out.println(estadoActual);
            }
        }
    }


    public void generarEstadoActualPorMontecarlo() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    public void transitarAlEstadoSiguiente() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoSiguiente[i][j] = estadoActual[i][j];
            }
        }
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                int vecinosVivos = 0;
                if (i > 0 && j > 0 && estadoActual[i - 1][j - 1] == 1) {
                    vecinosVivos++;
                }
                if (i > 0 && estadoActual[i - 1][j] == 1) {
                    vecinosVivos++;
                }
                if (i > 0 && j < DIMENSION - 1 && estadoActual[i - 1][j + 1] == 1) {
                    vecinosVivos++;
                }
                if (j > 0 && estadoActual[i][j - 1] == 1) {
                    vecinosVivos++;
                }
                if (j < DIMENSION - 1 && estadoActual[i][j + 1] == 1) {
                    vecinosVivos++;
                }
                if (i < DIMENSION - 1 && j > 0 && estadoActual[i + 1][j - 1] == 1) {
                    vecinosVivos++;
                }
                if (i < DIMENSION - 1 && estadoActual[i + 1][j] == 1) {
                    vecinosVivos++;
                }
                if (i < DIMENSION - 1 && j < DIMENSION - 1 && estadoActual[i + 1][j + 1] == 1) {
                    vecinosVivos++;
                }
                if (estadoActual[i][j] == 1) {
                    if (vecinosVivos < 2 || vecinosVivos > 3) {
                        estadoSiguiente[i][j] = 0;
                    }
                } else {
                    if (vecinosVivos == 3) {
                        estadoSiguiente[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i][j] = estadoSiguiente[i][j];

            }
            }
        }

    @Override
    public String toString () {
        String tablero = "";
        return tablero;
    }
}



