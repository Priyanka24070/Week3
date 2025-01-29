class CircularTour {
    public static int findStartingPump(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalSurplus = 0, currentSurplus = 0, start = 0;

        for (int i = 0; i < n; i++) {
            totalSurplus += petrol[i] - distance[i];
            currentSurplus += petrol[i] - distance[i];

            // If we run out of fuel, reset start position
            if (currentSurplus < 0) {
                start = i + 1; // Start from the next pump
                currentSurplus = 0; // Reset current surplus
            }
        }

        // If total petrol is less than total distance, return -1 (not possible)
        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startIndex = findStartingPump(petrol, distance);
        System.out.println("Starting Petrol Pump Index: " + startIndex);
    }
}
