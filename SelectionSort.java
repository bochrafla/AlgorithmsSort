import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Trouver l'index du minimum dans la partie non triée
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Échanger le minimum avec le premier élément non trié
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(100000);
        System.out.println("Tableau initial : " + Arrays.toString(array));

        // Mesurer le temps d'exécution du tri
        long startTime = System.nanoTime();
        selectionSort(array);
        long duration = System.nanoTime() - startTime;

        System.out.println("Tableau trie (Selection Sort) : " + Arrays.toString(array));
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
