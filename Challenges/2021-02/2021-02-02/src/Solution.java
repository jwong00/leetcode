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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode node = root;

        if(node.val < low || node.val > high) { //delete node.val by rotating in a newer val
            //should recurse down whichever side, which autocorrects entire subtree?

        }

        /* recurse down the subtrees */
        trimBST(node.left, low, high);
        trimBST(node.right, low, high);
        return node;
    }
}
