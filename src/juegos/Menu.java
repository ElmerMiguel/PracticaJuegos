
package juegos;
import java.util.Scanner;
import java.util.Random;
import juegos.Carta;

// @author Elmer
public class Menu {
    
    public static void main(String[] args) {
        Carta juegocarta = new Carta();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("------ MENU DE JUEGOS ------");
            System.out.println("1. Juego del Ahorcado");
            System.out.println("2. Juego de Basketball");
            System.out.println("3. Juego de Cartas");
            System.out.println("0. Salir");
            System.out.print("Ingresa el número del juego al que deseas jugar: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    jugarAhorcado();
                    break;
                case 2:
                    jugarBasketball();
                    break;
                case 3:
                    juegocarta.juego();
                    break;
                case 0:
                    System.out.println("Gracias por jugar. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
            
            System.out.println();
        } while (opcion != 0);
        
        scanner.close();
    }

    // Implementa aquí la función para el juego del Ahorcado (Juego 1)
    public static void jugarAhorcado() {
        // Tu código para el juego del Ahorcado
    }

    // Implementa aquí la función para el juego de Basketball (Juego 2)
    public static void jugarBasketball() {
        // Tu código para el juego de Basketball
    }

    // Implementa aquí la función para el juego de Cartas (Juego 3)
    public static void jugarJuegoCartas() {
        // Tu código para el juego de Cartas
        
        
    }
}
