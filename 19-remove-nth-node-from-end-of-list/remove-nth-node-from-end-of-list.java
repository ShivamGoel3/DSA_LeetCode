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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = head;
        ListNode newhead = head;

        while (root != null && n > 0) {
            root = root.next;
            n--;
        }
        if (root == null) {
            return head.next;
        }
        while (root.next != null) {
            root = root.next;
            newhead = newhead.next;
        }
        newhead.next = newhead.next.next;
        return head;
    }
}