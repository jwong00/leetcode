import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/home//foo/"));
        System.out.println(s.simplifyPath("/../"));
    }
    public String simplifyPath(String path) {
        //try to break path up into '/' delimited tokens:
        String[] tokens = path.split("/+");
//        System.out.println(Arrays.toString(tokens));

        //build the path
        ArrayDeque<String> deque = new ArrayDeque<>();

        for(String token : tokens) {
            if(token.length()==0) continue;
            if(token.equals(".")) continue;
            if(token.equals("..") ) {
                if(!deque.isEmpty()) deque.pop();
                continue;
            }

            deque.push(token);

        }

        if(deque.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();

        while(!deque.isEmpty()) {
            sb.append('/');
            sb.append(deque.pollLast());
        }

        return sb.toString();
    }
}
