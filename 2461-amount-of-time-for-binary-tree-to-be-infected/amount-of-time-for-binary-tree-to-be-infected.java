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
class Solution {
    void call(TreeNode root, HashMap<Integer, ArrayList<Integer>> m) {
        if (root == null)
            return;
        if (root.left != null) {
            if (m.containsKey(root.val)) {
                m.get(root.val).add(root.left.val);
            } else {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(root.left.val);
                m.put(root.val, t);
            }
            if (m.containsKey(root.left.val)) {
                m.get(root.left.val).add(root.val);
            } else {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(root.val);
                m.put(root.left.val, t);
            }
            call(root.left, m);
        }

        if (root.right != null) {
            if (m.containsKey(root.val)) {
                m.get(root.val).add(root.right.val);
            } else {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(root.right.val);
                m.put(root.val, t);
            }
            if (m.containsKey(root.right.val)) {
                m.get(root.right.val).add(root.val);
            } else {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(root.val);
                m.put(root.right.val, t);
            }
            call(root.right, m);
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
        call(root, m);
        System.out.println(m);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { start, 0 });
        int ans = 0;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);
        while (q.size() > 0) {
            int[] a = q.peek();
            q.remove();
            ans = Math.max(ans, a[1]);
            int node = a[0];
            for (Integer i : m.get(node)) {
                if (visited.contains(i) == false) {
                    visited.add(i);
                    q.add(new int[] { i, a[1] + 1 });
                }
            }
        }
        return ans;
    }
}