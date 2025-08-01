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
    void call(TreeNode root, int[] ans) {
        if (root == null)
            return;
        call(root.left, ans);
        ans[1]--;
        if (ans[1] == 0)
            ans[0] = root.val;
        call(root.right, ans);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[2];
        ans[0] = 0;
        ans[1] = k;
        call(root, ans);
        return ans[0];
    }
}