import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.triangleNumber(new int[] {2,2,3,4}));
        System.out.println(s.triangleNumber(new int[] {4,2,3,4}));
//        System.out.println(Math.min(Integer.MAX_VALUE,Integer.MAX_VALUE+1));
    }
    public int triangleNumber(int[] nums) {

        Arrays.sort(nums);
        int count = 0;

        for(int i=0;i<nums.length-2;i++) {
            for(int j=i+1;j<nums.length-1;j++) {
                for(int k=j+1;k<nums.length;k++) {
                    System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);
                    if(nums[i]+nums[j]>nums[k]) count++;
                    else break;
                }
            }
        }
        return count;
    }
}
