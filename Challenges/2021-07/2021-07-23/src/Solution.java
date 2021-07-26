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

        if(!dfs(root)) return null;

        dfs(root);
        return root;
    }

    public boolean dfs(TreeNode node) {
        if(node==null) return false;
        if(!dfs(node.left)) node.left = null;
        if(!dfs(node.right)) node.right = null;
        if(node.left!=null || node.right !=null || node.val==1) return true;
        return false;
//        if(!dfs(node.left) && !dfs(node.right)) return false;

    }
}
