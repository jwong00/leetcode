class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumSubarrayMins(new int[]{3,1,2,4}));
    }
    public int sumSubarrayMins(int[] arr) {
        int sumOfMin = 0;

        for(int i=0;i<arr.length;i++) {
            int min = arr[i];
            for(int j=i;j<arr.length;j++) {
                min = Math.min(min,arr[j]);
                sumOfMin += min;
            }
        }

        return sumOfMin % 1_000_000_007;
    }
}
