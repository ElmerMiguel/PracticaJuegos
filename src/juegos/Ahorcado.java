package juegos;

import java.util.Scanner;

public class Ahorcado {

    private static final String PALABRA_ADIVINAR = "PROGRAMACION";
    private static final int MAX_INTENTOS = 6;

    public static void jugar() {
        Scanner sc = new Scanner(System.in);
        char[] palabraAdivinada = new char[PALABRA_ADIVINAR.length()];
        int intentos = 0;

        // Inicializar la palabra adivinada con guiones bajos
        for (int i = 0; i < PALABRA_ADIVINAR.length(); i++) {
            palabraAdivinada[i] = '_';
        }

        while (intentos < MAX_INTENTOS) {
            // Mostrar la palabra actual con espacios entre letras
            System.out.println();
            for (char c : palabraAdivinada) {
                System.out.print(c + " ");
            }

            // Leer la letra ingresada por el usuario
            System.out.print("\nIngresa una letra: ");
            char letra = sc.next().toUpperCase().charAt(0);

            // Comprobar si la letra está en la palabra a adivinar
            boolean letraAdivinada = false;
            for (int i = 0; i < PALABRA_ADIVINAR.length(); i++) {
                if (PALABRA_ADIVINAR.charAt(i) == letra) {
                    palabraAdivinada[i] = letra;
                    letraAdivinada = true;
                }
            }

            // Si la letra no está en la palabra, aumentar el contador de intentos
            if (!letraAdivinada) {
                intentos++;
                dibujarAhorcado(intentos);
            }

            // Comprobar si se adivinó la palabra completa
            if (PALABRA_ADIVINAR.equals(new String(palabraAdivinada))) {
                System.out.println("\n¡Felicidades! Has adivinado la palabra: " + PALABRA_ADIVINAR);
                break;
            }
        }

        // Si se agotan los intentos, mostrar el mensaje de derrota
        if (intentos == MAX_INTENTOS) {
            System.out.println("\n¡Oh no! Has perdido. La palabra era: " + PALABRA_ADIVINAR);
        }

        
    }

    // Método para dibujar el ahorcado según el número de intentos
    private static void dibujarAhorcado(int intentos) {
        System.out.println("\nIntento " + intentos + " de " + MAX_INTENTOS);
        switch (intentos) {
            case 1:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                break;
            case 2:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                break;
            case 3:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println(" |   |");
                System.out.println("     |");
                System.out.println("     |");
                break;
            case 4:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|   |");
                System.out.println("     |");
                System.out.println("     |");
                break;
            case 5:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("     |");
                System.out.println("     |");
                break;
            case 6:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/    |");
                System.out.println("     |");
                System.out.println("Oh no! El ahorcado está completo...");
                break;
        }
    }
}
