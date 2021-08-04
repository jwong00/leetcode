import java.lang.reflect.Array;
import java.util.*;

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
        TreeNode tn = new TreeNode(5);
        tn.left = new TreeNode(4);
        tn.right = new TreeNode(8);
        tn.left.left = new TreeNode(11);
        tn.left.left.left = new TreeNode(7);
        tn.left.left.right = new TreeNode(2);
        tn.right = new TreeNode(8);
        tn.right.left = new TreeNode(13);
        tn.right.right = new TreeNode(4);
        tn.right.right.left = new TreeNode(5);
        tn.right.right.right = new TreeNode(1);
        s.pathSum(tn,22);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> memo = new ArrayList<List<Integer>>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root,targetSum,0,memo,path);
        System.out.println(memo.toString());
        return memo;

    }

    public boolean dfs(TreeNode node, int targetSum, int currentSum, List<List<Integer>> memo, Deque<Integer> path) {
        if(node==null) return false;
        path.offer(node.val);
        currentSum+=node.val;
//        System.out.println("PROCESSING NODE W VAL: "+node.val);
        if(currentSum>targetSum) {
//            System.out.println("EXCEEDS TARGET: "+currentSum+"/"+targetSum);
            path.removeLast();
            return false;
        }
        if(node.left==null && node.right==null && currentSum==targetSum) {
//            System.out.println("MEETS TARGET AT LEAF: "+currentSum+"/"+targetSum);
            List<Integer> l = new ArrayList<>();
            for(Integer i : path) {
                l.add(i);
            }
            memo.add(l);
            path.removeLast();
            return true;
        }
        dfs(node.left,targetSum,currentSum,memo,path);
        dfs(node.right,targetSum,currentSum,memo,path);
        path.removeLast();
        return false;
    }
}
