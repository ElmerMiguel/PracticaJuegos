package juegos;

import java.util.Random;
import java.util.Scanner;

public class Basketball {

    private static final int TIROS_LARGOS_PUNTOS = 3;
    private static final double PROBABILIDAD_TIROS_LARGOS = 0.65;
    private static final int TIROS_CORTOS_PUNTOS = 2;
    private static final double PROBABILIDAD_TIROS_CORTOS = 0.80;
    private static final int TIROS_LIBRES_PUNTOS = 2;
    private static final double PROBABILIDAD_TIROS_LIBRES = 0.90;

    private static final double REDUCCION_PROBABILIDAD_DEFENSA_CUERPO = 0.15;
    private static final double PROBABILIDAD_FALTA_DEFENSA_CUERPO = 0.35;
    private static final double REDUCCION_PROBABILIDAD_DEFENSA_FUERTE = 0.30;
    private static final double PROBABILIDAD_FALTA_DEFENSA_FUERTE = 0.65;

    public static void jugar() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("¡Bienvenido al juego de baloncesto uno a uno!");
        System.out.print("Ingresa el nombre del primer jugador: ");
        String jugador1 = sc.nextLine();
        System.out.print("Ingresa el nombre del segundo jugador: ");
        String jugador2 = sc.nextLine();
        System.out.print("Ingresa la cantidad de turnos que tendrá el juego: ");
        int cantidadTurnos = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer de entrada

        // Calcular quién inicia el juego
        String jugadorActual = random.nextBoolean() ? jugador1 : jugador2;
        String jugadorSiguiente = (jugadorActual.equals(jugador1)) ? jugador2 : jugador1;

        int puntajeJugador1 = 0;
        int puntajeJugador2 = 0;

        System.out.println("\nComienza el juego!\n");

        for (int turno = 1; turno <= cantidadTurnos; turno++) {
            System.out.println("Turno " + turno + ": " + jugadorActual + " vs " + jugadorSiguiente);
            System.out.println("Es el turno de " + jugadorActual);

            // Realizar la acción del jugador actual
            int resultadoTurno = 0;
            int accion = elegirAccion(sc);

            if (accion == 1) {
                resultadoTurno = realizarTiroLargo(random) ? TIROS_LARGOS_PUNTOS : 0;
            } else if (accion == 2) {
                resultadoTurno = realizarTiroCorto(random) ? TIROS_CORTOS_PUNTOS : 0;
            } else if (accion == 3) {
                resultadoTurno = realizarTiroLibre(random) ? TIROS_LIBRES_PUNTOS : 0;
            } else if (accion == 4) {
                defensaCuerpoACuerpo(random, jugadorSiguiente);
            } else if (accion == 5) {
                defensaFuerte(random, jugadorSiguiente);
            }

            // Sumar puntos al jugador actual
            if (jugadorActual.equals(jugador1)) {
                puntajeJugador1 += resultadoTurno;
            } else {
                puntajeJugador2 += resultadoTurno;
            }

            // Cambiar el turno al siguiente jugador
            String temp = jugadorActual;
            jugadorActual = jugadorSiguiente;
            jugadorSiguiente = temp;

            System.out.println();
        }

        // Mostrar resultados y determinar al ganador
        System.out.println("\nFin del juego!");
        System.out.println(jugador1 + ": " + puntajeJugador1 + " puntos");
        System.out.println(jugador2 + ": " + puntajeJugador2 + " puntos");

        if (puntajeJugador1 > puntajeJugador2) {
            System.out.println("¡" + jugador1 + " es el ganador!");
        } else if (puntajeJugador1 < puntajeJugador2) {
            System.out.println("¡" + jugador2 + " es el ganador!");
        } else {
            System.out.println("¡Es un empate!");
        }

        
    }

    private static int elegirAccion(Scanner sc) {
        System.out.println("Elige una acción para este turno:");
        System.out.println("1. Salto largo desde 5 metros (3 puntos)");
        System.out.println("2. Salto corto desde 3 metros (2 puntos)");
        System.out.println("3. Tiro libre (2 puntos)");
        System.out.println("4. Defensa cuerpo a cuerpo");
        System.out.println("5. Defensa fuerte");
        System.out.print("Ingresa el número de la acción: ");
        return sc.nextInt();
    }

    private static boolean realizarTiroLargo(Random random) {
        return random.nextDouble() < PROBABILIDAD_TIROS_LARGOS;
    }

    private static boolean realizarTiroCorto(Random random) {
        return random.nextDouble() < PROBABILIDAD_TIROS_CORTOS;
    }

    private static boolean realizarTiroLibre(Random random) {
        return random.nextDouble() < PROBABILIDAD_TIROS_LIBRES;
    }

    private static void defensaCuerpoACuerpo(Random random, String jugadorOfensivo) {
        System.out.println("¡Buena defensa cuerpo a cuerpo!");
        double reduccionProbabilidad = REDUCCION_PROBABILIDAD_DEFENSA_CUERPO;
        double probabilidadFalta = PROBABILIDAD_FALTA_DEFENSA_CUERPO;
        realizarFalta(random, jugadorOfensivo, reduccionProbabilidad, probabilidadFalta);
    }

    private static void defensaFuerte(Random random, String jugadorOfensivo) {
        System.out.println("¡Buena defensa fuerte!");
        double reduccionProbabilidad = REDUCCION_PROBABILIDAD_DEFENSA_FUERTE;
        double probabilidadFalta = PROBABILIDAD_FALTA_DEFENSA_FUERTE;
        realizarFalta(random, jugadorOfensivo, reduccionProbabilidad, probabilidadFalta);
    }

    private static void realizarFalta(Random random, String jugadorOfensivo, double reduccionProbabilidad, double probabilidadFalta) {
        if (random.nextDouble() < probabilidadFalta) {
            System.out.println("Falta cometida por " + jugadorOfensivo);
            if (realizarTiroLibre(random)) {
                System.out.println("El tiro libre fue exitoso (+2 puntos).");
            } else {
                System.out.println("El tiro libre fue fallado.");
            }
        } else {
            System.out.println("No se cometió falta.");
        }
    }
}
