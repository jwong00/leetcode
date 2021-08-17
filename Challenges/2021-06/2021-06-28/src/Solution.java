import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates("abbaca"));
        System.out.println(s.removeDuplicates("azxxzy"));
    }
    public String removeDuplicates(String s) {
        if(s.length()==0 || s==null) return new String();
        Deque<Character> characters = new ArrayDeque<>();

        for(int i=0;i<s.length();i++) {
            if(characters.isEmpty() || characters.peek()!=s.charAt(i)) characters.push(s.charAt(i));
            else if(characters.peek()==s.charAt(i)) characters.pop();
        }

        StringBuilder sb = new StringBuilder();

        while(!characters.isEmpty()) {
            sb.append(characters.pollLast());
        }

        return sb.toString();
    }
}
