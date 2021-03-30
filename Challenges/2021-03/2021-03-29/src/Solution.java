import java.lang.reflect.Array;
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
        q.right.left = new TreeNode(4);
        q.right.right = new TreeNode(5);

        System.out.println(s.flipMatchVoyage(q, new int[] {1,3,5,7,4}));
    }
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if(root==null) return null;

        ArrayList<Integer> result = new ArrayList<>();

        System.out.println(Arrays.toString(voyage));

        //iterative pre-order traversal
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        TreeNode cur, left, right;
        int count = 0;
        int size = 0;
        while(!st.isEmpty()) {
            cur = st.pop();
//            System.out.println("Proc node "+cur.val);

            size = st.size();
            //push the next two
            if(cur.right!=null) st.push(cur.right);
            if(cur.left!=null) st.push(cur.left);

            //next should be in the voyage, if not, flip, pop to old size, push again and check
            if(!st.isEmpty() && st.peek().val != voyage[count+1]) {
                flip(cur);
                while(st.size()>size) st.pop();
                if(cur.right!=null) st.push(cur.right);
                if(cur.left!=null) st.push(cur.left);

//                System.out.println("Nextval is " +st.peek().val+" and voyage[count] is "+voyage[count+1] );
                if(st.peek().val != voyage[count+1]) {
//                    System.out.println("HERE!");
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(-1);
                    return t;
                }
                else result.add(cur.val);

            }
            count++;
        }

//        System.out.println("RESULT: " +result);

        return result;
    }

    private void flip(TreeNode t) {
        if(t==null) return;
        TreeNode n = t.left;
        t.left = t.right;
        t.right = n;
    }
}
