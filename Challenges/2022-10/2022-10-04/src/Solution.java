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
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(4);
        t1.left.left = new TreeNode(11);
        t1.left.left.left = new TreeNode(7);
        t1.left.left.right = new TreeNode(2);
        t1.right = new TreeNode(8);
        t1.right.right = new TreeNode(4);
        t1.right.right.right = new TreeNode(1);
        t1.right.left = new TreeNode(13);
        System.out.println(s.hasPathSum(t1,22));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        targetSum-=root.val;
        if(root.left==null && root.right==null) return targetSum==0;
        return hasPathSum(root.left,targetSum) || hasPathSum(root.right, targetSum);
    }

}
