import java.io.*;

public class ReadBinaryDataAsCharacters {
    public static void main(String[] args) {
        // Specify the file path and charset to read the binary data as characters.
        String filePath = "D:/Week3/Day4/FileReader/example.txt";
        String charset = "UTF-8"; // Charset for decoding the binary data into characters
        
        try {
            // Create a FileInputStream to read the binary data from the file.
            FileInputStream fileInputStream = new FileInputStream(filePath);
            
            // Wrap the FileInputStream with an InputStreamReader to convert byte stream into a character stream.
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, charset);
            
            // Use a BufferedReader to read characters efficiently from the InputStreamReader.
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            // Read the file line by line and print the characters.
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            
            // Close the BufferedReader and InputStreamReader (automatically closes FileInputStream).
            bufferedReader.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error: Unsupported charset " + charset);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
