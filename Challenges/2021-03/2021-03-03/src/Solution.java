class Solution {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] g = {1};
        System.out.println(s.missingNumber(g));
    }
    public int missingNumber(int[] nums) {
        int max = nums.length; //numbers in nums range from 0 to n
        boolean negativeZero = false;

        for(int i=0;i<nums.length;i++) {
            System.out.println(i+" "+nums[i]);
            if(Math.abs(nums[i])==max) {
                max*=-1;
                System.out.println("Max found: "+max );
            }
            else if(nums[Math.abs(nums[i])]==0) {
                System.out.printf("Found integer %d at index %d, but nums[nums[%d]]==%d\n",nums[i],i,i,nums[nums[i]]);
                negativeZero=true;
            }
            else nums[Math.abs(nums[i])]*=-1;
        }

        if(max > 0) return max;

        for(int i=0;i<nums.length;i++) {
            if(nums[i]==nums.length) continue; //prevent OOB error
            if(nums[i]==0 && !negativeZero) return i; //boolean to "mark" 0 as negative
            if(nums[i]>0) return i; //if not negative, i is missing
        }

        return -1; //should never for defined input

    }
}
