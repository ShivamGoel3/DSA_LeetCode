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
    boolean check = true;

    int call(TreeNode root) {
        if (root == null)
            return 0;
        int a = call(root.left);
        int b = call(root.right);
        if (Math.abs(a-b) > 1)
            check = false;
        return Math.max(a, b) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        check = true;
        call(root);
        return check;
    }
}