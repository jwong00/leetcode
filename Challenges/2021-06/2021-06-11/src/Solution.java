import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.stoneGameVII(new int[] {7,90,5,1,100,10,10,2}));
        System.out.println(s.stoneGameVII(new int[] {5,3,1,4,2}));

    }
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] sums = new int[n+1];
        HashMap<String,Integer> memo = new HashMap<>();

        for(int i=1;i<=n;i++) {
            sums[i] = sums[i-1] + stones[i-1];
        }

        return dfs(0,n-1,sums,memo);
    }

    public int dfs(int l, int r, int[] sums,HashMap memo) {
        if(l==r) return 0;
        String key = l+","+r;
        if(memo.containsKey(key)) return (int) memo.get(key);
        int L = sums[r] - sums[l]  - dfs(l,r-1,sums,memo);
        int R = sums[r+1] -  sums[l+1] - dfs(l+1,r,sums,memo);
        memo.put(key,Math.max(L,R));
        return (int)memo.get(key);
    }


}
