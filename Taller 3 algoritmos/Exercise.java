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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] data = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            data[i] = rand.nextInt(1000);
        }

        long startTime = System.currentTimeMillis(); // Inicia el contador

        bubbleSort(data);

        long endTime = System.currentTimeMillis(); // Termina el contador
        long duration = endTime - startTime; // Calcula el tiempo en milisegundos

        // Muestra los primeros 10 elementos del arreglo ordenado
        System.out.println(Arrays.toString(Arrays.copyOf(data, 10)));
        System.out.println("Tiempo de ejecución: " + duration + " ms");

        sc.close();
    }
}