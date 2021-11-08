class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(3));
    }

    // 1<=n<=19
    int[] bst = new int[20];

    // init some  base values
    public Solution() {
        bst[0] = 1;
        bst[1] = 1;
        bst[2] = 2;
    }
    public int numTrees(int n) {
        if(bst[n] > 0) return bst[n];

        for(int i=1;i<=n;i++) {
            bst[n] += helper1(n,i);
        }

        return bst[n];
    }

    //count bst with i as root
    public int helper1(int n, int i) {
        return numTrees(i-1) * numTrees(n-i);
    }
}
