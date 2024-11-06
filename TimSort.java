import java.util.Arrays;

public class TimSort {
    private static final int RUN = 32;

    public static void timSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min((i + RUN - 1), (n - 1)));
        }

        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1, len2 = right - mid;
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        for (int x = 0; x < len1; x++) leftArr[x] = arr[left + x];
        for (int x = 0; x < len2; x++) rightArr[x] = arr[mid + 1 + x];

        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < len1) arr[k++] = leftArr[i++];
        while (j < len2) arr[k++] = rightArr[j++];
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(100000);
        System.out.println("Tableau initial : " + Arrays.toString(array));

        long startTime = System.nanoTime();
        timSort(array);
        long duration = System.nanoTime() - startTime;

        System.out.println("Tableau trie (Tim Sort) : " + Arrays.toString(array));
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
