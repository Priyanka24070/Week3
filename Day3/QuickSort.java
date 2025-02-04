import java.util.Arrays;

public class QuickSort {
    // Partition function to place the pivot at the correct position
    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // Choosing the last element as the pivot
        int i = low - 1; // Index for the smaller element

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) { // If current element is smaller than pivot
                i++;
                // Swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap pivot with the element at i+1 to place it in the correct position
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; // Return pivot index
    }

    // QuickSort recursive function
    private static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            // Recursively apply QuickSort on left and right partitions
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] productPrices = {500, 120, 700, 300, 450, 100};

        System.out.println("Original Product Prices: " + Arrays.toString(productPrices));
        quickSort(productPrices, 0, productPrices.length - 1);
        System.out.println("Sorted Product Prices: " + Arrays.toString(productPrices));
    }
}
