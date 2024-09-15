package LinkedList;

class ListNode {
    int val;
    ListNode next;

    // Default constructor
    ListNode() {
        val = 0;
        next = null;
    }

    /*
     * Constructor for a node with only data provided,
     * next initialized to null
     */
    ListNode(int data1) {
        val = data1;
        next = null;
    }

    /*
     * Constructor for a node with both data
     * and next node provided
     */
    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

public class deleteKthPosition {
    // Function to print linked list starting from given head
    public static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Function to delete the k-th node of linked list
    public static ListNode deleteKthNode(ListNode head, int k) {
        // If the list is empty, return null
        if (head == null)
            return null;

        // If k is 0, delete the head node
        if (k == 0) {
            head = head.next;
            return head;
        }

        // Initialize a temporary pointer
        ListNode temp = head;

        // Traverse to the k-th node
        for (int i = 0; temp != null && i < k - 1; i++) {
            temp = temp.next;
        }

        /*
         * If k is greater than the number of nodes,
         * return the unchanged list
         */
        if (temp == null || temp.next == null)
            return head;

        // Delete the k-th node
        ListNode next = temp.next.next;
        temp.next = next;

        // Return head
        return head;
    }

    public static void main(String[] args) {
        // Initialize a list with values for the linked list
        int[] arr = { 12, 5, 8, 7 };

        // Create a linked list with the values from the array
        ListNode head = new ListNode(arr[0]);
        head.next = new ListNode(arr[1]);
        head.next.next = new ListNode(arr[2]);
        head.next.next.next = new ListNode(arr[3]);

        // Call the deleteKthNode function to delete the k-th node
        int k = 2;
        head = deleteKthNode(head, k);

        // Print the linked list after deletion
        printLL(head);
    }
}
