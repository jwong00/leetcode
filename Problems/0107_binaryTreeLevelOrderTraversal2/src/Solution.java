import com.sun.source.tree.Tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void main(String args[]) {
        Solution s = new Solution();
        TreeNode k = new TreeNode(3);
        k.left = new TreeNode(9);
        k.right = new TreeNode(20);
        k.right.left = new TreeNode(15);
        k.right.right = new TreeNode(7);
        System.out.println(s.levelOrderBottom(k));
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return new LinkedList<>();

        LinkedList<TreeNode> curLevel = new LinkedList<>();
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        List<List<Integer>> t = new ArrayList<List<Integer>>();
        curLevel.offer(root);

        TreeNode cur;
        ArrayList<Integer> temp = new ArrayList<>();

        while(!curLevel.isEmpty()){
            cur = curLevel.pollFirst();

            if(cur!=null) {
                temp.add(cur.val);
                nextLevel.offerLast(cur.left);
                nextLevel.offerLast(cur.right);
            }
            if(curLevel.isEmpty()){
                if (!temp.isEmpty()) t.add(temp);
                curLevel = nextLevel;
                temp = new ArrayList<>();
                nextLevel = new LinkedList<>();
            }
        }
        Collections.reverse(t);
        return t;
    }
}
