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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(s.goodNodes(root));
    }
//    private int countGood = 0;
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root,root.val);
    }

    public int goodNodesHelper(TreeNode node, int floor) {
        if(node==null) return 0;

        int countGood = 0;

        if(node.val >= floor) countGood++;

        floor = Math.max(floor,node.val);

        countGood += goodNodesHelper(node.left,floor);
        countGood += goodNodesHelper(node.right,floor);

        return countGood;

    }
}
