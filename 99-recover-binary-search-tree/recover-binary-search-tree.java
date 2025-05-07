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
    void call(TreeNode root, ArrayList<TreeNode> a) {
        if (root == null)
            return;
        call(root.left, a);
        a.add(root);
        call(root.right, a);
    }

    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> a = new ArrayList<>();
        call(root, a);
        ArrayList<TreeNode> b = new ArrayList<>();
        b.addAll(a);
        Collections.sort(a, new Comparator<TreeNode>() {
            public int compare(TreeNode a, TreeNode b) {
                if (a.val > b.val)
                    return 1;
                else
                    return -1;
            }
        });
        // - 3 2 5 9
        // - 2 3 5 9
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != b.get(i)) {
                // System.out.println(a.get(i).val + " " + b.get(i).val);
                int temp = a.get(i).val;
                a.get(i).val = b.get(i).val;
                b.get(i).val = temp;
                break;
            }
        }
    }
}