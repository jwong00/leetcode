class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxPower("leetcode"));
    }
    public int maxPower(String s) {
        char cur = '\0';
        int count = 1;
        int max_count = 0;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==cur) count++;
            else {
                cur = s.charAt(i);
                count = 1;
            }
            max_count = Math.max(max_count,count);
        }

        return max_count;
    }
}
