import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(s.summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
    public List<String> summaryRanges(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<>();

        int a = nums[0], b = a;
        List<String> ans = new ArrayList<>();

        for(int i=1;i<nums.length;i++) {
            if(b+1 == nums[i]) b = nums[i];
            else {
                if(a!=b) ans.add(a+"->"+b);
                else ans.add(a+"");
                a = nums[i];
                b = a;
            }
        }

        //add the last one
        if(a!=b) ans.add(a+"->"+b);
        else ans.add(a+"");

        return ans;
    }
}
