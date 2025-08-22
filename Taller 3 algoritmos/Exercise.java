import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Exercise {

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
        int[] copia = Arrays.copyOf(arr, arr.length); // evitar ordenar el mismo arreglo original
        long start = System.nanoTime(); // más preciso que currentTimeMillis
        bubbleSort(copia);
        long end = System.nanoTime();
        return (end - start) / 1_000_000; // convertir a milisegundos
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Generar arreglo aleatorio con valores de 1 a n
        int[] data = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = rand.nextInt(n) + 1; // rango [1, n]
        }

        // Ejecutar una sola vez y medir tiempo
        long duration = medirTiempo(data);
        System.out.println("Tiempo de ejecución: " + duration + " ms");

        System.out.println("Primeros 10 elementos generados: " +
                Arrays.toString(Arrays.copyOf(data, 10)));

        sc.close();
    }
}
