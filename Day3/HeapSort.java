import java.util.Arrays;

public class HeapSort {
    // Function to build a max heap
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize the largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than the largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If the largest is not the root, swap and heapify the affected subtree
        if (largest != i) {
            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Function to perform Heap Sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build max heap (rearrange the array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (largest element) with the last element
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] salaryDemands = {50000, 70000, 45000, 90000, 60000, 55000};

        System.out.println("Original Salary Demands: " + Arrays.toString(salaryDemands));
        heapSort(salaryDemands);
        System.out.println("Sorted Salary Demands: " + Arrays.toString(salaryDemands));
    }
}
