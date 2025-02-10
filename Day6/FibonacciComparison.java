
    public class FibonacciComparison {

        // Recursive Fibonacci
        public static int fibonacciRecursive(int n) {
            if (n <= 1) return n;
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }

        // Iterative Fibonacci
        public static int fibonacciIterative(int n) {
            int a = 0, b = 1, sum;
            for (int i = 2; i <= n; i++) {
                sum = a + b;
                a = b;
                b = sum;
            }
            return b;
        }

        public static void timeTakeForFibonacci(int n) {
            long startTime, endTime;

            // Recursive Fibonacci
            try {
                startTime = System.nanoTime();
                int fibRecursive = fibonacciRecursive(n);
                endTime = System.nanoTime();
                long frTime = endTime - startTime;
                double frTimeMs = frTime / 1_000_000.0;  // Convert nanoseconds to milliseconds
                System.out.println("Time taken by Recursive Fibonacci for N=" + n + ": " + frTimeMs + " milliseconds");
                System.out.println("Fibonacci result using Recursive: " + fibRecursive);
            } catch (Exception e) {
                System.err.println("Error with Recursive Fibonacci: " + e.getMessage());
            }

            // Iterative Fibonacci
            try {
                startTime = System.nanoTime();
                int fibIterative = fibonacciIterative(n);
                endTime = System.nanoTime();
                long isrTime = endTime - startTime;
                double isrTimeMs = isrTime / 1_000_000.0;  // Convert nanoseconds to milliseconds
                System.out.println("Time taken by Iterative Fibonacci for N=" + n + ": " + isrTimeMs + " milliseconds");
                System.out.println("Fibonacci result using Iterative: " + fibIterative);
            } catch (Exception e) {
                System.err.println("Error with Iterative Fibonacci: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            // Running Fibonacci computation for different values of N
            int[] sizes = {10, 30, 50};

            for (int n : sizes) {
                System.out.println("Comparing Fibonacci for N = " + n);
                timeTakeForFibonacci(n);
                System.out.println("---------------------------------------------------------");
            }
        }
    }

