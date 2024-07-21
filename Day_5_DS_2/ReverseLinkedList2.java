package Day_5_DS_2;

import java.util.Scanner;

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList2 {
    ListNode2 head;

    // Method to insert a new node at the end of the linked list
    public void insert(int data) {
        ListNode2 newNode = new ListNode2(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode2 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public ListNode2 reverseList(ListNode2 start_node) {
        // 3 Nodes required
        // Prev - stores previous node
        // Current - stores current node
        // Next - stores next node
        ListNode2 prev = null;
        ListNode2 current = start_node;
        ListNode2 next = null;

        // Steps to reverse LinkedList2 by changing pointers
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        start_node = prev;
        return (start_node);
    }
}

public class ReverseLinkedList2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read space-separated input and convert to integer array
        System.out.print("Enter numbers separated by spaces: ");
        String[] in = sc.nextLine().split(" ");
        int[] input = new int[in.length];
        for (int i = 0; i < in.length; i++) {
            input[i] = Integer.parseInt(in[i]);
        }

        // Create linked list and insert elements
        LinkedList2 l = new LinkedList2();
        for (int x : input) {
            l.insert(x);
        }

        // Reverse list
        ListNode2 current = l.reverseList(l.head);

        // Display the modified linked list
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        sc.close();
    }
}
