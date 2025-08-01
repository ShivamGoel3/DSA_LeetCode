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
        int sum = root.val;
        ans[0] = Math.max(ans[0], root.val);
        ans[0] = Math.max(ans[0], root.val + a);
        ans[0] = Math.max(ans[0], root.val + b);
        ans[0] = Math.max(ans[0], root.val + a + b);
        return Math.max(root.val, Math.max(root.val + a, root.val + b));

    }

    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        call(root, ans);
        return ans[0];
    }
}