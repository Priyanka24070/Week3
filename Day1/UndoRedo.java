class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head; // Head of the doubly linked list
    private TextState tail; // Tail of the doubly linked list
    private TextState currentState; // Pointer to the current state
    private int historyLimit; // Maximum number of states allowed
    private int size; // Current size of the history

    public TextEditor(int historyLimit) {
        this.historyLimit = historyLimit;
        this.head = null;
        this.tail = null;
        this.currentState = null;
        this.size = 0;
    }

    // Add a new state to the editor
    public void addState(String content) {
        TextState newState = new TextState(content);

        // If there's no state yet
        if (head == null) {
            head = newState;
            tail = newState;
            currentState = newState;
        } else {
            // Remove any "redo" states
            currentState.next = null;
            tail = currentState;

            // Add the new state
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            currentState = newState;
        }

        size++;

        // Maintain history limit
        if (size > historyLimit) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("State added: " + content);
    }

    // Undo operation
    public void undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("Nothing to undo.");
            return;
        }

        currentState = currentState.prev;
        System.out.println("Undo performed. Current state: " + currentState.content);
    }

    // Redo operation
    public void redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("Nothing to redo.");
            return;
        }

        currentState = currentState.next;
        System.out.println("Redo performed. Current state: " + currentState.content);
    }

    // Display the current state
    public void displayCurrentState() {
        if (currentState == null) {
            System.out.println("No content available.");
        } else {
            System.out.println("Current state: " + currentState.content);
        }
    }

    // Display the entire history (for debugging purposes)
    public void displayHistory() {
        System.out.println("Text Editor History:");
        TextState temp = head;
        while (temp != null) {
            System.out.print("[" + temp.content + "]");
            if (temp == currentState) {
                System.out.print(" <- Current");
            }
            System.out.println();
            temp = temp.next;
        }
    }
}

public class UndoRedo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10); // History limit of 10 states

        // Adding new states
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.addState("Hello, World! How");
        editor.addState("Hello, World! How are");
        editor.addState("Hello, World! How are you?");

        // Display current state
        System.out.println();
        editor.displayCurrentState();

        // Undo operations
        System.out.println();
        editor.undo();
        editor.undo();

        // Display current state
        System.out.println();
        editor.displayCurrentState();

        // Redo operation
        System.out.println();
        editor.redo();

        // Display current state
        System.out.println();
        editor.displayCurrentState();

        // Display history
        System.out.println();
        editor.displayHistory();
    }
}
