class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findPeakElement(new int[]{1,2,3,1}));
        System.out.println(s.findPeakElement(new int[]{1,2,1,3,5,6,4}));

    }
    public int findPeakElement(int[] nums) {
//        return findPeakElementLinear(nums);
        return findPeakElementBinary(nums);
    }

    public int findPeakElementBinary(int[] nums) {
        int l=0,r=nums.length-1,m=(r-l)/2;
        while(l<r) {
            m=l+(r-l)/2;
            if(m==nums.length-1) return m;
            if(nums[m]>nums[m+1]) r=m;
            else l=m+1;
        }
        return l;
    }

    public int findPeakElementLinear(int[] nums) {
        if(nums.length==1) return nums[0];
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]>nums[i+1]) return i;
        }
        return nums.length-1;
    }
}
