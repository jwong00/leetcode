class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hasAllCodes("1001101000111",3));
    }
    public boolean hasAllCodes(String s, int k) {
        return naive(s,k);
    }

    private boolean naive(String s, int k) {
        boolean[] nums = new boolean[1<<k];
        for(int i=0;i<s.length()-k+1;i++) {
            nums[Integer.parseInt(s.substring(i,i+k),2)] = true;
        }
        for(int i=0;i<nums.length;i++) {
            if(!nums[i]) return false;
        }
        return true;
    }
}
