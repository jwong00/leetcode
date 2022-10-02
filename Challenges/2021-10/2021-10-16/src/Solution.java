class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(4);
        t1.right.right = new TreeNode(1);
        t1.right.right.left = new TreeNode(-10);
        t1.right.right.left.right = new TreeNode(10);
        System.out.println(s.pathSum(t1,15));

    }

    public int pathSum(TreeNode root, int targetSum) {

        if(root==null) return 0;

        int ans = 0;
        ans += pathSumHelper(root, targetSum);

        ans += pathSum(root.left,targetSum);
        ans += pathSum(root.right,targetSum);

        return ans;
    }

    //count paths
    public int pathSumHelper(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int ans = 0;
        if(targetSum-root.val==0) {
//            System.out.println("Valid path ending with "+root.val);
//            ans++;
            return 1;
        }
//        ans += pathSum(root.left,targetSum-root.val);
        if(pathSum(root.left,targetSum-root.val) > 0) return 1;
        if(pathSum(root.right, targetSum-root.val) > 0) return 1;
//        ans += pathSum(root.right, targetSum-root.val);
        return 0;

//        return ans;
    }
}
