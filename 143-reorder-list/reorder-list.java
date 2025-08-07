/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode reverse(ListNode root) {
        ListNode curr = root, prev = null, nex = null;
        while (curr != null) {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head.next == null)
            return;
        ListNode root = new ListNode(-1);
        ListNode tail = root;
        ListNode slow = head, fast = head;
        ListNode a = head, b = head;
        while (fast != null && fast.next != null) {
            a = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        a.next = null;
        a = head;
        b = slow;
        b = reverse(b);
        // while (a != null) {
        //     System.out.print(a.val + " ");
        //     a = a.next;
        // }
        // System.out.println("a");
        // while (b != null) {
        //     System.out.print(b.val + " ");
        //     b = b.next;
        // }
        while (a != null || b != null) {
            if (a != null) {
                tail.next = a;
                tail = a;
                a = a.next;
            }
            if (b != null) {
                tail.next = b;
                tail = b;
                b = b.next;
            }
        }
        head = root.next;
    }
}