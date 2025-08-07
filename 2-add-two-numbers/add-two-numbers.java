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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            tail.next = l1;
            tail = l1;
            tail.val = sum % 10;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            tail.next = l1;
            tail = l1;
            tail.val = sum % 10;
            carry = sum / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            tail.next = l2;
            tail = l2;
            tail.val = sum % 10;
            carry = sum / 10;
            l2 = l2.next;
        }
        if (carry == 1) {
            tail.next = new ListNode(1);
        }
        return head.next;
    }
}