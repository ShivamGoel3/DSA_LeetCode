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
    public ListNode merge(ListNode a, ListNode b) {
        if (a == null && b == null)
            return null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.val < b.val) {
            a.next = merge(a.next, b);
            return a;
        }
        else{
            b.next = merge(a, b.next);
            return b;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       
        return merge(list1,list2);
    }
}