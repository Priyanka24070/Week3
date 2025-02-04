import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1; // Range of ages (10 to 18)
        int[] count = new int[range]; // Count array to store frequencies
        int[] output = new int[ages.length]; // Output array for sorted ages

        // Step 1: Count occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in their correct positions
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted elements back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 18, 13, 12, 14, 11, 17, 16};

        System.out.println("Original Ages: " + Arrays.toString(studentAges));
        countingSort(studentAges, 10, 18);
        System.out.println("Sorted Ages: " + Arrays.toString(studentAges));
    }
}
