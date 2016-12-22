import java.util.Arrays;

/**
 * Created by Glamdring on 9/29/2016.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution.
 *
 *  Example:
 *   Given nums = [2, 7, 11, 15], target = 9,
 *   Because nums[0] + nums[1] = 2 + 7 = 9,
 *   return [0, 1].
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(nums,9)));
    }

    public int[] twoSum(int[] nums, int target) {
        int length=nums.length;
        int[] answer=new int[2];
        answer[0]=0;
        answer[1]=0;

        for(int i=0;i<length;i++) {
            for(int j=i+1;j<length;j++) {
                if(nums[i]+nums[j]==target) {
                    answer[0]=i;
                    answer[1]=j;
                    return answer;
                }
            }
        }
        //System.out.println("No solution");
        return answer;
    }
}