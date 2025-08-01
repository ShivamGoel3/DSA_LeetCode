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
    void call(TreeNode root, int l, int[] ans) {
        if (root == null)
            return;
        ans[0] = Math.max(l, ans[0]);
        call(root.left, l + 1, ans);
        call(root.right, l + 1, ans);
    }

    public int maxDepth(TreeNode root) {
        int[] ans = new int[1];
        call(root, 1, ans);
        return ans[0];
    }
}