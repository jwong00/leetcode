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
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(5);
        t.left.left = new TreeNode(3);
        t.left.right = new TreeNode(4);
        t.right.right = new TreeNode(6);
        s.flatten(t);
        s.printAsList(t);
    }
    public void flattenOld(TreeNode root) {
        if(root==null) return;
        System.out.println(root.val);
        flattenOld(root.left);
        flattenOld(root.right);
    }
    public void printAsList(TreeNode root) {
        if(root==null) return;
        System.out.println(root.val);
        if(root.right!=null) printAsList(root.right);
    }
    public void flatten(TreeNode root) {
        if(root==null) return;
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
