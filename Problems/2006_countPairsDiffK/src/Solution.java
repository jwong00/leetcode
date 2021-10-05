/*
* 1 <= nums.length <= 200
* 1 <= nums[i] <=100
* 1 <= k <= 99
*
* */

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countKDifference(new int[]{1,2,2,1},1));
        System.out.println(s.countKDifference(new int[]{1,3},3));
        System.out.println(s.countKDifference(new int[]{3,2,1,5,4},2));
        System.out.println(s.countKDifference(new int[]{33,90,62,43,21,96,20,18,84,74,61,100,5,11,4,67,96,18,6,68,82,32,76,33,93,33,71,32,30,63,37,46,95,51,63,77,63,84,52,78,66,76,66,9,73,92,79,65,29,42},64));

    }
    public int countKDifference(int[] nums, int k) {
        int[] freq = new int[101];

        for(int i=0;i<nums.length;i++) {
            freq[nums[i]]++;
        }

        int ans = 0;
        for(int i=0;i<freq.length-k;i++) {
            if(freq[i]>0 && i < k + i && freq[k+i]>0) ans += (freq[i] * freq[k+i]);
        }

        return ans;
    }
}
