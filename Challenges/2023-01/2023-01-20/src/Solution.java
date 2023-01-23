import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findSubsequences(new int[]{4,6,7,7}));
        System.out.println(s.findSubsequences(new int[]{4,4,3,2,1}));
        System.out.println(s.findSubsequences(new int[]{4,4,3,2,1,3,4}));


    }
    public List<List<Integer>> findSubsequences(int[] nums) {

        //find ranges (intervals) whose values are non-decreasing
        int last_idx=0;
        ArrayList<Integer[]> intervals = new ArrayList<>();
        for(int i=1;i<nums.length;i++) {
            if(nums[i] < nums[i-1]) {
                intervals.add(new Integer[]{last_idx,i-1});
                last_idx = i;
            }
        }
        intervals.add(new Integer[]{last_idx,nums.length-1});

        //for each range,
        HashSet<List<Integer>> subsequences = new HashSet<>();
        for(Integer[] interval : intervals) {
            generate(interval,nums,subsequences);
        }


        return new ArrayList<>(subsequences);
    }

    //generates all subsequences with the integers between interval[a] and interval[b]
    public void generate(Integer[] interval, int[] nums, HashSet<List<Integer>> subsequences) {
        if(!interval[0].equals(interval[1])) {
//            System.out.println(Arrays.toString(interval));
            List<List<Integer>> cache = new ArrayList<>();
            cache.add(new ArrayList<>());
            for(int i=interval[0];i<=interval[1];i++) {
                int n = cache.size();
                for(int j=0;j<n;j++) {
                    List<Integer> subsequence = new ArrayList<>(cache.get(j));
                    subsequence.add(nums[i]);
                    cache.add(subsequence);
                }
            }

            for(List<Integer> subsequence : cache) {
                if(subsequence.size()>1) subsequences.add(subsequence);
            }
        }
    }
}
