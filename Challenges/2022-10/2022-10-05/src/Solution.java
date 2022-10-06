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
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(6);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(1);
        t1.right.left = new TreeNode(5);

        s.addOneRow(t1,1,2);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1) {
            TreeNode t = new TreeNode(val);
            t.left = root;
            return t;
        }
        else {
            helper(root,val,depth-1);
            return root;
        }
    }

    public void helper(TreeNode node, int val, int depth) {
        if(node==null) return;
        System.out.println(node.val);
        if(depth==1) {
            System.out.println("INSERT INTO NEXT LEVEL");
            TreeNode l = node.left, r = node.right;
            node.left = new TreeNode(val);
            node.left.left = l;
            node.right = new TreeNode(val);
            node.right.right = r;
        }
        helper(node.left,val,depth-1);
        helper(node.right,val,depth-1);
    }
}
