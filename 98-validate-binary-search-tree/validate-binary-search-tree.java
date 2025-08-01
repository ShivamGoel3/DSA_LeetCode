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
    TreeNode prev = null;

    boolean call(TreeNode root) {
        if (root == null)
            return true;
        boolean check = call(root.left);
        // System.out.println(root + " " + prev + " " + root.val);
        if (check == false)
            return false;
        if (prev != null) {
            if (prev.val >= root.val)
                return false;
        }
        prev = root;
        return call(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        return call(root);
    }
}