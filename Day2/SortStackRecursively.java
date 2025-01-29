import java.util.Stack;

public class SortStackRecursively {
    // Function to sort the stack recursively
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop(); // Remove the top element
            sortStack(stack); // Sort the remaining stack recursively
            insertAtCorrectPosition(stack, top); // Insert the popped element correctly
        }
    }

    // Function to insert an element in the sorted stack
    private static void insertAtCorrectPosition(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
        } else {
            int top = stack.pop();
            insertAtCorrectPosition(stack, value);
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
