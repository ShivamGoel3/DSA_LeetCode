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
    ListNode reverse(ListNode root){
        if(root.next==null)
        return root;
        ListNode temp = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return temp;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
        return head;
        return reverse(head);
        // return prev;
    }
}