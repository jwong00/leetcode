import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
        TreeNode r = new TreeNode(12);
        r.left = new TreeNode(4);
        r.right = new TreeNode(5);
        r.left.left = new TreeNode(44);
        r.left.right = new TreeNode(3);
        r.right.right = new TreeNode(7);

        s.addOneRow(r,1,3);
    }


    /*  Add nodes with value v to depth d of tree with node root as root
    *   d is guaranteed to be within range of tree
    * */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1) {
            TreeNode r = new TreeNode(v);
            r.left = root;
            return r;
        }

        Deque<TreeNode> currentLevel = new ArrayDeque<>();
        Deque<TreeNode> nextLevel = null;
        currentLevel.offer(root);
        while(d-1>1) {
            nextLevel = new ArrayDeque<>();
            TreeNode cur;
            while(!currentLevel.isEmpty()) {
                cur = currentLevel.poll();
                if(cur!=null && cur.left!=null) nextLevel.offer(cur.left);
                if(cur!=null && cur.right!=null) nextLevel.offer(cur.right);
            }
            currentLevel = nextLevel;
            d--;
        }


        TreeNode cur;
        while(!currentLevel.isEmpty()) {
            cur = currentLevel.poll();
            TreeNode newLeft = new TreeNode(v), newRight = new TreeNode(v);
            newLeft.left = cur.left;
            cur.left = newLeft;
            newRight.right = cur.right;
            cur.right = newRight;


        }



        return root;
    }


}
