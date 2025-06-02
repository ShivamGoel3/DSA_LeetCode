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
    ListNode merge(ListNode a, ListNode b) {
        if (a == null && b == null)
            return null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.val <= b.val) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }

    ListNode split(ListNode root) {
        ListNode slow = root, fast = root;
        ListNode temp = root;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        return slow;
    }

    ListNode mergesort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode head2 = split(head);
        ListNode head1 = head;
        ListNode a = mergesort(head1);
        ListNode b = mergesort(head2);
        return merge(a, b);
    }

    public ListNode sortList(ListNode head) {
        return mergesort(head);
    }
}