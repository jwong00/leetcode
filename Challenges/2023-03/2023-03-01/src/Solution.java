import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(Arrays.toString(s.sortArray(new int[]{5,2,1,3})));
        System.out.println(Arrays.toString(s.sortArray(new int[]{5,2,1,3,2,88,34,21,3,0})));
    }
    public int[] sortArray(int[] nums) {
//        return quicksort(nums);
        return mergesort(nums);
    }
    private int[] quicksort(int[] nums) {
        return nums;
    }
    private int[] mergesort(int[] nums) {
        return mergesort_helper(nums);
    }
    private int[] mergesort_helper(int[] nums) {

        //we don't really want to recurse down to
        //a subarray of sz 1, so return at 2
//        if(nums.length==2 ) {
//            if(nums[0]>nums[1]) swap(nums);
//            return nums;
//        }

        if(nums.length==1) return nums;

        //resurively call on LEFT and RIGHT part of nums
        //treat return as SORTED lists:
        int[] L = mergesort_helper(Arrays.copyOfRange(nums, 0, nums.length / 2));
        int[] R = mergesort_helper(Arrays.copyOfRange(nums, nums.length / 2, nums.length));

        //merge them, this is where SORT happens:
        int[] merged = new int[L.length+R.length];
        for(int i=0,j=0;i<L.length&&j<R.length;) {
            if(L[i]<=R[j]) merged[i+j] = L[i++];
            else merged[i+j] = R[j++];
        }

        return merged;
    }

    //SWAP helper method
    //no safety here; doesn't check that nums.length==2
    //elements after nums[1] are silently ignored, but this shouldn't bed a problem
    private void swap(int[] nums) {
        nums[0] = nums[0]^nums[1];
        nums[1] = nums[0]^nums[1];
        nums[0] = nums[0]^nums[1];
    }

}


