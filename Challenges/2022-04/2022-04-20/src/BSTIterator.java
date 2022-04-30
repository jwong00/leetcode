import java.util.ArrayList;

class BSTIterator {

    ArrayList<TreeNode> order;
    int ptr_index = 0;

    public BSTIterator(TreeNode root) {
        order = new ArrayList<TreeNode>();
        order.add(new TreeNode(Integer.MIN_VALUE));
        helper(root,order);
    }

    public void helper(TreeNode node, ArrayList<TreeNode> order) {
        if(node==null) return;

        helper(node.left,order);
        order.add(node);
        helper(node.right,order);
    }

    public int next() {
        ptr_index++;
        return order.get(ptr_index).val;
    }

    public boolean hasNext() {
        return ptr_index < order.size()-1;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
