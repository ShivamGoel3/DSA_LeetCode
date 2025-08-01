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
    int call(TreeNode root, int[] ans) {
        if (root == null)
            return 0;
        int a = call(root.left, ans);
        int b = call(root.right, ans);
        ans[0] = Math.max(ans[0], a + b);
        return Math.max(a, b) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        call(root, ans);
        return ans[0];
    }
}