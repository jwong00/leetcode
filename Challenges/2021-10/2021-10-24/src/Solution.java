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
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(s.getDepth(root));
        System.out.println(s.countNodes(root));
    }
    public int countNodes(TreeNode root) {
        int depth = getDepth(root);
        int total = (int)Math.pow(2,depth)-1;
        return total - helper(depth,root);
    }

    public int helper(int depth, TreeNode root) {
        if(depth==1 && root==null) return 1;
        if(root==null) return 0;

        return helper(depth-1,root.left) +  helper(depth-1,root.right);
    }

    /**/
    public int getDepth(TreeNode root) {
        TreeNode node = root;

        int depth = 0;
        while(node!=null) {
            node = node.left;
            depth++;
        }

        return depth;
    }
}
