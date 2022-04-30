import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(s.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int ptr_pushed = 0, ptr_popped = 0;

        Deque<Integer> st = new ArrayDeque<>();

        while(ptr_pushed < pushed.length && ptr_popped < popped.length) {
            st.push(pushed[ptr_pushed++]);
            while(!st.isEmpty() && st.peek()==popped[ptr_popped]) {
                st.pop();
                ptr_popped++;
            }
        }

        if(ptr_popped<popped.length) return false;
        else return true;
    }
}
