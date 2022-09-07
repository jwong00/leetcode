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
    public TreeNode pruneTree(TreeNode root) {

    }

    public boolean search(TreeNode node) {

        if(node==null) return true;

        //base
        if(node.left==null && node.right==null) {
            if(node.val==0) {
                //mark
                node.val = -1;
                return false;
            }
            else return true;
        }

        //general case
        if(node.val==0 && !search(node.left) && !search(node.right)) {

        }



    }
}
