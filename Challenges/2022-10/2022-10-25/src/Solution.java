class Solution {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.arrayStringsAreEqual(new String[]{"ab","c"},new String[]{"a","bc"}));
        System.out.println(s.arrayStringsAreEqual(new String[]{"a","cb"},new String[]{"ab","c"}));
        System.out.println(s.arrayStringsAreEqual(new String[]{"abc","d","defg"},new String[]{"abcddefg"}));
    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder sb = new StringBuilder();

        for(String word : word1) {
            sb.append(word);
        }
        String str1 = sb.toString();

        sb = new StringBuilder();
        for(String word : word2) {
            sb.append(word);
        }
        String str2 = sb.toString();

        return str1.equals(str2);

    }
}