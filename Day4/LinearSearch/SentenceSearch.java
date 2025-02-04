public class SentenceSearch {

    // Method to perform linear search for a word in an array of sentences
    public static String findSentenceWithWord(String[] sentences, String word) {
        // Iterate through each sentence
        for (String sentence : sentences) {
            // Check if the sentence contains the specified word
            if (sentence.contains(word)) {
                return sentence; // Return the first matching sentence
            }
        }
        return "Not Found"; // Return if no sentence contains the word
    }

    public static void main(String[] args) {
        // Example array of sentences
        String[] sentences = {
            "The sun rises in the east.",
            "A journey of a thousand miles begins with a single step.",
            "Practice makes a man perfect.",
            "Hard work is the key to success.",
            "Never give up on your dreams."
        };

        // Word to search for
        String word = "success";

        // Calling the method and printing the result
        String result = findSentenceWithWord(sentences, word);

        System.out.println("Result: " + result);
    }
}

