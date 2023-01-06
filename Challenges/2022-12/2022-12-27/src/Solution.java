import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumBags(new int[]{2,3,4,5},new int[]{1,2,4,4},2));
        System.out.println(s.maximumBags(new int[]{10,2,2},new int[]{2,2,0},100));
    }
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;

        for(int i=0;i<n;i++) {
            capacity[i]-=rocks[i];
        }

        Arrays.sort(capacity);

        int ans = 0;

        //Syntax abuse? Lol..
        for(int i=0;i<n && additionalRocks>=capacity[i];ans++,additionalRocks-=capacity[i],i++);

//        for(int i=0;i<n && additionalRocks>=capacity[i];i++) {
//                ans++;
//                additionalRocks-=capacity[i];
//        }

        return ans;
    }
}
