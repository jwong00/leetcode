import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
    public List<Integer> findDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<Integer>();

        int n = nums.length;

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(nums[i] > n) return new ArrayList<>();

            if(nums[Math.abs(nums[i]) - 1] < 0) ans.add(Math.abs(nums[i]));

            nums[Math.abs(nums[i]) -1]  *= -1;

        }

        return ans;
    }
}
