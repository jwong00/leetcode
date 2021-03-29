import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        s.flipMatchVoyage(q, new int[] {1,3,2});
    }
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if(root==null) return null;

        ArrayList<Integer> result = new ArrayList<>();

        System.out.println(Arrays.toString(voyage));

        //iterative pre-order traversal
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        TreeNode cur, last=null;
        int count = 0;
        while(!st.isEmpty()) {
            cur = st.pop();
            //process cur

            //if cur has two children, peek left and see if it matches voyage
            //if not, flip, and if still not, return -1

            if(cur.right!=null) st.push(cur.right);
            if(cur.left!=null) st.push(cur.left);
            count++;
        }

        return result;
    }

    private void flip(TreeNode t) {
        if(t==null) return;
        TreeNode n = t.left;
        t.left = t.right;
        t.right = n;
    }
}
