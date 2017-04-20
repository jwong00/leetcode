import java.util.ArrayList;

/**
 * Created by Glamdring on 4/17/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] neighborhood = {13,23,8,5,24,7,2,8};
        int[] nn = {12,33};
        System.out.println(s.rob(neighborhood));
        System.out.println(s.rob(nn));
    }
    public int rob(int[] nums) {
        ArrayList<Integer> max = new ArrayList<>();

        if(nums.length<1) return 0;
        else if (nums.length==1) return nums[0];
        else if(nums.length==2) return nums[1]>nums[0] ? nums[1] : nums[0];

        /* initialize first two values of max array */
        max.add(nums[0]);
        if(nums[1]>nums[0]) max.add(nums[1]);
        else max.add(nums[0]);

        /* determine max money possible up to each house */
        int cur;
        for(int i=2;i<nums.length;i++) {
            cur = nums[i]+max.get(i-2);
            if(cur > max.get(i-1)) max.add(cur);
            else max.add(max.get(i-1));
        }

        return max.get(max.size()-1);

    }
}
