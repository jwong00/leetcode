class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] q = {3,2,1,5,6,4};
        System.out.println(s.findKthLargest(q,2));

    }
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums,0,nums.length-1,k);
    }

    public int findKthLargest(int[] nums, int lower, int upper, int k) {
        int index = partition(nums,lower,upper);

        if(index==nums.length-k) return nums[index];

        else if(index < nums.length-k) return findKthLargest(nums,index+1,upper,k);

        else return findKthLargest(nums,lower,index-1,k);
    }

    public int partition(int[] nums, int lower, int upper) {

        //set pivot
        int pivot_value = nums[upper];
        int pivot_index = lower; //not index of the above pivot value

        //sort relative to pivot
        for(int i = lower; i < upper; i++) {
            if(nums[i] < pivot_value) {
                //swap nums[i] and nums[pivot_index]
                int temp = nums[i];
                nums[i] = nums[pivot_index];
                nums[pivot_index] = temp;
                pivot_index++;
            }
        }

        //swap pivot to final location
        int temp = nums[pivot_index];
        nums[pivot_index] = nums[upper];
        nums[upper] = temp;

        return pivot_index;
    }

}
