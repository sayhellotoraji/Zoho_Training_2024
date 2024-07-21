package Day_5_DS_2;

import java.util.Scanner;

// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
    
    // Function to create a linked list from an array of values and create a cycle at given index
    public ListNode createLinkedListWithCycle(int[] values, int pos) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        ListNode cycleStart = null;
        
        for (int i = 0; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            
            if (i == pos) {
                cycleStart = current; // Remember the node where cycle starts
            }
        }
        
        // Create cycle
        if (cycleStart != null) {
            current.next = cycleStart;
        }
        
        return dummyHead.next;
    }
    
    // Example usage
    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();
        
        // Example 1: [3, 2, 0, -4], pos = 1
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
        int pos = sc.nextInt();

        // Create linked list and insert elements
        LinkedList1 l = new LinkedList1();
        for (int x : input) {
            l.insert(x);
        }

        
        ListNode head = solution.createLinkedListWithCycle(input, pos);
        
        boolean hasCycle = solution.hasCycle(head);
        
        System.out.println("Does the linked list have a cycle? " + hasCycle); // Output: true
    }
}
