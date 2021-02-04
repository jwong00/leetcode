/* Longest Harmonious Subsequence */

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] seq = {1,3,2,2,5,2,3,7};

        int[] seq2 = {1,2,3,4};

        System.out.println(s.findLHS(seq));
        System.out.println(s.findLHS(seq2));


    }
    public int findLHS(int[] nums) {
        int global_min = nums[0];
        int global_max = nums[0];

        //determine global max
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]>global_max) global_max = nums[i];
        }
//        the number of unique integers in nums < less nums.length
        int[] frequencies = new int[global_max+1];

        //determine frequencies of each integer in nums
        for(int i = 0; i < nums.length; i++) {
            frequencies[nums[i]]++;
            if(nums[i]<global_min) global_min = nums[i];
        }

        //if nums contains only one unique integer
        if(global_max-global_min < 1) return 0;

        int harmSubseqLengthMax = 0;

        for(int k = 0; k < global_max; k++) {
            int harmSubseqLength = frequencies[k] + frequencies[k + 1];
            if(     frequencies[k]>0 &&
                    frequencies[k+1]>0 &&
                    harmSubseqLength > harmSubseqLengthMax)
                harmSubseqLengthMax = harmSubseqLength;
        }

        return harmSubseqLengthMax;


    }
}
