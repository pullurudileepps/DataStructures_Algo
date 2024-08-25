import java.util.*;
// Definition of singly linked list
class Node {
    public int data;
    public Node next;

    // Constructor with both data and next pointer
    public Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data, sets next to null
    public Node(int data1) {
        data = data1;
        next = null;
    }
}

public class LinkedListExample {
    // Function to print the linked list
    static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Function to delete a node with a specific value in a linked list
    static Node deleteVal(Node head, int val) {
        // Check if the list is empty
        if (head == null)
            return head;

        // If the first node has the target value, delete it
        if (head.data == val) {
            Node temp = head;
            head = head.next;
            temp = null;
            return head;
        }

        // Traverse the list to find the node with the target value
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if (temp.data == val) {
                // Adjust the pointers to skip the node with the target value
                prev.next = temp.next;
                // Delete the node with the target value
                temp = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        // Create a linked list
        int[] arr = {0, 1, 2};
        int val = 1;
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);

        // Delete the node with the target value in the linked list
        head = deleteVal(head, val);

        // Print the modified linked list
        printLL(head);
    }
}
