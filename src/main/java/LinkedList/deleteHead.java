import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

public class Main {
    // Function to delete the head node of the linked list
    public static ListNode deleteHead(ListNode head) {
        // If list is empty, nothing to delete
        if (head == null) {
            return null;
        }
        // Set temporary pointer
        ListNode temp = head;
        // Update head to the next node
        head = head.next;
        // Delete original head
        temp = null;
        // Return new head
        return head;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Function to insert a new node at the beginning of the linked list
    public static ListNode insertAtHead(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static void main(String[] args) {
        // Create a linked list
        ListNode head = null;
        head = insertAtHead(head, 3);
        head = insertAtHead(head, 2);
        head = insertAtHead(head, 1);

        System.out.print("Original list: ");
        printList(head);

        // Delete the head node
        head = deleteHead(head);

        System.out.print("List after deleting head: ");
        printList(head);
    }
}
