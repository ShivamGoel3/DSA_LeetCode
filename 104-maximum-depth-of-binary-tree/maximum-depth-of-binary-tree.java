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
        return Math.max(a, b) + 1;
    }

    public int maxDepth(TreeNode root) {

        return call(root);
    }
}