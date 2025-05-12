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
    TreeNode call(TreeNode root, int key) {
        if (root == null)
            return root;
        if (root.val < key) {
            root.right = call(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = call(root.left, key);
            return root;
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            TreeNode temp = root.right;
            while (temp.left != null)
                temp = temp.left;
            root.val = temp.val;
            root.right = call(root.right, temp.val);
            return root;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return call(root, key);
        // return root;
    }
}