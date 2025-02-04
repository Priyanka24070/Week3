import java.io.*;

public class PerformanceComparison {

    public static void main(String[] args) {
        // Task 1: StringBuilder and StringBuffer Concatenation
        String str = "hello";  // String to concatenate
        int iterations = 1000000;  // Number of concatenations
        
        // Measure time for StringBuilder
        long startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(str);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) + " ms");

        // Measure time for StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(str);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) + " ms");

        // Task 2: FileReader to read and count words in a large file
        String filePath = "D:/Week3/Day4/ChallengeProblem2/extext.txt";  // Specify the path to your large text file
        File file = new File(filePath);
        
        if (file.exists() && file.length() > 0) {
            // Read the large file and count words
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
                 
                long wordCount = 0;
                String line;
                
                // Measure time for reading the file and counting words
                startTime = System.currentTimeMillis();
                while ((line = bufferedReader.readLine()) != null) {
                    // Split the line into words and count them
                    String[] words = line.split("\\s+");
                    wordCount += words.length;
                }
                endTime = System.currentTimeMillis();
                
                System.out.println("Word count: " + wordCount);
                System.out.println("Time taken to read and count words: " + (endTime - startTime) + " ms");
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist or is empty.");
        }
    }
}

