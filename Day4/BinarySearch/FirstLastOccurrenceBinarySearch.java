public class FirstLastOccurrenceBinarySearch {
    public static int[] findFirstLast(int[] arr, int target) {
        int first = findOccurrence(arr, target, true);
        int last = findOccurrence(arr, target, false);
        return new int[]{first, last};
    }
    
    private static int findOccurrence(int[] arr, int target, boolean findFirst) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                if (findFirst) {
                    right = mid - 1; // Search left half
                } else {
                    left = mid + 1; // Search right half
                }
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int[] result = findFirstLast(arr, target);
        System.out.println("First occurrence: " + result[0] + ", Last occurrence: " + result[1]);
    }
}
