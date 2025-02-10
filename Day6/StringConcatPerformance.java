public class StringConcatPerformance {

        public static void main(String[] args) {
            int[] counts = {1000, 10000, 1000000};

            for (int count : counts) {
                System.out.println("Testing with " + count + " concatenations...");
                testStringConcatenation(count);
                testStringBuilderConcatenation(count);
                testStringBufferConcatenation(count);
                System.out.println();
            }
        }

        // Function to test String concatenation (O(N²))
        private static void testStringConcatenation(int count) {
            long start = System.nanoTime();
            String str = "";
            for (int i = 0; i < count; i++) str += "a";
            long timeTaken = (System.nanoTime() - start) / 1000000; // Convert to milliseconds
            System.out.println("String concat time: " + timeTaken + "ms");
        }

        // Function to test StringBuilder concatenation (O(N))
        private static void testStringBuilderConcatenation(int count) {
            long start = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) sb.append("a");
            long timeTaken = (System.nanoTime() - start) / 1000000; // Convert to milliseconds
            System.out.println("StringBuilder time: " + timeTaken + "ms");
        }

        // Function to test StringBuffer concatenation (O(N))
        private static void testStringBufferConcatenation(int count) {
            long start = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < count; i++) sbf.append("a");
            long timeTaken = (System.nanoTime() - start) / 1000000; // Convert to milliseconds
            System.out.println("StringBuffer time: " + timeTaken + "ms");
        }
    }

