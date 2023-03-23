package org.example.Practica1.mates;




public class Matematicas {
    /**
     * Genera una aproximación al número pi mediante el método de Montecarlo.
     * El parámetro ‘pasos‘ indica el número de puntos generado.
     */
    public static double generarNumeroPi(long pasos) {
        double aciertos = 0;
        double areaCuadrado = 4;

        for (long i = 0; i < pasos; i++) {
            double x = Math.random() * 2 - 1; // Genera un número aleatorio entre -1 y 1
            double y = Math.random() * 2 - 1; // Genera un número aleatorio entre -1 y 1

            if (Math.sqrt(x * x + y * y) <= 1) { // Comprueba si el punto está dentro del círculo del radio definido
                aciertos++;
            }
        }

        return areaCuadrado * (aciertos / pasos);
    }

}

