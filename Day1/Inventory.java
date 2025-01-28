class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagement {
    private Item head;

    public InventoryManagement() {
        this.head = null;
    }

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
        }
    }

    // Add an item at a specific position
    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position <= 0 || head == null) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }

        Item newItem = new Item(itemName, itemId, quantity, price);
        Item current = head;
        int index = 0;

        while (current.next != null && index < position - 1) {
            current = current.next;
            index++;
        }

        newItem.next = current.next;
        current.next = newItem;
    }

    // Remove an item based on Item ID
    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("The inventory is empty.");
            return;
        }

        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }

        Item current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID or Item Name
    public void searchItem(int itemId) {
        Item current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                System.out.println("Item Found: " + current.itemName + " | ID: " + current.itemId +
                        " | Quantity: " + current.quantity + " | Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void searchItem(String itemName) {
        Item current = head;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + current.itemName + " | ID: " + current.itemId +
                        " | Quantity: " + current.quantity + " | Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with name '" + itemName + "' not found.");
    }

    // Calculate and display the total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        Item current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Sort the inventory by Item Name (ascending order)
    public void sortByItemName() {
        if (head == null || head.next == null) {
            return;
        }

        head = mergeSort(head, "name");
    }

    // Sort the inventory by Price (ascending order)
    public void sortByPrice() {
        if (head == null || head.next == null) {
            return;
        }

        head = mergeSort(head, "price");
    }

    private Item mergeSort(Item head, String criteria) {
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        // Recursively sort both halves
        Item left = mergeSort(head, criteria);
        Item right = mergeSort(nextOfMiddle, criteria);

        // Merge the sorted halves
        return merge(left, right, criteria);
    }

    private Item merge(Item left, Item right, String criteria) {
        if (left == null) return right;
        if (right == null) return left;

        if (criteria.equals("name")) {
            if (left.itemName.compareToIgnoreCase(right.itemName) < 0) {
                left.next = merge(left.next, right, criteria);
                return left;
            } else {
                right.next = merge(left, right.next, criteria);
                return right;
            }
        } else if (criteria.equals("price")) {
            if (left.price <= right.price) {
                left.next = merge(left.next, right, criteria);
                return left;
            } else {
                right.next = merge(left, right.next, criteria);
                return right;
            }
        }
        return null;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;

        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display all items in the inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("The inventory is empty.");
            return;
        }

        Item current = head;
        while (current != null) {
            System.out.println("Name: " + current.itemName + " | ID: " + current.itemId +
                    " | Quantity: " + current.quantity + " | Price: " + current.price);
            current = current.next;
        }
    }
}

public class Inventory {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        inventory.addAtBeginning("Item A", 1, 10, 5.5);
        inventory.addAtEnd("Item B", 2, 20, 15.0);
        inventory.addAtPosition("Item C", 3, 5, 25.0, 1);

        System.out.println("Inventory:");
        inventory.displayInventory();

        System.out.println("\nUpdate Quantity:");
        inventory.updateQuantity(2, 30);

        System.out.println("\nSearch by ID:");
        inventory.searchItem(1);

        System.out.println("\nSearch by Name:");
        inventory.searchItem("Item C");

        System.out.println("\nTotal Inventory Value:");
        inventory.calculateTotalValue();

        System.out.println("\nSort by Name:");
        inventory.sortByItemName();
        inventory.displayInventory();

        System.out.println("\nSort by Price:");
        inventory.sortByPrice();
        inventory.displayInventory();

        System.out.println("\nRemove Item:");
        inventory.removeByItemId(2);
        inventory.displayInventory();
    }
}
