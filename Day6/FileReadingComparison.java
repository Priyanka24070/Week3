import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
public class FileReadingComparison {
        public static void fileCreate(String filePath){

            try {
                File fl = new File(filePath);

                if (fl.createNewFile()) {
                    System.out.println("File created successfully: " + filePath);
                } else {
                    System.out.println("File creation failed.");
                }
//            }
            }   catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        }



        public static void fileWrite(String filePath, long range){
            try{
                FileWriter fw = new FileWriter(filePath);
//            int end=(int)2e8;
                for(long i=0; i<range; i++){
                    fw.write("Hello this is a file it contains huge amount of data : ");
                }
                fw.close();
                System.out.println("Successfully wrote to the file.");
            }
            catch(IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

        public static int countWordsWithFileReader(String filePath) throws IOException {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int wordCount = 0;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount+=words.length;
            }
            // close bufferedreader
            br.close();
            return wordCount;
        }

        // Count words using InputStreamReader
        public static int countWordsWithInputStreamReader(String filePath) throws IOException {
            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            // intilize wordcount variables for count number of words
            int wordCount = 0;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            br.close();
            return wordCount;
        }


        public static void timeTake(String filePath){
            long startTime, endTime;
            try {
                startTime = System.nanoTime();
                int wordCountFileReader = countWordsWithFileReader(filePath);
                endTime = System.nanoTime();
                long frTime = endTime - startTime;
                double frTimeMs = frTime / 1_000_000.0;  // Convert nanoseconds to milliseconds
                System.out.println("Time taken by FileReader to count words: " + frTimeMs + " milliseconds");
                System.out.println("Word count using FileReader: " + wordCountFileReader);
            } catch (IOException e) {
                System.err.println("Error reading file with FileReader: " + e.getMessage());
            }

            // Reading file using InputStreamReader
            try {
                startTime = System.nanoTime();
                int wordCountInputStreamReader = countWordsWithInputStreamReader(filePath);
                endTime = System.nanoTime();
                long isrTime = endTime - startTime;
                double isrTimeMs = isrTime / 1_000_000.0;  // Convert nanoseconds to milliseconds
                System.out.println("Time taken by InputStreamReader to count words: " + isrTimeMs + " milliseconds");
                System.out.println("Word count using InputStreamReader: " + wordCountInputStreamReader);
            } catch (IOException e) {
                System.err.println("Error reading file with InputStreamReader: " + e.getMessage());
            }

        }

        public static void fileDelete(String filePath){
            File file = new File(filePath);
            // Delete the file
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        }
        public static void main(String[] args) {
            String filePath="HelloWorld.txt";
            long sizes[] = {20000, 2000000, 10000000};
            long fileSize [] = new long[3];
            fileSize[0]=1;
            fileSize[1]=100;
            fileSize[2]=500;
            for(int i=0; i<3; i++){
                System.out.println("Compare for : "+sizes[i]*10+" Words and file size : "+fileSize[i]+" mb :");
                fileCreate(filePath);
                fileWrite(filePath,sizes[i]);
                timeTake(filePath);
                fileDelete(filePath);
                System.out.println("--------------------------------------------------------------------------");
            }
        }
    }

