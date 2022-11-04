import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.checkSubarraySum(new int[]{23,2,4,6,7},6));
//        System.out.println(s.checkSubarraySum(new int[]{23,2,6,4,7},6));
//        System.out.println(s.checkSubarraySum(new int[]{23,2,6,4,7},13));
//        System.out.println(s.checkSubarraySum(new int[]{23,2,4,6,6},7));
        System.out.println(s.checkSubarraySum(new int[]{5,0,0,0},3));
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer,Integer> r = new HashMap<>(Map.of(0,0));

        for(int i=0,sum=0;i<n;i++) {
            sum+=nums[i];
            if(!r.containsKey(sum%k)) r.put(sum%k,i+1);
            else if (r.get(sum%k)<i) return true;
        }

        return false;
    }
}
