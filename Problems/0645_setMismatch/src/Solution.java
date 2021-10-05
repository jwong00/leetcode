import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] test = {1,2,2,4};

        Solution s = new Solution();
        System.out.println(Arrays.toString(s.findErrorNums(test)));
    }
    public int[] findErrorNums(int[] nums) {
        int[] lookupTable = new int[nums.length];
        int[] mismatch = new int[2];
        //default value is 0 for all elements
        for(int i=0;i<nums.length;i++) {
            lookupTable[nums[i]-1]++;
        }
        for(int i=0;i<lookupTable.length;i++) {
            if(lookupTable[i]==2) mismatch[0]=i+1;
            if(lookupTable[i]==0) mismatch[1]=i+1;
        }
        return mismatch;
    }
}
