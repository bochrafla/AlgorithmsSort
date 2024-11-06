

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(100000);
        System.out.println("Tableau initial : " + Arrays.toString(array));
        
        // Mesurer le temps d'exécution du tri
        long startTime = System.nanoTime();
        bubbleSort(array);
        long duration = System.nanoTime() - startTime;

        System.out.println("Tableau trie (BubbleSort) : " + Arrays.toString(array));
        System.out.println("Temps d'exécution : " + duration + " ns");
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 10); // Valeurs entre 0 et 9
        }
        return arr;
    }
}
