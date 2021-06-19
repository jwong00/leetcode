import java.util.Arrays;

class NumArray {
    public static void main(String[] args) {
        NumArray na = new NumArray(new int[]{1,3,5});
        System.out.println(na.sumRange(0,2));
        na.update(1,2);
        System.out.println(na.sumRange(0,2));
    }

    int[] nums;
    int[] sums;
    int n;

    public NumArray(int[] nums) {
        if(nums.length>0) {
            n = nums.length;
            this.nums = nums;
            this.sums = new int[2 * n];
            buildSegmentTree(nums);
        }
    }

    public void buildSegmentTree(int[] nums){

        //initialize leaf nodes
        for(int i=n,j=0;i<2*n;i++,j++) {
            sums[i] = nums[j];
        }

        //iterate up the tree level-by-level
        for(int i=n-1;i>0;i--) {
            sums[i] = sums[2*i] + sums[2*i + 1];
        }
    }

    public void update(int index, int val) {
        index+=n;
        sums[index] = val;

        while(index>0) {
            int left = index, right = index;
            if(index % 2 == 0) right = index + 1;
            else                left = index - 1;

            sums[index/2] = sums[left] + sums[right];
            index /= 2;
        }
    }



    public int sumRange(int left, int right) {
        left += n;
        right += n;

        int sum = 0;
        while(left <= right) {
            if((left % 2) == 1) {
                sum+=sums[left];
                left++;
            }
            if((right % 2) == 0) {
                sum+=sums[right];
                right--;
            }
            left/=2;
            right/=2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 * */
