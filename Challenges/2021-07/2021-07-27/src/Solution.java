import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(new int[]{-1,2,1,-4},1));
    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        return better(nums,target);
    }

    public int better(int [] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i=0;i<n && diff!=0;i++) {
            int lo=i+1, hi=n-1;
            while(lo<hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if(Math.abs(sum-target)<Math.abs(diff)) diff=target-sum;
                if(sum<target) lo++;
                else hi--;
            }
        }

        return target-diff;

    }

    public int naive(int[] nums, int target) {
        int  n = nums.length;
        int sum = nums[0]+nums[1]+nums[2];
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                for(int k=j+1;k<n;k++) {
                    if(Math.abs(target-(nums[i]+nums[j]+nums[k]))<Math.abs(target-sum))
                        sum = nums[i]+nums[j]+nums[k];
                }
            }
        }

        return sum;
    }
}
