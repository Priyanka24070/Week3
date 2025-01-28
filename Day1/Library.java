class Book {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus; // true = available, false = not available
    Book next;
    Book prev;

    public Book(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private Book head;
    private Book tail;

    public LibraryManagement() {
        this.head = null;
        this.tail = null;
    }

    // Add a book at the beginning
    public void addAtBeginning(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a book at the end
    public void addAtEnd(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add a book at a specific position
    public void addAtPosition(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus, int position) {
        if (position <= 0 || head == null) {
            addAtBeginning(bookTitle, author, genre, bookId, availabilityStatus);
            return;
        }

        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        Book current = head;
        int index = 0;

        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null) {
            addAtEnd(bookTitle, author, genre, bookId, availabilityStatus);
        } else {
            newBook.next = current.next;
            if (current.next != null) {
                current.next.prev = newBook;
            }
            newBook.prev = current;
            current.next = newBook;
        }
    }

    // Remove a book by Book ID
    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }

        Book current = head;

        // Find the book to remove
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }

        // Update pointers
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next; // Removing the head
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev; // Removing the tail
        }

        System.out.println("Book with ID " + bookId + " removed.");
    }

    // Search for a book by Title or Author
    public void searchByTitle(String bookTitle) {
        Book current = head;
        while (current != null) {
            if (current.bookTitle.equalsIgnoreCase(bookTitle)) {
                System.out.println("Book Found: " + current.bookTitle + " | Author: " + current.author +
                        " | Genre: " + current.genre + " | ID: " + current.bookId +
                        " | Available: " + (current.availabilityStatus ? "Yes" : "No"));
                return;
            }
            current = current.next;
        }
        System.out.println("Book with Title '" + bookTitle + "' not found.");
    }

    public void searchByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: " + current.bookTitle + " | Author: " + current.author +
                        " | Genre: " + current.genre + " | ID: " + current.bookId +
                        " | Available: " + (current.availabilityStatus ? "Yes" : "No"));
                return;
            }
            current = current.next;
        }
        System.out.println("Book with Author '" + author + "' not found.");
    }

    // Update a book's Availability Status by Book ID
    public void updateAvailabilityStatus(int bookId, boolean newStatus) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.availabilityStatus = newStatus;
                System.out.println("Availability status updated for Book ID " + bookId);
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }

        Book current = head;
        while (current != null) {
            System.out.println("Title: " + current.bookTitle + " | Author: " + current.author +
                    " | Genre: " + current.genre + " | ID: " + current.bookId +
                    " | Available: " + (current.availabilityStatus ? "Yes" : "No"));
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("The library is empty.");
            return;
        }

        Book current = tail;
        while (current != null) {
            System.out.println("Title: " + current.bookTitle + " | Author: " + current.author +
                    " | Genre: " + current.genre + " | ID: " + current.bookId +
                    " | Available: " + (current.availabilityStatus ? "Yes" : "No"));
            current = current.prev;
        }
    }

    // Count the total number of books in the library
    public void countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total number of books in the library: " + count);
    }
}

public class Library {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        library.addAtBeginning("Book A", "Author A", "Fiction", 1, true);
        library.addAtEnd("Book B", "Author B", "Non-Fiction", 2, true);
        library.addAtPosition("Book C", "Author C", "Fiction", 3, false, 1);

        System.out.println("Library (Forward):");
        library.displayForward();

        System.out.println("\nLibrary (Reverse):");
        library.displayReverse();

        System.out.println("\nSearch by Title:");
        library.searchByTitle("Book B");

        System.out.println("\nSearch by Author:");
        library.searchByAuthor("Author C");

        System.out.println("\nUpdate Availability:");
        library.updateAvailabilityStatus(2, false);

        System.out.println("\nRemove a Book:");
        library.removeByBookId(3);

        System.out.println("\nCount Books:");
        library.countBooks();

        System.out.println("\nLibrary (Forward):");
        library.displayForward();
    }
}
