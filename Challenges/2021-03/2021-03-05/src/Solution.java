import java.util.ArrayList;
import java.util.Deque;
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
        TreeNode r = new TreeNode(2147483647);
        r.left = new TreeNode(2147483647);
        r.right = new TreeNode(2147483647);

        Solution s = new Solution();

        System.out.println(s.averageOfLevels(r).toString());


    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();

        if(root==null) {
            averages.add(0.0);
            return averages;
        }

        LinkedList<TreeNode> currentLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();

        currentLevel.offer(root);
        TreeNode curNode;
        double sum = 0;
        double count = 0;

        while(!currentLevel.isEmpty()) {
            curNode = currentLevel.poll();
            sum+=curNode.val;
            count++;
            if(curNode.left!=null) nextLevel.offer(curNode.left);
            if(curNode.right!=null) nextLevel.offer(curNode.right);

            if(currentLevel.isEmpty()) {
                averages.add(sum/count);
                sum=0;
                count=0;
                currentLevel = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
            }
        }

        return averages;


    }
}
