import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glamdring on 2/17/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode r = new TreeNode(1);
        r.right = new TreeNode(2);
        r.right.left = new TreeNode(3);
        System.out.println(s.postorderTraversal(r));
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList k = new ArrayList<>();
        if(root==null) return k;
        if(root.left!=null) k.addAll(postorderTraversal(root.left));
        if(root.right!=null) k.addAll(postorderTraversal(root.right));
        k.add(root.val);
        return k;
    }
}