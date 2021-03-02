/* Problem doesn't specify that the data is sorted,
 * so optimizations can't be made assuming sortedness
 * */

class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean[] lookup = new boolean[nums.length+1];
        int duplicate = -1;

        for(int k=0;k<nums.length;k++) {
            if(!lookup[nums[k]]) lookup[nums[k]] = true;
            else duplicate = nums[k];
        }

        int[] result = new int[2];

        result[0] = duplicate;

        for(int k=1;k<lookup.length;k++) {
           if(!lookup[k]) {
               result[1] = k;
               break;
           }
        }

        return result;
    }
}
