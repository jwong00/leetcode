import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.answerQueries(new int[]{4,5,2,1},new int[]{3,10,21})));
        System.out.println(Arrays.toString(s.answerQueries(new int[]{2,3,4,5},new int[]{1})));
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length, n = nums.length;

        int[] answer = new int[m];

        Arrays.sort(nums);
        for(int i=1;i<n;i++) {
            nums[i]+=nums[i-1];
        }

        for(int i=0;i<m;i++) {
           for(int j=0;j<=n;j++) {
               if(j==n) {
                   answer[i] = n;
                   break;
               }
               if(queries[i]<nums[j]) {
                   answer[i] = j;
                   break;
               }
           }
        }

        return answer;

    }
}
