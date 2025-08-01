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
    int call(TreeNode root, boolean[] ans) {
        if (root == null)
            return 0;
        int a = call(root.left, ans);
        int b = call(root.right, ans);
        if (Math.abs(a - b) > 1)
            ans[0] = false;
        return Math.max(a, b) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        call(root, ans);
        return ans[0];
    }
}