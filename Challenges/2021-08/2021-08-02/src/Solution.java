import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2,7,11,15},9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3,2,4},6)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3,3},6)));

    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int value = target-nums[i];
            if(map.containsKey(value)) return new int[]{map.get(value),i};
            map.put(nums[i],i);
        }

        return new int[]{-1,-1};
    }
}
