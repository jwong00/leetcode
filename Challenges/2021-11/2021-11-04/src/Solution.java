
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(9);
        n.right = new TreeNode(20);
        n.right.left = new TreeNode(15);
        n.right.right = new TreeNode(7);
        System.out.println(s.sumOfLeftLeaves(n));
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return leftHelper(root.left) + rightHelper(root.right);
    }

    public int leftHelper(TreeNode node) {
        if(node==null) return 0;
        else if (node.left==null && node.right==null) return node.val;
        return leftHelper(node.left) + rightHelper(node.right);
    }

    public int rightHelper(TreeNode node) {
        if(node==null) return 0;
        return leftHelper(node.left) + rightHelper(node.right);
    }


}
