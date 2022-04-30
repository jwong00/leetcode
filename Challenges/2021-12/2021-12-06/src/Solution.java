class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostToMoveChips(new int[]{1,2,3}));
        System.out.println(s.minCostToMoveChips(new int[]{2,2,2,3,3}));
    }
    public int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;

        for(int i=0;i<position.length;i++) {
            if(position[i] % 2 == 0) even++;
            else odd++;
        }

        return Math.min(odd,even);
    }
}