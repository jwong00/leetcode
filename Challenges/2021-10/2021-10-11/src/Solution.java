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
        n.left.left = new TreeNode(3);
        n.right = new TreeNode(4);

        System.out.println(s.getLength(n,0));
    }
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null) return 0;

        //diameter of this node
        int node_diameter = getLength(root.left,0) + getLength(root.right,0);

        //diameter of children
        int children_diameter = Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));

        return Math.max(node_diameter,children_diameter);

    }

    public int getLength(TreeNode node,int count) {
//        if(node!=null && node.left==null && node.right==null) return count;
        if(node==null) return count-1;
        else return Math.max(getLength(node.left,count+1),getLength(node.right,count+1));
    }


}
