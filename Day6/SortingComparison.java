import java.util.Random;
    public class SortingComparison {

        // Bubble Sort (O(N²))
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

        // Merge Sort (O(N log N))
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

        // Quick Sort (O(N log N))
        public static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

        // Partition function for Quick Sort
        public static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }

        // Measure performance for different sorting algorithms
        public static void testSorting(int N) {
            Random rand = new Random();
            int[] arr = new int[N];

            // Fill array with random numbers
            for (int i = 0; i < N; i++) arr[i] = rand.nextInt();

            // Bubble Sort
            long start = System.nanoTime();
            bubbleSort(arr.clone());  // Clone to avoid sorting an already sorted array
            long end = System.nanoTime();
            System.out.println("Bubble Sort (N = " + N + "): " + (end - start) / 1e6 + "ms");

            // Merge Sort
            start = System.nanoTime();
            mergeSort(arr.clone());  // Clone to avoid sorting an already sorted array
            end = System.nanoTime();
            System.out.println("Merge Sort (N = " + N + "): " + (end - start) / 1e6 + "ms");

            // Quick Sort
            start = System.nanoTime();
            quickSort(arr.clone(), 0, arr.length - 1);  // Clone to avoid sorting an already sorted array
            end = System.nanoTime();
            System.out.println("Quick Sort (N = " + N + "): " + (end - start) / 1e6 + "ms");
        }

        public static void main(String[] args) {
            // Test for different dataset sizes
            int[] sizes = {1000, 10000, 1000000};
            for (int size : sizes)
                testSorting(size);
        }
    }

