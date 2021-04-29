class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.searchRange(new int[] {5,7,7,8,8,10},8);
        s.searchRange(new int[] {5,7,7,8,8,10},6);
        s.searchRange(new int[] {1,1,2},1);
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int l=0,r=nums.length-1,m = l+(r-l)/2;
        while(l<=r) {
            m = l +(r-l)/2;
            //check if present at mid
            if(nums[m]==target) break;
            //if greater, ignore left
            if(nums[m]<target) l=m+1;
            //if smaller, ignore right
            if(nums[m]>target) r=m-1;

        }
        System.out.println("INDEX+VAL: "+m+" "+nums[m]);

        if(nums[m]!=target) return new int[] {-1,-1};

        l=m;
        r=m;
        while(l>0 && nums[l-1]==nums[m]) {
            l--;
        }

        while(r+1<nums.length && nums[r+1]==nums[m]) {
            r++;
        }
        System.out.println(l+" "+r);

        return new int[] {l,r};
    }
}
