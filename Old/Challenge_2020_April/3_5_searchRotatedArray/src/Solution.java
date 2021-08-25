class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] q = {9,10,1,2,3,4,5,6,7,8};

        System.out.println(s.search(q,2));
//        System.out.println(4+(5-4)/2);

    }
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        return search(nums,0,nums.length-1,target);
    }
    /*
    * Case 1; nums[left]<=nums[right]
    * Case 2; nums[left]>=nums[right]
    *
    * */

    // 9 10 1 2 3 4 5 6 7 8

    public int search(int[] nums, int left, int right,int target) {
        if(left==right || left==right-1) {
            if(nums[left] == target) return left;
            else if(nums[right] == target) return right;
            else return -1;
        }

        int middle = left + (right - left) / 2;
//        System.out.printf("Left: %d Middle: %d Right: %d\n",left, middle,right);
        if(between(target, nums[left], nums[middle])) return search(nums, left, middle, target);
        else if(between(target,nums[middle],nums[right])) return search(nums, middle, right, target);
        else { //search non monotonic section
            int k;
            if(!increasing(nums[left], nums[middle])) k = search(nums,left, middle,target);
            else k = search(nums,middle, right, target);

            return k;
        }
    }

    /*
    * Checks if a segment of the array is monotonically increasing
    * */
    public boolean between(int value, int lower, int upper) {
        if(lower>upper) return false;
        if(value>=lower && value<=upper) {
            System.out.printf("Between %d and %d\n", lower, upper);
            return true;
        }
        else return false;
    }

    public boolean increasing(int lower, int upper) {
        if(lower>upper) return false;
        else return true;
    }
}
