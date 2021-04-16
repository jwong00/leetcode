import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeDuplicates("deeedbbcccbdak",3);
        s.removeDuplicates("abcd",2);
        s.removeDuplicates("pbbcggttciiippooaais",2);
    }
    public String removeDuplicates(String s, int k) {
        Deque<Character> key = new ArrayDeque<>();
        Deque<Integer> val = new ArrayDeque<>();

        //add each char from s to c
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            System.out.println("PROCESSING " + t);

            if (!key.isEmpty()) {
                if (key.peek() == t && val.peek() == k - 1) {
                    //remove top k-1 chars from both
//                    System.out.println(key.peek()+" "+k+ " "+val.peek());
                    for (int r = 0; r < k - 1; r++) {
//                        System.out.println("Popping char... "+key.peek() +" "+val.peek());
                        key.pop();
                        val.pop();
                    }
                } else {

                    if (t == key.peek()) val.push(val.peek() + 1);
                    else val.push(1);
                    key.push(t);

                    System.out.println("Pushing: " + t + " " + val.peek());
                }
            } else {
                System.out.println("Pushing: " + t + " " + 1);
                key.push(t);
                val.push(1);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!key.isEmpty()) {
            sb.append(key.removeLast());
        }
        System.out.println(sb.toString());

        return sb.toString();
    }


}

