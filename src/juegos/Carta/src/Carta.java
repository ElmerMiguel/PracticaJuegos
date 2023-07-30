import java.util.Scanner;
import java.util.Random;

public class Carta {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("¡Bienvenido al juego de apuestas con cartas en el casino!");
        System.out.print("Ingresa la cantidad de dinero con la que cuentas: ");
        int dinero = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer de entrada

        while (dinero > 0) {
            System.out.println("\nTienes $" + dinero + " en tu cuenta.");
            System.out.println("¿Cuánto dinero deseas apostar en este turno?");
            System.out.print("Ingresa la cantidad: ");
            int apuesta = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer de entrada

            if (apuesta <= 0 || apuesta > dinero) {
                System.out.println("¡La apuesta debe ser mayor que 0 y no exceder la cantidad de dinero disponible!");
                continue;
            }

            int carta1 = random.nextInt(13) + 1; // Carta aleatoria del 1 al 13
            int carta2 = random.nextInt(13) + 1; // Carta aleatoria del 1 al 13

            System.out.println("Cartas presentadas: " + carta1 + " y " + carta2);

            // Calcular probabilidades
            double probabilidadSuperior = (carta1 < carta2) ? (double) (carta2 - carta1) / 13.0 : (double) (13 - carta1 + carta2) / 13.0;
            double probabilidadInferior = 1.0 - probabilidadSuperior;

            System.out.println("Probabilidad de que la siguiente carta esté entre las cartas presentadas:");
            System.out.println("Superior: " + (probabilidadSuperior * 100) + "%");
            System.out.println("Inferior: " + (probabilidadInferior * 100) + "%");

            int cartaSiguiente = random.nextInt(13) + 1; // Carta aleatoria del 1 al 13

            System.out.println("La siguiente carta es: " + cartaSiguiente);

            if ((cartaSiguiente > carta1 && cartaSiguiente < carta2) || (cartaSiguiente < carta1 && cartaSiguiente > carta2)) {
                dinero += apuesta;
                System.out.println("¡Felicidades! Has ganado $" + apuesta + " en este turno.");
            } else {
                dinero -= apuesta;
                System.out.println("Lo siento, has perdido $" + apuesta + " en este turno.");
            }
        }

        System.out.println("\nTe has quedado sin dinero. El juego ha terminado.");
        sc.close();
    }
}

