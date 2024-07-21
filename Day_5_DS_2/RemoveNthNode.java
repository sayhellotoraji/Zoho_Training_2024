package Day_5_DS_2;

import java.util.Scanner;

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}

class LinkedList1 {
    ListNode1 head;

    // Method to insert a new node at the end of the linked list
    public void insert(int data) {
        ListNode1 newNode = new ListNode1(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode1 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to remove the n-th node from the end of the linked list
    public ListNode1 removeNthFromEnd(ListNode1 head, int n) {
        ListNode1 dummy = new ListNode1(0);
        dummy.next = head;
        ListNode1 fast = dummy;
        ListNode1 slow = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                return head; // No need to remove if n is out of bounds
            }
            fast = fast.next;
        }

        // Move fast and slow pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next; // Return the updated head
    }
}

public class RemoveNthNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read space-separated input and convert to integer array
        System.out.print("Enter numbers separated by spaces: ");
        String[] in = sc.nextLine().split(" ");
        int[] input = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            input[i] = Integer.parseInt(in[i]);
        }

        // Read value of n
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        // Create linked list and insert elements
        LinkedList1 l = new LinkedList1();
        for (int x : input) {
            l.insert(x);
        }

        // Remove the n-th node from end and get updated head
        ListNode1 current = l.removeNthFromEnd(l.head, n);

        // Display the modified linked list
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        sc.close();
    }
}
