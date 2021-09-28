import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.sortArrayByParityII(new int[]{4,2,5,7})));
    }


    public int[] sortArrayByParityII(int[] nums) {
        return sortArraysByParityOptimized(nums);
    }

    public int[] sortArraysByParityOptimized(int[] nums) {
        int n = nums.length;
        int ptr_e = 0, ptr_o = 1;

        while(ptr_e <  n && ptr_o < n) {
            if( nums[ptr_e]%2!=0 && nums[ptr_o]%2==0) {
                nums[ptr_e] = nums[ptr_e] ^ nums[ptr_o];
                nums[ptr_o] = nums[ptr_e] ^ nums[ptr_o];
                nums[ptr_e] = nums[ptr_e] ^ nums[ptr_o];

                ptr_e+=2;
                ptr_o+=2;
            }
            if(ptr_o<n && nums[ptr_o]%2!=0) ptr_o +=2;
            if(ptr_e<n && nums[ptr_e]%2==0) ptr_e +=2;
        }

        return nums;
    }
    public int[] sortArrayByParityNaive(int[] nums) {
       int n = nums.length;

       Deque<Integer> evens = new ArrayDeque<>();
       Deque<Integer> odds = new ArrayDeque<>();

       for(int i=0;i<n;i++) {
           int val = nums[i];
           if(val%2==0) evens.add(val);
           else odds.add(val);
       }

       for(int k=0;k<n;k++) {
           if(k%2==0) nums[k] = evens.poll();
           else nums[k] = odds.poll();
       }

       return nums;
    }
}
