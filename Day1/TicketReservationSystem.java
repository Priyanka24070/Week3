class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class CircularLinkedList {
    Ticket head = null;

    // Add a new ticket at the end of the list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            newTicket.next = head; // Point to itself, circular reference
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;
        do {
            if (temp.ticketId == ticketId) {
                if (prev == null) {
                    // Removing the first ticket (head)
                    Ticket last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    if (head.next == head) {
                        head = null; // Only one ticket in the list
                    } else {
                        head = head.next;
                    }
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Ticket ID " + ticketId + " has been removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket ID not found.");
    }

    // Display all the tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(searchTerm) || temp.movieName.equalsIgnoreCase(searchTerm)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer Name: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found with the given customer name or movie name.");
        }
    }

    // Calculate the total number of booked tickets
    public int totalBookedTickets() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        CircularLinkedList ticketList = new CircularLinkedList();

        // Add tickets
        ticketList.addTicket(1, "John Doe", "Avatar 2", "A1", "2025-01-28 18:00");
        ticketList.addTicket(2, "Jane Smith", "Mission Impossible", "B2", "2025-01-28 19:00");
        ticketList.addTicket(3, "Michael Brown", "Avatar 2", "C3", "2025-01-28 20:00");

        // Display all tickets
        System.out.println("All Tickets:");
        ticketList.displayTickets();

        // Search for tickets by Customer Name or Movie Name
        System.out.println("\nSearching for tickets by Customer Name 'John Doe':");
        ticketList.searchTicket("John Doe");

        System.out.println("\nSearching for tickets by Movie Name 'Avatar 2':");
        ticketList.searchTicket("Avatar 2");

        // Remove a ticket by Ticket ID
        System.out.println("\nRemoving Ticket ID 2:");
        ticketList.removeTicket(2);

        // Display all tickets again after removal
        System.out.println("\nAll Tickets After Removal:");
        ticketList.displayTickets();

        // Calculate total booked tickets
        System.out.println("\nTotal Booked Tickets: " + ticketList.totalBookedTickets());
    }
}
