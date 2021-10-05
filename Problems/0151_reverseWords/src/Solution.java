public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("This is a string!"));
    }
    public String reverseWords(String s) {
        s = " "+s;
        String out = new String();
        for(int i = s.length()-1; i>=0; i--) {
            if(s.charAt(i) == ' ') {
                for(int k = i+1;k <= s.length()-1 && s.charAt(k) != ' ' ; k++) {

//                    System.out.println(s.charAt(k));
                    out=out.concat(Character.toString(s.charAt(k)));
                }
                out=out.concat(" ");
            }
            while(s.charAt(i)==' ' && i>0) {
                i--;
            }
        }
        return out;
    }
}
