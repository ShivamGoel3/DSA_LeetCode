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
    TreeNode findLca(TreeNode root, int a, int b) {
        if (root == null || root.val == a || root.val == b)
            return root;
        TreeNode left = findLca(root.left, a, b);
        TreeNode right = findLca(root.right, a, b);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }

    boolean findNode(TreeNode root, int value, ArrayList<Character> g, int index) {
        if (root == null)
            return false;
        if (root.val == value) {
            return true;
        }
        if (index == 1)
            g.add('L');
        else
            g.add('U');
        boolean check1 = findNode(root.left, value, g, index);
        if (check1)
            return true;
        g.remove(g.size() - 1);
        if (index == 1)
            g.add('R');
        else
            g.add('U');
        boolean check2 = findNode(root.right, value, g, index);
        if (check2)
            return true;
        g.remove(g.size() - 1);
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLca(root, startValue, destValue);
        String ans = "";
        ArrayList<Character> g = new ArrayList<>();
        findNode(lca, startValue, g, 0);
        findNode(lca, destValue, g, 1);
        for (int i = 0; i < g.size(); i++)
            ans += g.get(i);
        // System.out.print(g.size());
        return ans;
    }
}