import com.sun.source.tree.Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static void main(String args[]) {
        Solution s = new Solution();
        TreeNode k = new TreeNode(1);
        k.left = new TreeNode(2);
        k.right = new TreeNode(3);
        k.left.left = new TreeNode(4);
        k.left.right = new TreeNode(5);
        s.isSymmetric(k);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;

        isSymmetric(root.left);
        System.out.println(root.val);
        isSymmetric(root.right);

        return true;

    }
}
