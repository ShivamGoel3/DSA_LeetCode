class trie {
    boolean isLeaf = false;
    trie[] child = new trie[26];
}

class Trie {
    trie head = new trie();

    public Trie() {

    }

    public void insert(String word) {
        trie root = head;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (root.child[ch - 'a'] == null)
                root.child[ch - 'a'] = new trie();
            root = root.child[ch - 'a'];
        }
        root.isLeaf = true;
    }

    public boolean search(String word) {
        trie root = head;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (root.child[ch - 'a'] == null)
                return false;
            root = root.child[ch - 'a'];
        }
        return root.isLeaf;
    }

    public boolean startsWith(String prefix) {
        trie root = head;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (root.child[ch - 'a'] == null)
                return false;
            root = root.child[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */