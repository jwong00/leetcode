import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<>();

        int n = nums.length;

        boolean[] hash = new boolean[n+1];

        for(int i=0;i<n;i++) {
            if(nums[i]<=n) hash[nums[i]] = true;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=n;i++) {
            if(!hash[i]) ans.add(i);
        }

        return ans;
    }
}
