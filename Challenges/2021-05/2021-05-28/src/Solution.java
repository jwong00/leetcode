import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumUniqueSubarray(new int[] {4,2,4,5,6}));
        System.out.println(s.maximumUniqueSubarray(new int[] {5,2,1,2,5,2,1,2,5}));

    }
    public int maximumUniqueSubarray(int[] nums) {
        if(nums==null || nums.length==0) return 0;

        HashSet<Integer> window = new HashSet<>();

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int l=0,r=0;r<nums.length;r++) {
            while(window.contains(nums[r])) {
                sum-=nums[l];
                window.remove(nums[l++]);
            }
            sum+=nums[r];
            window.add(nums[r]);
            max = Math.max(max,sum);
        }

        return max;
    }
}
