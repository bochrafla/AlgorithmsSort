

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Diviser et trier chaque moitié
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Fusionner les deux moitiés
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, middle + 1, rightArray, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(100000);
        System.out.println("Tableau initial : " + Arrays.toString(array));

        long startTime = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        long duration = System.nanoTime() - startTime;

        System.out.println("Tableau trie (Merge Sort) : " + Arrays.toString(array));
        System.out.println("Temps d'execution : " + duration + " ns");
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 10); // Valeurs entre 0 et 9
        }
        return arr;
    }
}
