import com.sun.source.tree.Tree;

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
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);

        System.out.println(s.tree2str(n));
    }
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        if(root.left==null && root.right==null) {
            return root.val+"";
        }
        if(root.right==null) {
            return root.val+"("+tree2str(root.left)+")";
        }
        return root.val+"("+tree2str(root.left)+")("+tree2str(root.right)+")";

    }

}
