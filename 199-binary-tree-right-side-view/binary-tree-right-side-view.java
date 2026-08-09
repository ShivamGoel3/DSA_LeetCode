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
    void callRight(TreeNode root, List<Integer> ans, int level, int[] mh) {
        if (root == null)
            return;
        if (level > mh[0]) {
            ans.add(root.val);
            mh[0]++;
        }
        callRight(root.right, ans, level + 1, mh);
        callRight(root.left, ans, level + 1, mh);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        int[] mh = new int[1];
        mh[0] = -1;
        callRight(root, ans, 0, mh);
        return ans;
    }
}