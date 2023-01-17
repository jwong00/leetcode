
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        TreeNode m = new TreeNode(1);
        m.left = new TreeNode(2);
        System.out.println(s.isSameTree(m,n));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null^q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
