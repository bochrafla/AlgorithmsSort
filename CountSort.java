import java.util.Arrays;
import java.util.Random;

public class CountSort {
    public static int[] countSort(int[] inputArray) {
        int N = inputArray.length;
        int M = 0;

        // Find the maximum value in the array to define the range
        for (int i = 0; i < N; i++) {
            M = Math.max(M, inputArray[i]);
        }

        // Initialize the count array
        int[] countArray = new int[M + 1];

        // Count each number in inputArray
        for (int i = 0; i < N; i++) {
            countArray[inputArray[i]]++;
        }

        // Update countArray to contain positions
        for (int i = 1; i <= M; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Sort the array
        int[] outputArray = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }

        return outputArray;
    }

    public static void main(String[] args) {
        // Generate a random array of size 10 with values between 0 and 9
        int[] inputArray = generateRandomArray(100000);
        System.out.println("Original array: " + Arrays.toString(inputArray));

        // Measure the execution time
        long startTime = System.nanoTime();
        int[] outputArray = countSort(inputArray);
        long duration = System.nanoTime() - startTime;

        // Output the sorted array and the execution time
        System.out.println("Sorted array (CountingSort): " + Arrays.toString(outputArray));
        System.out.println("Execution time: " + duration + " ns");
    }

    // Helper method to generate a random array of integers between 0 and 9
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10); // Random integers between 0 and 9
        }
        return arr;
    }
}
