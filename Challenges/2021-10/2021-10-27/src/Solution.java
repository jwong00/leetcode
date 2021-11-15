import java.util.Arrays;

class Solution {

    boolean DEBUG = true;

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] n1 = new int[]{2,0,2,1,1,0};
        s.sortColors(n1);
        System.out.println(Arrays.toString(n1));
    }
    public void sortColors(int[] nums) {
        if(nums==null || nums.length==0) return;

//        freqsortColors(nums);
//        insertionsortColors(nums);
        mergesortColors(nums,0,nums.length-1);

//        quicksortColors(nums);
    }

    public boolean freqsortColors(int[] nums) {
        int[] freq = new int[3];

        for(int i=0;i<nums.length;i++) {
            if(nums[i]>2) return false;
            freq[nums[i]]++;
        }

        int freq_ptr = 0;
        for(int i=0;i<nums.length;i++) {
            if(freq_ptr > freq.length) return false;

            while(freq_ptr < freq.length && freq[freq_ptr]<=0) freq_ptr++;

            nums[i] = freq_ptr;
            freq[freq_ptr]--;

        }

        return true;
    }

    public boolean quicksortColors(int[] nums) {
        return false;
    }

    public boolean mergesortColors(int[] nums, int l, int r) {
        if(l<r) {
            int m = (l+r)/2;
            mergesortColors(nums,l,m);
            mergesortColors(nums,m+1,r);
            mergeHelper(nums,l,m,r);
        }

        return true;

    }

    public void mergeHelper(int[] nums,int l, int m, int r) {

        int[] cache = new int[r-l+1];
        int p1=l, p2=m+1;

        //merge the two sorted sections into cache
        for(int i=0;i<cache.length;i++) {
            if(p1<=m && p2<=r) {
                if(nums[p1]<nums[p2]) cache[i] = nums[p1++];
                else cache[i] = nums[p2++];
            }
            else if(p1<=m) cache[i] = nums[p1++];
            else cache[i] = nums[p2++];
        }

        //copy back into nums
        for(int i=l;i<=r;i++) {
            nums[i] = cache[i-l];
        }
    }

    public boolean insertionsortColors(int[] nums) {
        int n = nums.length;
        for(int i=1; i<n; i++) {
            for(int j=i; j > 0 && nums[j-1] > nums[j]; j--) {
                nums[j] = nums[j] ^ nums[j-1];
                nums[j-1] = nums[j] ^ nums[j-1];
                nums[j] = nums[j] ^ nums[j-1];
            }
        }

        return true;
    }
}