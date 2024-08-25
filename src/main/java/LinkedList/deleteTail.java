import java.util.*;

class ListNode {
    int val;
    ListNode next;

    // Default constructor
    ListNode() {
        val = 0;
        next = null;
    }

    /* Constructor for a node with 
    only data provided, 
    next initialized to null */
    ListNode(int data1) {
        val = data1;
        next = null;
    }

    /* Constructor for a node with both data 
    and next node provided */
    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

public class LinkedListDeletion {
    // Function to print linked list starting from given head
    public static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Function to delete the tail node of linked list 
    public static ListNode deleteTail(ListNode head) {
        /* If the list is empty or has only one node, 
        return null */
        if (head == null || head.next == null) {
            return null;
        }

        /* Initialize a temporary 
        pointer to traverse the list */
        ListNode temp = head;

        /* Traverse to the second last 
        node in the list */
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Delete the last node
        temp.next = null;

        // Return head of modified list
        return head;
    }

    public static void main(String[] args) {
        // Initialize a list with values for the linked list
        int[] arr = {12, 5, 8, 7};

        // Create a linked list with the values from the array
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);

        // Call the deleteTail function to delete the last node
        head = deleteTail(head);

        // Print the linked list after deletion
        printLL(head);
    }
}
