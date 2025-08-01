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
    void call(TreeNode root, int maxs, int[] ans) {
        if (root == null)
            return;
        if (root.val >= maxs)
            ans[0]++;
        call(root.left, Math.max(root.val, maxs), ans);
        call(root.right, Math.max(root.val, maxs), ans);
    }

    public int goodNodes(TreeNode root) {
        int[] ans = new int[1];
        int maxs = Integer.MIN_VALUE;
        call(root, maxs, ans);
        return ans[0];
    }
}