/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    void call(Node node, HashMap<Node, Node> m) {
        Node temp = new Node(node.val);
        m.put(node, temp);
        for (Node i : node.neighbors) {
            if (m.containsKey(i) == false) {
                call(i, m);
            }
            m.get(node).neighbors.add(m.get(i));
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        HashMap<Node, Node> m = new HashMap<>();
        call(node, m);
        return m.get(node);
    }
}