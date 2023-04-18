class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mergeAlternately("abc","pqr"));
        System.out.println(s.mergeAlternately("ab","pqrs"));
        System.out.println(s.mergeAlternately("abcd","pq"));
    }
    public String mergeAlternately(String word1, String word2) {

        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;

        StringBuilder sb = new StringBuilder();

        while(i<m && j<n) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        while(i<m) {
            sb.append(word1.charAt(i++));
        }

        while(j<n) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();

    }
}
