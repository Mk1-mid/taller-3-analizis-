import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Algoritmo: Bubble Sort
 * Complejidad temporal: O(n^2)
 * Operación dominante: comparaciones e intercambios dentro del doble for
 * Complejidad espacial: O(1) (usa solo variables auxiliares)
 */
public class Exercise {

    // Algoritmo Bubble Sort
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Método para medir tiempos de ejecución
    public static long medirTiempo(int[] arr) {
        int[] copia = Arrays.copyOf(arr, arr.length); // evitar ordenar el mismo arreglo
        long start = System.nanoTime(); // más preciso que currentTimeMillis
        bubbleSort(copia);
        long end = System.nanoTime();
        return (end - start) / 1_000_000; // convertir a milisegundos
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Generar arreglo aleatorio
        int[] data = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = rand.nextInt(1000);
        }

        // Ejecutar una sola vez
        long duration = medirTiempo(data);
        System.out.println("Tiempo de ejecución: " + duration + " ms");

        // Mostrar los primeros 10 elementos ordenados
        int[] copySorted = Arrays.copyOf(data, data.length);
        bubbleSort(copySorted);
        System.out.println("Primeros 10 elementos ordenados: " +
                Arrays.toString(Arrays.copyOf(copySorted, 10)));

        sc.close();
    }
}
