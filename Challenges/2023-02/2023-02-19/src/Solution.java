import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(s.zigzagLevelOrder(node));
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        //iterate level by level with a counter
        //use parity of counter level as indicator of LR or RL
        LinkedList<TreeNode> level_cur = new LinkedList<TreeNode>();
        LinkedList<TreeNode> level_next;
        level_cur.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;!level_cur.isEmpty();i++) {
            level_next = new LinkedList<>();
            List<Integer> level_ans = new ArrayList<>();
            if(i%2==0) {
                while(!level_cur.isEmpty()) {
                    TreeNode cur = level_cur.pollFirst();
                    level_ans.add(cur.val);
                    if(cur.left!=null) level_next.offerLast(cur.left);
                    if(cur.right!=null) level_next.offerLast(cur.right);
                }
            }
            else {
                while(!level_cur.isEmpty()) {
                    TreeNode cur = level_cur.pollLast();
                    level_ans.add(cur.val);
                    if(cur.right!=null) level_next.offerFirst(cur.right);
                    if(cur.left!=null) level_next.offerFirst(cur.left);
                }
            }
            ans.add(level_ans);
            level_cur = level_next;
        }

        return ans;

    }
}
