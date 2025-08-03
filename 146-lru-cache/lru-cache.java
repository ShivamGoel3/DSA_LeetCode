class Node {
    int key;
    int value;
    Node left = null;
    Node right = null;
}

class LRUCache {
    int size = 0;
    Node head = new Node();
    Node tail = new Node();
    HashMap<Integer, Node> m = new HashMap<>();

    public LRUCache(int capacity) {
        size = capacity;
        head.right = tail;
        tail.left = head;
    }

    void rem(Node root) {
        root.right.left = root.left;
        root.left.right = root.right;
    }

    void add(Node root) {
        root.left = tail.left;
        tail.left.right = root;
        tail.left = root;
        root.right = tail;
    }

    public int get(int key) {
        if (m.containsKey(key) == false)
            return -1;
        Node temp = m.get(key);
        rem(temp);
        add(temp);
        return temp.value;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node temp = m.get(key);
            temp.value = value;
            rem(temp);
            add(temp);
        } else {
            if (m.size() < size) {
                Node temp = new Node();
                temp.key = key;
                temp.value = value;
                add(temp);
                m.put(key, temp);
            } else {
                Node r = head.right;
                m.remove(r.key);
                rem(r);

                Node temp = new Node();
                temp.key = key;
                temp.value = value;
                add(temp);
                m.put(key, temp);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */