public class RotationPoint {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > arr[right]) {
                // Smallest element is in the right half
                left = mid + 1;
            } else {
                // Smallest element is in the left half (including mid)
                right = mid;
            }
        }
        
        return left; // Index of the smallest element (rotation point)
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int rotationIndex = findRotationPoint(arr);
        System.out.println("Rotation point index: " + rotationIndex);
    }
}
