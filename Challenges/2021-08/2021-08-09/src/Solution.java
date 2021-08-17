import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addStrings("11","123"));
        System.out.println(s.addStrings("456","77"));
        System.out.println(s.addStrings("0","0"));
        System.out.println(s.addStrings("1","9"));
        System.out.println(s.addStrings("1","19"));
    }
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();

        boolean carry = false;
//        StringBuilder digits = new StringBuilder();
        Deque<Integer> digits = new ArrayDeque<>();

        for(int i=m-1,j=n-1; i>=0 || j>=0; i--,j--) {
            int t = 0;
            //add both nums
            if(i<0) t = num2.charAt(j)-'0';
            else if(j<0) t = num1.charAt(i)-'0';
            else if(j>=0 && i>=0) t = num1.charAt(i)-'0' + num2.charAt(j)-'0';

            //add carry
            if(carry) t+=1;

            //modulo, append remainder to string, determine if carry
            digits.offerFirst(t%10);

            if(t>=10) carry=true;
            else carry=false;

        }

        if(carry) digits.offerFirst(1);

//        System.out.println(digits.toString());

        StringBuilder ans = new StringBuilder();

        for(Integer i : digits) {
            ans.append(i);
        }

        return ans.toString();
    }
}
