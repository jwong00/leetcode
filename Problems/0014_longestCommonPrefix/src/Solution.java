class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{"leetcode","leet","let"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        int length = strs[0].length();

        for(int i=1;i<strs.length;i++) {
            length = Math.min(length,helper(strs[0],strs[i]));
        }

        return strs[0].substring(0,length);
    }

    public int helper(String w1,String w2) {
        int length = Math.min(w1.length(),w2.length());
        int common = 0;
        for(int i=0;i<length;i++) {
            if(w1.charAt(i)==w2.charAt(i)) common++;
            else break;
        }
        return common;
    }
}
