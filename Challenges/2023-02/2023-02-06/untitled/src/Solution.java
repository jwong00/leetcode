import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.shuffle(new int[]{2,5,1,3,4,7},3)));
    }
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
//        system.out.println(nums.length);

        int j=0,k=n;
//        system.out.println(nums[j]);
//        system.out.println(nums[k]);

    for(int i=0;i<2*n;i++) {
            if(i%2==0) ans[i] = nums[j++];
            else ans[i] = nums[k++];

            if(j > 2*n || k > 2*n) break;
        }

        return ans;

    }
}
