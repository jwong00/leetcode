class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subarraySum(new int[]{1,1,1},2));
        System.out.println(s.subarraySum(new int[]{1,2,3},3));
    }
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int[] lr = new int[n];
        lr[0] = nums[0];

        for(int i=1;i<n;i++) {
            lr[i] = nums[i] + lr[i-1];
        }

        int count = 0;
        for(int i=0;i<n;i++) {
            if(lr[i]==k) count++;

            for(int j=i+1;j<n;j++){
                if(lr[j]-lr[i]==k) count++;
            }
        }

        return count;
    }
}
