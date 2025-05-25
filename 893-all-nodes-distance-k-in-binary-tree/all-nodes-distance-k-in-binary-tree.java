/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int source;

    void call(TreeNode root, ArrayList<ArrayList<Integer>> adj, TreeNode target) {
        if (root == null)
            return;
        if (target == root) {
            source = root.val;
        }
        if (root.left != null) {
            adj.get(root.val).add(root.left.val);
            adj.get(root.left.val).add(root.val);
            call(root.left, adj, target);
        }
        if (root.right != null) {
            adj.get(root.val).add(root.right.val);
            adj.get(root.right.val).add(root.val);
            call(root.right, adj, target);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= 500; i++) {
            adj.add(new ArrayList<>());
        }
        call(root, adj, target);
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[501];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { source, 0 });
        visited[source] = 1;
        while (q.size() > 0) {
            int[] a = q.peek();
            q.remove();
            if (a[1] == k)
                ans.add(a[0]);
            for (Integer i : adj.get(a[0])) {
                if (visited[i] == 1)
                    continue;
                visited[i] = 1;
                q.add(new int[] { i, a[1] + 1 });
            }
        }
        return ans;
    }
}