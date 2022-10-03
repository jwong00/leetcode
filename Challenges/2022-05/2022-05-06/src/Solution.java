import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates("abcd",2));
        System.out.println(s.removeDuplicates("deeedbbcccbdaa",3));
        System.out.println(s.removeDuplicates("pbbcggttciiippooaais",2));
    }
    public String removeDuplicates(String s, int k) {
        int n = s.length();

        Deque<Pair> st = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if(st.isEmpty() || st.peek().key!=c) st.push(new Pair(c));
            else if(st.peek().key==c ) {
                Pair cur = st.pop();

                cur.freq++;

                while(cur.freq >= k) cur.freq-=k;
                if(cur.freq > 0) st.push(cur);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            Pair p = st.pollLast();
            while(p.freq-- >0) sb.append(p.key);
        }

        return sb.toString();

    }
}

class Pair {
    char key;
    int freq;

    public Pair(char c) {
        key = c;
        freq = 1;
    }
}
