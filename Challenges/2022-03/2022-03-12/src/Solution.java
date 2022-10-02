import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        HashMap<Character,Character> map = new HashMap<>();

        map.put('{','}');
        map.put('[',']');
        map.put('(',')');


        for(int i=0;i<s.length();i++) {
           if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
               st.push(s.charAt(i));
           else {
               char c = st.pop();
               if(s.charAt(i)!=map.get(c)) return false;

           }

        }
        return true;
    }
}
