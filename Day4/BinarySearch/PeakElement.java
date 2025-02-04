public class PeakElement {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > arr[mid + 1]) {
                // Peak element is in the left half (including mid)
                right = mid;
            } else {
                // Peak element is in the right half
                left = mid + 1;
            }
        }
        
        return left; // Index of a peak element
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element index: " + peakIndex);
    }
}
