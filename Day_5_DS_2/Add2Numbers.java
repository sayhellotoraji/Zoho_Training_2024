package Day_5_DS_2;

import java.util.Scanner;

class ListNode5 {
    int val;
    ListNode5 next;

    ListNode5() {}
    ListNode5(int val) { this.val = val; }
    ListNode5(int val, ListNode5 next) { this.val = val; this.next = next; }
}

class LinkedList5 {
    ListNode5 head;

    // Method to insert a new node at the end of the linked list
    public void insert(int data) {
        ListNode5 newNode = new ListNode5(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode5 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public ListNode5 addTwoNumbers(ListNode5 l1, ListNode5 l2) {
        ListNode5 dummyHead = new ListNode5(0);
        ListNode5 tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode5 newNode = new ListNode5(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode5 result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }
}

public class Add2Numbers {
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
        LinkedList5 l1 = new LinkedList5();
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
        LinkedList5 l2 = new LinkedList5();
        for (int x : input2) {
            l2.insert(x);
        }

        // Merge lists
        LinkedList5 summationList = new LinkedList5();
        ListNode5 mergedHead = summationList.addTwoNumbers(l1.head, l2.head);

        // Display the merged linked list
        ListNode5 current = mergedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        sc.close();
    }
}
