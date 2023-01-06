class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.detectCapitalUse("USA"));
        System.out.println(s.detectCapitalUse("leetcode"));
        System.out.println(s.detectCapitalUse("Google"));
        System.out.println(s.detectCapitalUse("FlaG"));
    }
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(int i=0;i<word.length();i++) {
            if(Character.isUpperCase(word.charAt(i))) count++;
        }
        return count==0 || count==word.length() || (count==1 && Character.isUpperCase(word.charAt(0)));
    }
}
