import java.util.ArrayDeque;
import java.util.Deque;

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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        s.flatten(root);
    }
    public void flatten(TreeNode root) {
        if(root==null) return;
        // System.out.println(root.val);

        /*
         * Since flatten(left) is called first, left side of any
         * node is guaranteed to be flat. This assertion will be
         * useful later.
         * */
        flatten(root.left);
        flatten(root.right);

        /*
         * flatten cases
         *   two children, swap
         *   right child only, do nothing
         *   left child only, move entire left tree to right
         * */
        if(root.left==null) return;
        else if(root.right==null) {
            root.right = root.left;
            root.left = null;
        }
        else {
            TreeNode t = root.right;
            root.right=root.left;
            root.left=null;

            TreeNode k = root.right;
            while(k.right!=null) {
                k=k.right;
            }
            k.right=t;
        }


    }
}
