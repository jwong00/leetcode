import java.util.Arrays;

class NumArray {
    public static void main(String[] args) {
        NumArray na = new NumArray(new int[]{-2,0,3,-5,2,-1});
        System.out.println(na.sumRange(0,2));
        System.out.println(na.sumRange(2,5));
        System.out.println(na.sumRange(0,5));
    }

    int[] nums;

    public NumArray(int[] nums) {
        for(int i=1;i<nums.length;i++) {
           nums[i]+=nums[i-1];
        }
        this.nums = nums;

    }

    public int sumRange(int left, int right) {
        return (left>0) ? this.nums[right]-this.nums[left-1] : this.nums[right];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
