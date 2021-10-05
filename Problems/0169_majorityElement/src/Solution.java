class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] k = {6,5,5};
        int[] q = {2,2,1,1,1,2,2};
        System.out.println(s.majorityElement(k));
        System.out.println(s.majorityElement(q));
    }

    public int majorityElement(int[] nums) {
        int last = nums[0];
        int count = 0;

        for(int i = 0; i<=nums.length-1; i++) {
            if(count==0) {
                last=nums[i];
                count=1;
            }
            else if(nums[i] == last) count++;
            else count--;
        }

        return last;
    }
}
