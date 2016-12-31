import java.util.HashSet;
import java.util.Stack;

/**
 * Created by Glamdring on 12/19/2016.
 */
public class Solution {
    public HashSet<Character> openParens;
    public HashSet<Character> closeParens;

    public Solution() {
        openParens = new HashSet<>();
        openParens.add('(');
        openParens.add('[');
        openParens.add('{');

        closeParens = new HashSet<>();
        closeParens.add(')');
        closeParens.add(']');
        closeParens.add('}');
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int i=1;
        System.out.println(i++ +" "+s.isValid("()!"));
        System.out.println(i++ +" "+s.isValid("()()()[]{}{}{}"));
        System.out.println(i++ +" "+s.isValid("((()))"));
        System.out.println(i++ +" "+s.isValid("([)]"));
        System.out.println(i++ +" "+s.isValid("[{)])()({}]["));
        System.out.println(i++ +" "+s.isValid("[]"));
        System.out.println(i++ +" "+s.isValid("{})"));
        System.out.println(i++ +" "+s.isValid("}{"));
        System.out.println(i++ +" "+s.isValid(")("));
        System.out.println(i++ +" "+s.isValid("]["));
        System.out.println(i++ +" "+s.isValid("()"));
        System.out.println(i++ +" "+s.isValid("("));



    }

    public boolean isValid(String s) {
        Stack<Character> p = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') p.push(')');
            else if(s.charAt(i)=='[') p.push(']');
            else if(s.charAt(i)=='{') p.push('{');
            else if(p.isEmpty() || s.charAt(i) != p.pop()) return false;
        }
        if(!p.isEmpty()) return false;
        else return true;
    }
    /*public boolean isValid(String s) {
        Stack<Character> p = new Stack<>();

        if(isClose(s.charAt(0))) return false;

        for(int i=0; i<s.length(); i++) {
            if(!isParen(s.charAt(i))) return false;

            if(isOpen(s.charAt(i))) p.push(s.charAt(i)); //add
            else if(isClose(s.charAt(i))) {
                if(p.isEmpty()) return false;
                if(!isPair(p.peek(),s.charAt(i))) return false;
                else p.pop();
            }
        }
        if(p.isEmpty()) return true;
        else return false;
    }*/

    public boolean isPair(Character first ,Character second) {
        if     (first=='(' && second==')') return true;
        else if(first=='[' && second==']') return true;
        else if(first=='{' && second=='}') return true;
        else                               return false;
    }

    public boolean isOpen(Character c) {
        if(openParens.contains(c)) return true;
        else return false;
    }
    public boolean isClose(Character c) {
        if(closeParens.contains(c)) return true;
        else return false;
    }
    public boolean isParen(Character c) {
        if(openParens.contains(c) || closeParens.contains(c)) return true;
        else return false;
    }

}
