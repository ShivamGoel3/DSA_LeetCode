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
    ListNode call(ListNode root) {
        if (root == null || root.next == null)
            return root;
        ListNode a = call(root.next);
        ListNode b = root.next;
        b.next = root;
        root.next = null;
        return a;
    }

    public ListNode reverseList(ListNode head) {
        return call(head);
    }
}