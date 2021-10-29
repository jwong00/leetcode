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

        freqsortColors(nums);


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

    public boolean mergesortColors(int[] nums) {
        return false;
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