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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                q.add(lists[i]);
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (q.size() > 0) {
            ListNode a = q.poll();
            tail.next = a;
            tail = a;
            if (a.next != null)
                q.add(a.next);

        }
        return head.next;
    }
}