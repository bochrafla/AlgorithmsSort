

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] array = generateRandomArray(100000);
        System.out.println("Tableau initial : " + Arrays.toString(array));
        
        // Mesurer le temps d'exécution du tri
        long startTime = System.nanoTime();
        insertionSort(array);
        long duration = System.nanoTime() - startTime;

        System.out.println("Tableau trie(InsertionSort) : " + Arrays.toString(array));
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