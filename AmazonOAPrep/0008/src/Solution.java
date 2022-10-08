import java.util.ArrayDeque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("-324abdc"));
    }
    public int myAtoi(String s) {
        ArrayDeque<Character> st_char = new ArrayDeque<>();

        int i = 0, n = s.length();
        while(i < n && s.charAt(i)==' ') i++;
        if(s.charAt(i)=='+' || s.charAt(i)=='-') {
            st_char.push(s.charAt(i));
            i++;
        }
        while(i < n && Character.isDigit(s.charAt(i))) {
            if(s.charAt(i)!='0') st_char.push(s.charAt(i));
            i++;
        }
        int num = 0, mult = 1;

        while(st_char.size() > 0 && Character.isDigit(st_char.peek())) {
            num += mult*(st_char.pop()-48);
            mult *= 10;
        }

        if(st_char.size()>=1 && st_char.peek()=='-') num = -1*num;

        return num;
    }
}
