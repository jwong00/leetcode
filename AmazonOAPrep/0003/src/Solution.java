import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> window = new HashSet<>();
        int max_window_size = 0;
        int l=0,r=0;

        while(r<s.length()) {
            while(window.contains(s.charAt((r)))) {
                window.remove(s.charAt(l));
                l++;
            }
            if(!window.contains(s.charAt(r))) {
                window.add(s.charAt(r));
            }
            max_window_size = Math.max(max_window_size,window.size());
            r++;
        }

        return max_window_size;
    }
}
