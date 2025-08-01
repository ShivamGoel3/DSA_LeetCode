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
        while (n > 0 && root != null) {
            root = root.next;
            n--;
        }
        if (root == null)
            return head.next;
        ListNode a = head;
        while (root.next != null) {
            a = a.next;
            root = root.next;
        }
        a.next = a.next.next;
        return head;
    }
}