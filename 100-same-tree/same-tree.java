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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        while (p != null && q != null) {
            if (p.val != q.val)
                return false;
            if (p.left != null) {
                TreeNode temp = p.left;
                while (temp.right != null && temp.right != p) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = p;
                    p = p.left;
                } else {
                    temp.right = null;
                    p = p.right;
                }
            } else {
                p = p.right;
            }
            if (q.left != null) {
                TreeNode temp = q.left;
                while (temp.right != null && temp.right != q) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = q;
                    q = q.left;
                } else {
                    temp.right = null;
                    q = q.right;
                }
            } else {
                q = q.right;
            }
        }
        return p == null && q == null;
    }
}