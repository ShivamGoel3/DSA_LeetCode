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
    TreeNode first = null, middle = null, last = null, prev = null;

    void call(TreeNode root) {
        if (root == null)
            return;

        call(root.left);
        if (prev != null) {
            if (prev.val > root.val) {
                if (first == null) {
                    first = prev;
                    middle = root;
                    ;
                } else {
                    middle = prev;
                    last = root;
                }
            }
        }
        prev = root;
        call(root.right);

    }

    public void recoverTree(TreeNode root) {
        call(root);
        if (last == null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        } else {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
    }
}