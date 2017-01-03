import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Glamdring on 12/19/2016.
 */

/*
    Some properties
        1. Always starts with opening paren
        2. Never close with opening paren
        3. For each opening paren, there is a closing paren after it
        4. Push on stack to open a paren, pop to close
        5. Tree representation of multiple possibilities? Root always open, leaves always close

 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(1));
        System.out.println(s.generateParenthesis(2));
        System.out.println(s.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        String p = "(";
        List validParens = new ArrayList<String>();
        nextParens(validParens,p,n-1,n);
        return validParens;
    }

    public void nextParens(List<String> l, String p, int open, int close) {
        if(open>0) nextParens(l,p+"(",open-1,close);
        if(close>0) nextParens(l,p+")",open,close-1);
        if(open==0 && close==0) if(isValid(p)) {
            l.add(p);
        }
    }

    public boolean isValid(String s) {
        Stack<Character> p = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') p.push(')');
            else if(p.isEmpty() || s.charAt(i) != p.pop()) return false;
        }
        if(!p.isEmpty()) return false;
        else return true;
    }
}
