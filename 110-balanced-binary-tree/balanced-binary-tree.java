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
    int call(TreeNode root) {
        if (root == null)
            return 0;
        int a = call(root.left);
        int b = call(root.right);
        if (a == -1 || b == -1 || Math.abs(a - b) > 1)
            return -1;
        return Math.max(a, b) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return call(root) >= 0 ? true : false;
    }
}