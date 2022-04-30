
class Solution {
    public void recoverTree(TreeNode root) {

        helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public TreeNode helper(TreeNode node, int min, int max) {

        if(node==null) return null;

        TreeNode t = helper(node.left,min,node.val);
        if(t==null) t = helper(node.right,node.val,max);


        //both cur and a child violate min-max, swap
        if(t!=null && node.val > max && node.val < min) {
            node.val = node.val + t.val;
            t.val = node.val - t.val;
            node.val = node.val - t.val;
        }
        //only child violates
        else if(t!=null) return t;
        //only cur-node violates
        else if(node.val > max && node.val < min) return node;
        //neither violate
        return null;
    }
}
