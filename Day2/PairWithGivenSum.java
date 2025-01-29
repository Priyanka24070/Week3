import java.util.HashSet;

public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> seen = new HashSet<>(); // Stores visited numbers

        for (int num : arr) {
            int complement = target - num; // Find the required pair value

            if (seen.contains(complement)) {
                return true; // Pair found
            }

            seen.add(num); // Store the current number
        }

        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        boolean result = hasPairWithSum(arr, target);
        System.out.println("Pair exists: " + result);
    }
}
