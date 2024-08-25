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
               if(head == null) return head;
        if(head.val == X) return head.next;
        ListNode temp = head; ListNode prev = null;
        while(temp != null){
            if(temp.val == X){
                prev.next = prev.next.next;
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
