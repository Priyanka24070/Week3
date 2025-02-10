import java.util.Random;
    public class SearchComparison {

        // Linear Search
        public static int linSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) return i;
            }
            return -1;
        }

        // Binary Search
        public static int binSearch(int[] arr, int target) {
            int l = 0, r = arr.length - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (arr[m] == target) return m;
                if (arr[m] < target) l = m + 1;
                else r = m - 1;
            }
            return -1;
        }

        // Merge Sort
        public static void mergeSort(int[] arr) {
            if (arr.length < 2) return;
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];

            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, arr.length - mid);

            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }

        // Merge function for mergeSort
        public static void merge(int[] arr, int[] left, int[] right) {
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }
            while (i < left.length) arr[k++] = left[i++];
            while (j < right.length) arr[k++] = right[j++];
        }

        // Measure performance
        public static void test(int N) {
            Random rand = new Random();
            int[] arr = new int[N];

            // Fill array with random numbers
            for (int i = 0; i < N; i++) arr[i] = rand.nextInt();

            // Linear Search
            long start = System.nanoTime();
            int target = rand.nextInt();
            linSearch(arr, target);
            long end = System.nanoTime();
            System.out.println("Linear (N = " + N + "): " + (end - start) / 1e6 + "ms");

            // Merge Sort and Binary Search
            mergeSort(arr);
            start = System.nanoTime();
            binSearch(arr, target);
            end = System.nanoTime();
            System.out.println("Binary (N = " + N + "): " + (end - start) / 1e6 + "ms");
        }

        public static void main(String[] args) {
            // Test for different sizes
            int[] sizes = {1000, 10000, 1000000};
            for (int size : sizes) test(size);
        }
    }

