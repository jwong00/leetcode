import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.toLowerCase("BLAhhhh"));
    }
    public String toLowerCase(String s) {
        if(s==null) return "";
        char[] c = s.toCharArray();
        StringBuilder lower = new StringBuilder();
        for(int i=0;i<c.length;i++) {
            if(c[i]>=65 && c[i]<=90) {
                c[i]+=32;
            }
            lower.append(c[i]);
        }
        return lower.toString();
    }
}