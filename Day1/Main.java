class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagementSystem {
    private Movie head;
    private Movie tail;

    public MovieManagementSystem() {
        head = null;
        tail = null;
    }

    // Add a movie at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add a movie at the end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add a movie at a specific position
    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie current = head;
        int index = 0;

        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newMovie.next = current.next;
            newMovie.prev = current;
            if (current.next != null) {
                current.next.prev = newMovie;
            } else {
                tail = newMovie;
            }
            current.next = newMovie;
        }
    }

    // Remove a movie by title
    public void removeByTitle(String title) {
        Movie current = head;

        while (current != null) {
            if (current.title.equals(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                System.out.println("Movie \"" + title + "\" removed.");
                return;
            }
            current = current.next;
        }

        System.out.println("Movie \"" + title + "\" not found.");
    }

    // Search for a movie by director
    public void searchByDirector(String director) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equals(director)) {
                System.out.println("Found: " + current.title + " (" + current.year + "), Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found for director \"" + director + "\".");
        }
    }

    // Search for a movie by rating
    public void searchByRating(double rating) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Found: " + current.title + " (" + current.year + "), Directed by: " + current.director);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found with rating " + rating + ".");
        }
    }

    // Update a movie's rating
    public void updateRating(String title, double newRating) {
        Movie current = head;

        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                System.out.println("Updated rating for \"" + title + "\" to " + newRating + ".");
                return;
            }
            current = current.next;
        }

        System.out.println("Movie \"" + title + "\" not found.");
    }

    // Display movies in forward order
    public void displayForward() {
        Movie current = head;

        while (current != null) {
            System.out.println(current.title + " (" + current.year + "), Directed by: " + current.director + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display movies in reverse order
    public void displayReverse() {
        Movie current = tail;

        while (current != null) {
            System.out.println(current.title + " (" + current.year + "), Directed by: " + current.director + ", Rating: " + current.rating);
            current = current.prev;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        mms.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        mms.addAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        mms.addAtPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 1);

        System.out.println("Movies (Forward):");
        mms.displayForward();

        System.out.println("\nMovies (Reverse):");
        mms.displayReverse();

        mms.updateRating("Inception", 9.0);

        System.out.println("\nSearch by Director:");
        mms.searchByDirector("Christopher Nolan");

        System.out.println("\nSearch by Rating:");
        mms.searchByRating(9.0);

        mms.removeByTitle("The Dark Knight");

        System.out.println("\nMovies (Forward) after removal:");
        mms.displayForward();
    }
}
