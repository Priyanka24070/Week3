import java.util.ArrayList;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds; // List of Friend IDs
    User next; // Pointer to the next user in the list

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head = null;

    // Add a new user to the system
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("User " + name + " added successfully.");
    }

    // Find a user by User ID
    private User findUserById(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }

        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Remove a friend connection between two users
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIds.remove((Integer) userId2);
        user2.friendIds.remove((Integer) userId1);

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int friendId : user.friendIds) {
            User friend = findUserById(friendId);
            if (friend != null) {
                System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
            }
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        for (int friendId : user1.friendIds) {
            if (user2.friendIds.contains(friendId)) {
                User mutualFriend = findUserById(friendId);
                if (mutualFriend != null) {
                    System.out.println("- " + mutualFriend.name + " (ID: " + mutualFriend.userId + ")");
                }
            }
        }
    }

    // Search for a user by User ID or Name
    public void searchUser(String name, int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId || current.name.equalsIgnoreCase(name)) {
                System.out.println("User found: " + current.name + " (ID: " + current.userId + ", Age: " + current.age + ")");
                return;
            }
            current = current.next;
        }
        System.out.println("User not found.");
    }

    // Count the number of friends for each user
    public void countFriends() {
        User current = head;
        while (current != null) {
            System.out.println(current.name + " has " + current.friendIds.size() + " friend(s).");
            current = current.next;
        }
    }

    // Display all users in the system
    public void displayAllUsers() {
        User current = head;
        if (current == null) {
            System.out.println("No users in the system.");
            return;
        }
        System.out.println("All users in the system:");
        while (current != null) {
            System.out.println("- " + current.name + " (ID: " + current.userId + ", Age: " + current.age + ")");
            current = current.next;
        }
    }
}

public class Friend {
    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();

        // Adding users
        socialMedia.addUser(1, "Alice", 25);
        socialMedia.addUser(2, "Bob", 30);
        socialMedia.addUser(3, "Charlie", 20);
        socialMedia.addUser(4, "Diana", 28);

        // Adding friend connections
        socialMedia.addFriendConnection(1, 2);
        socialMedia.addFriendConnection(1, 3);
        socialMedia.addFriendConnection(2, 4);

        // Display all users
        System.out.println();
        socialMedia.displayAllUsers();

        // Display friends of a user
        System.out.println();
        socialMedia.displayFriends(1);

        // Find mutual friends
        System.out.println();
        socialMedia.findMutualFriends(1, 2);

        // Remove a friend connection
        System.out.println();
        socialMedia.removeFriendConnection(1, 2);

        // Display friends after removal
        System.out.println();
        socialMedia.displayFriends(1);

        // Count friends for each user
        System.out.println();
        socialMedia.countFriends();

        // Search for a user
        System.out.println();
        socialMedia.searchUser("Alice", -1);
    }
}
