/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = "";
        if (root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        s += root.val;
        while (q.size() > 0) {
            TreeNode temp = q.peek();
            q.remove();
            if (temp.left != null) {
                s += " " + temp.left.val;
                q.add(temp.left);
            } else {
                s += " N";
            }
            if (temp.right != null) {
                s += " " + temp.right.val;
                q.add(temp.right);
            } else {
                s += " N";
            }
        }
        // System.out.println(s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] arr = data.split(" ");
        // if (arr.length == 0)
        //     return null;
        int i = 0;
        TreeNode head = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(head);
        for (i = 1; i < arr.length && q.size() > 0; i++) {
            TreeNode temp = q.peek();
            q.remove();
            // System.out.println(arr[i]);
            if (!arr[i].equals("N")) {
                temp.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(temp.left);
            }
            i++;
            if (!arr[i].equals("N")) {
                temp.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(temp.right);
            }
        }
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));