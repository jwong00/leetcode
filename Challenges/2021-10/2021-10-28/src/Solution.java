import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        if( nums==null || nums.length < 3 ) return new ArrayList<List<Integer>>();

        int n = nums.length;
        HashSet<Integer> numset = new HashSet<Integer>();

        for(int i=0; i<n; i++) {
            numset.add(nums[i]);
        }

//        nums = numset.stream().mapToInt(Number::intValue).toArray();
//        n = nums.length;
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        ArrayList<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n-3;i++) {
            int l = i+1, r = n-1;
            while(l<r) {
                int t = nums[i] + nums[l] + nums[r];
                if(t < 0 ) l++;
                else if(t > 0) r--;
                else {
                    System.out.println("HERE");
                    ArrayList<Integer> triple = new ArrayList<>();
                    triple.add(nums[i]);
                    triple.add(nums[l]);
                    triple.add(nums[r]);
                    ans.add(triple);
                    l++;
                    r--;
                    while(l<r && nums[l] == nums[l-1]) l++;
                }
            }
        }

        return ans;
    }
}
