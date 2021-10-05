class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseVowels("leetcode"));
        System.out.println(s.reverseVowels("hell"));
    }
    public String reverseVowels(String s) {

        StringBuilder sb = new StringBuilder();

        for(int i=0,j=s.length();i<s.length();i++) {
            if( !isVowel(s.charAt(i)) ) sb.append(s.charAt(i));
            else {
                do {
                    --j;
                }
                while(!isVowel(s.charAt(j)));
                sb.append(s.charAt(j));
            }
        }

        return sb.toString();
    }

    static boolean isVowel(char c) {
        String v = "aeiouAEIOU";
        return (v.indexOf(c) != -1) ? true : false;
    }

}
