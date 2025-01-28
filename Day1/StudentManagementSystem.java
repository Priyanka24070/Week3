import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    private Student head;

    public StudentList() {
        head = null;
    }

    public void addStudentAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addStudentAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addStudentAtPosition(int rollNumber, String name, int age, char grade, int position) {
        if (position <= 1) {
            addStudentAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        int count = 1;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Position out of bounds. Adding at the end.");
            addStudentAtEnd(rollNumber, name, age, grade);
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteStudent(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Record deleted.");
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found.");
            return;
        }
        temp.next = temp.next.next;
        System.out.println("Record deleted.");
    }

    public void searchStudent(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name
                        + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void updateStudentGrade(int rollNumber, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name
                    + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        Scanner scanner = new Scanner(System.in);
        int choice, rollNumber, age, position;
        char grade;
        String name;

        do {
            System.out.println("\n1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Update Student Grade");
            System.out.println("7. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number, Name, Age, Grade: ");
                    rollNumber = scanner.nextInt();
                    name = scanner.next();
                    age = scanner.nextInt();
                    grade = scanner.next().charAt(0);
                    list.addStudentAtBeginning(rollNumber, name, age, grade);
                    break;
                case 2:
                    System.out.print("Enter Roll Number, Name, Age, Grade: ");
                    rollNumber = scanner.nextInt();
                    name = scanner.next();
                    age = scanner.nextInt();
                    grade = scanner.next().charAt(0);
                    list.addStudentAtEnd(rollNumber, name, age, grade);
                    break;
                case 3:
                    System.out.print("Enter Roll Number, Name, Age, Grade, Position: ");
                    rollNumber = scanner.nextInt();
                    name = scanner.next();
                    age = scanner.nextInt();
                    grade = scanner.next().charAt(0);
                    position = scanner.nextInt();
                    list.addStudentAtPosition(rollNumber, name, age, grade, position);
                    break;
                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    rollNumber = scanner.nextInt();
                    list.deleteStudent(rollNumber);
                    break;
                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    rollNumber = scanner.nextInt();
                    list.searchStudent(rollNumber);
                    break;
                case 6:
                    System.out.print("Enter Roll Number and new Grade: ");
                    rollNumber = scanner.nextInt();
                    grade = scanner.next().charAt(0);
                    list.updateStudentGrade(rollNumber, grade);
                    break;
                case 7:
                    list.displayAllStudents();
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
