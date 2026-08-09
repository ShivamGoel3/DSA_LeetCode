/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class pair {
    TreeNode node;
    int height;

    pair(TreeNode a, int b) {
        this.node = a;
        this.height = b;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<pair> q = new LinkedList<>();
        Map<Integer, List<Integer>> p = new TreeMap<>();
        q.add(new pair(root, 0));
        while (q.size() > 0) {
            int size = q.size();
            Map<Integer, List<Integer>> m = new TreeMap<>();

            while (size > 0) {

                pair temp = q.peek();
                q.remove();
                if (m.containsKey(temp.height))
                    m.get(temp.height).add(temp.node.val);
                else {
                    List<Integer> t = new ArrayList<>();
                    t.add(temp.node.val);
                    m.put(temp.height, t);
                }
                if (temp.node.left != null)
                    q.add(new pair(temp.node.left, temp.height - 1));
                if (temp.node.right != null)
                    q.add(new pair(temp.node.right, temp.height + 1));
                size--;
            }
            for (Integer i : m.keySet()) {
                Collections.sort(m.get(i));
                if (p.containsKey(i)) {
                    p.get(i).addAll(m.get(i));
                } else {
                    p.put(i, m.get(i));
                }

            }
        }
        for (List<Integer> j : p.values()) {

            ans.add(j);
        }
        return ans;
    }
}