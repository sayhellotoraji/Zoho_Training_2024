package Day_5_DS_2;

import java.util.Scanner;

class ListNode3 {
    int val;
    ListNode3 next;

    ListNode3() {}
    ListNode3(int val) { this.val = val; }
    ListNode3(int val, ListNode3 next) { this.val = val; this.next = next; }
}

class LinkedList3 {
    ListNode3 head;

    // Method to insert a new node at the end of the linked list
    public void insert(int data) {
        ListNode3 newNode = new ListNode3(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode3 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public ListNode3 mergeTwoLists(ListNode3 l1, ListNode3 l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

public class Merge2SortedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // List 1
        System.out.print("Enter numbers separated by spaces for list 1: ");
        String[] in1 = sc.nextLine().split(" ");
        int[] input1 = new int[in1.length];
        for (int i = 0; i < in1.length; i++) {
            input1[i] = Integer.parseInt(in1[i]);
        }

        // Create linked list 1 and insert elements
        LinkedList3 l1 = new LinkedList3();
        for (int x : input1) {
            l1.insert(x);
        }

        // List 2
        System.out.print("Enter numbers separated by spaces for list 2: ");
        String[] in2 = sc.nextLine().split(" ");
        int[] input2 = new int[in2.length];
        for (int i = 0; i < in2.length; i++) {
            input2[i] = Integer.parseInt(in2[i]);
        }

        // Create linked list 2 and insert elements
        LinkedList3 l2 = new LinkedList3();
        for (int x : input2) {
            l2.insert(x);
        }

        // Merge lists
        LinkedList3 mergedList = new LinkedList3();
        ListNode3 mergedHead = mergedList.mergeTwoLists(l1.head, l2.head);

        // Display the merged linked list
        ListNode3 current = mergedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        sc.close();
    }
}
