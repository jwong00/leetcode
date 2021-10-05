import java.util.Arrays;

class NumArray {
    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        NumArray numArray = new NumArray(nums);

        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));

        int[] nums2 = {1,4,-6};
        numArray = new NumArray(nums2);

        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(1,2));
        System.out.println(numArray.sumRange(0,1));
    }

    private int[] nums;

    public NumArray(int[] nums) {
        if(nums.length<1) return;
        else this.nums = new int[nums.length];

        this.nums[0] = nums[0];

        for(int i=1;i<nums.length;i++) {
            this.nums[i]=nums[i]+this.nums[i-1];
        }
        System.out.println(Arrays.toString(this.nums));
    }

    public int sumRange(int i, int j) {
        if(i<1) return this.nums[j];

        return this.nums[j]-this.nums[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */