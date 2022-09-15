import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;

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
        TreeNode t1 = new TreeNode(2);

        System.out.println(s.pseudoPalindromicPaths(t1));
        t1.left = new TreeNode(3);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(1);
        t1.right = new TreeNode(1);
        t1.right.right = new TreeNode(1);

        System.out.println(s.pseudoPalindromicPaths(t1));

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.left.left = new TreeNode(1);
        t2.right= new TreeNode(1);
        t2.left.right = new TreeNode(3);
        t2.left.right.right = new TreeNode(1);

        System.out.println(s.pseudoPalindromicPaths(t2));
    }
    public int pseudoPalindromicPaths (TreeNode root) {
//        HashMap<Integer,Integer> freq = new HashMap<>();
        HashSet<Integer> odds = new HashSet<>();
//        return countPalindromicPaths(root,freq);
        return countPalindromicPaths(root,odds);
    }


    public int countPalindromicPaths(TreeNode node,HashSet<Integer> odds) {
        if(node==null) return 0;

        if(odds.contains(node.val)) odds.remove(node.val);
        else odds.add(node.val);

        if(node.left==null && node.right==null) {
            if(odds.size()>1) return 0;
            else return 1;
        }

        HashSet<Integer> copy = new HashSet<>(odds);

        int count = 0;
        count += countPalindromicPaths(node.left,copy);
        count += countPalindromicPaths(node.right,odds);

        return count;
    }

    public int countPalindromicPaths(TreeNode node,HashMap<Integer,Integer> freq) {
        if(node==null) return 0;

        freq.put(node.val,freq.getOrDefault(node.val,0)+1);

        if(node.left==null && node.right==null) {
            if(countOdds(freq)>1) return 0;
            else return 1;
        }

        HashMap<Integer, Integer> copy = new HashMap<>(freq);

        int count = 0;
        count += countPalindromicPaths(node.left,copy);
        count += countPalindromicPaths(node.right,freq);

        return count;

    }

    public int countOdds(HashMap<Integer,Integer> freq) {
        int odds = 0;
//        System.out.println("START COUNT");
        for(int i : freq.values()) {
//            System.out.println(i);
            if(i%2!=0) odds++;
        }
//        System.out.println("END COUNT");
//        System.out.println("COUNT ODDS: "+odds);
        return odds;
    }
}
