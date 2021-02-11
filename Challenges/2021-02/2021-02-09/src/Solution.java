class Solution {
    public TreeNode convertBST(TreeNode root) {
        process(root,0);
        return root;
    }

    public int process(TreeNode node,int sumOfGreater) {
        if(node.right!=null) {
            node.val += process(node.right,sumOfGreater);
        }
        node.val += sumOfGreater;
        int left=0;
        if(node.left!=null) {
            left = process(node.left,node.val);

        }
        return node.val + left;
    }

}
