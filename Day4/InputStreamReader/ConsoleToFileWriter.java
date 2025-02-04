import java.io.*;

public class ConsoleToFileWriter {
    public static void main(String[] args) {
        // Create a BufferedReader to read from the console (System.in)
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        
        // Create a FileWriter to write to a file (you can specify the file path here)
        String filePath = "D:/Week3/Day4/FileReader/example.txt"; // specify your desired file path
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            
            String userInput;
            System.out.println("Enter text to write to the file. Type 'exit' to stop.");

            // Keep reading user input until they enter 'exit'
            while (true) {
                // Read the user input from the console
                userInput = consoleReader.readLine();
                
                // If user types "exit", stop the input
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }
                
                // Write the input to the file as a new line
                fileWriter.write(userInput);
                fileWriter.newLine();
            }
            
            System.out.println("Input saved to the file successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                consoleReader.close(); // Close the console reader
            } catch (IOException e) {
                System.err.println("Error closing console reader: " + e.getMessage());
            }
        }
    }
}
