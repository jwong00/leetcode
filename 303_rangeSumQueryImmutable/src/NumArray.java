class NumArray {
    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        NumArray numArray = new NumArray(nums);

        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
    }

    private final int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int t=0;
        for(int k=i;k<=j;k++) {
            t+=nums[k];
        }

        return t;

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */