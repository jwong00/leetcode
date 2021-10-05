/**
 * Created by Glamdring on 2/16/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = new TreeNode(2);
//                root1.left = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);
        System.out.println(s.isSameTree(root1, root2));

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null ^ q==null) return false;
        else if (p==null && q==null) return true;
        else if(p.val != q.val) return false;
        else if(p.left != null || p.right != null || q.left != null || q.right != null)
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        else return true;
    }
}
