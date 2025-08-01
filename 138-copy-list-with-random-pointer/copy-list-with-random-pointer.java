/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> m = new HashMap<>();
        Node root = head;
        while (root != null) {
            m.put(root, new Node(root.val));
            root = root.next;
        }
        root = head;
        while (root != null) {
            m.get(root).next = m.get(root.next);
            m.get(root).random = m.get(root.random);
            root = root.next;
        }
        return m.get(head);
    }
}