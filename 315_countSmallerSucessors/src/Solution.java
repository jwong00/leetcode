import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSmaller(new int[] {5,2,6,1}));
    }
    public List<Integer> countSmaller(int[] nums) {
        return countSmallerBruteForce(nums);
    }

    public List<Integer> countSmallerBruteForce(int[] nums) {

        List<Integer> result = new ArrayList<>();

        System.out.println(Arrays.toString(nums));

        for(int i=0;i<nums.length;i++) {
            int c=0;
            for(int j=i+1;j<nums.length;j++) {
                if(nums[j]<nums[i])  c++;
            }
            result.add(c);
        }

        return result;
    }
}
