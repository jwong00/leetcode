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

        int _lower = lower;
        int _upper = upper;

        if(_lower>=_upper) return nums[_upper];

        //set pivot
        int pivot_index = lower + ( (upper-lower) / 2 );
        int pivot_value = nums[pivot_index];

        //sort relative to pivot
        while(_lower < _upper ) {

            /*
            * compress the bounds towards the center if the value at
            * the bounds are on the correct side of the pivot
            */
            while(_lower <=_upper && nums[_lower] < pivot_value) _lower++;
            while(_lower<= _upper && nums[_upper] > pivot_value) _upper--;

            /*
            * each bound should now be on the wrong side of the pivot,
            * swap them
            */
            if(_lower<=_upper){
                int temp = nums[_lower];
                nums[_lower] = nums[_upper];
                nums[_upper] = temp;
                _lower++;
                _upper--;
            }
        }

        return pivot_index;
    }

}
