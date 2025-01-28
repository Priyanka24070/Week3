class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int processCount = 0;

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        processCount++;
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }

        Process current = head;
        Process previous = null;

        do {
            if (current.processId == processId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                processCount--;
                System.out.println("Process with ID " + processId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate the round-robin scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Process current = head;
        int totalTime = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        System.out.println("Simulating Round-Robin Scheduling...");
        while (processCount > 0) {
            System.out.println("\nExecuting Process ID: " + current.processId);
            int executionTime = Math.min(current.burstTime, timeQuantum);
            current.burstTime -= executionTime;
            totalTime += executionTime;

            // Display the current process state
            displayProcesses();

            // If the process is finished, remove it
            if (current.burstTime == 0) {
                System.out.println("Process ID " + current.processId + " has finished execution.");
                totalTurnaroundTime += totalTime;
                removeProcess(current.processId);
            } else {
                System.out.println("Process ID " + current.processId + " remaining burst time: " + current.burstTime);
            }

            // Move to the next process
            current = current.next;
        }

        totalWaitingTime = totalTurnaroundTime - totalTime;

        // Calculate and display average waiting time and turn-around time
        System.out.println("\nScheduling complete.");
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / processCount);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processCount);
    }

    // Display the list of processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the list.");
            return;
        }

        System.out.println("Processes in the circular queue:");
        Process current = head;
        do {
            System.out.println("Process ID: " + current.processId + " | Burst Time: " + current.burstTime + " | Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding processes
        scheduler.addProcess(1, 10, 3);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 2);

        // Displaying processes
        System.out.println("Initial Processes:");
        scheduler.displayProcesses();

        // Simulate round-robin scheduling with a time quantum of 4
        scheduler.simulateRoundRobin(4);
    }
}
