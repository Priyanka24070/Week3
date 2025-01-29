class MyHashMap {
    private static final int SIZE = 1000;  // Size of the hash map
    private LinkedList<Entry>[] table;

    // Constructor to initialize the hash map
    public MyHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Inner class to represent key-value pairs
    private class Entry {
        int key, value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Hash function to calculate index based on the key
    private int getIndex(int key) {
        return key % SIZE;
    }

    // Insert or update a key-value pair
    public void put(int key, int value) {
        int index = getIndex(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                entry.value = value;  // Update the value if key exists
                return;
            }
        }
        // If key doesn't exist, add a new entry
        table[index].add(new Entry(key, value));
    }

    // Retrieve the value for a given key
    public int get(int key) {
        int index = getIndex(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;  // Return -1 if the key is not found
    }

    // Remove the key-value pair for a given key
    public void remove(int key) {
        int index = getIndex(key);
        Entry toRemove = null;
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove != null) {
            table[index].remove(toRemove);
        }
    }

    // Optional: Print the map for visualization
    public void printMap() {
        for (int i = 0; i < SIZE; i++) {
            if (!table[i].isEmpty()) {
                for (Entry entry : table[i]) {
                    System.out.print("(" + entry.key + ":" + entry.value + ") ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        // Insert some key-value pairs
        map.put(1, 100);
        map.put(2, 200);
        map.put(1001, 300);

        // Retrieve values
        System.out.println("Value for key 1: " + map.get(1));  // Output: 100
        System.out.println("Value for key 2: " + map.get(2));  // Output: 200
        System.out.println("Value for key 1001: " + map.get(1001));  // Output: 300

        // Remove a key-value pair
        map.remove(2);
        System.out.println("Value for key 2 after removal: " + map.get(2));  // Output: -1 (not found)

        // Print the map (for visualization)
        map.printMap();
    }
}
