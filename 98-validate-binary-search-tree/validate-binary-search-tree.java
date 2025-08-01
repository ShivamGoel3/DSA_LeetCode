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
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        while (root != null) {
            if (root.left != null) {
                TreeNode temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    if (prev != null && prev.val >= root.val)
                        return false;
                    prev = root;
                    root = temp.right.right;
                    temp.right = null;
                }
            } else {
                if (prev != null && prev.val >= root.val)
                    return false;
                prev = root;
                root = root.right;
            }
        }
        return true;
    }
}