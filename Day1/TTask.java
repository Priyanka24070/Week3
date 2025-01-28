class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head;
    private Task tail;
    private Task currentTask; // Keeps track of the current task

    public TaskScheduler() {
        head = null;
        tail = null;
        currentTask = null;
    }

    // Add a task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head; // Circular link
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head; // Update circular link
        }
    }

    // Add a task at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (tail == null) {
            head = tail = newTask;
            tail.next = head; // Circular link
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head; // Update circular link
        }
    }

    // Add a task at a specific position
    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position <= 0 || head == null) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task current = head;
        int index = 0;

        while (current.next != head && index < position - 1) {
            current = current.next;
            index++;
        }

        newTask.next = current.next;
        current.next = newTask;

        if (current == tail) {
            tail = newTask;
            tail.next = head; // Update circular link
        }
    }

    // Remove a task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("The list is empty. Task not found.");
            return;
        }

        Task current = head;
        Task previous = tail;

        do {
            if (current.taskId == taskId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head; // Update circular link
                } else {
                    previous.next = current.next;
                }

                if (current == tail) {
                    tail = previous;
                    tail.next = head;
                }

                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }

            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks in the scheduler.");
            return;
        }

        if (currentTask == null) {
            currentTask = head;
        }

        System.out.println("Current Task:");
        System.out.println("ID: " + currentTask.taskId + ", Name: " + currentTask.taskName +
                           ", Priority: " + currentTask.priority + ", Due Date: " + currentTask.dueDate);
        currentTask = currentTask.next; // Move to the next task
    }

    // Display all tasks starting from the head
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the scheduler.");
            return;
        }

        Task current = head;
        do {
            System.out.println("ID: " + current.taskId + ", Name: " + current.taskName +
                               ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for a task by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the scheduler.");
            return;
        }

        Task current = head;
        boolean found = false;

        do {
            if (current.priority == priority) {
                System.out.println("ID: " + current.taskId + ", Name: " + current.taskName +
                                   ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }
}

public class TTask {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtBeginning(1, "Design UI", 3, "2025-02-01");
        scheduler.addAtEnd(2, "Code Backend", 2, "2025-02-05");
        scheduler.addAtPosition(3, "Testing", 1, "2025-02-10", 1);

        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        System.out.println("\nView Current Task:");
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        System.out.println("\nSearch Tasks by Priority:");
        scheduler.searchByPriority(2);

        System.out.println("\nRemove Task with ID 2:");
        scheduler.removeByTaskId(2);

        System.out.println("\nAll Tasks After Removal:");
        scheduler.displayAllTasks();
    }
}
