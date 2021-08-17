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
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }

    public int dfs(TreeNode node, int max) {
        if(node==null) return 0;
        int good = 0;
        if(node.val >= max) good++;
        max = Math.max(node.val,max);
        good+=dfs(node.left,max);
        good+=dfs(node.right,max);

        return good;
    }
}
