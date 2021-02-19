import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.minRemoveToMakeValid("lee(t(c)o)de)");
//        s.minRemoveToMakeValid("())(");
        s.minRemoveToMakeValid("))((");
    }
    public String minRemoveToMakeValid(String s) {
        if(s.length()==0 || s==null) return new String();

        Stack<Integer> c  = new Stack<Integer>();
        int[] deletions = new int[s.length()];
        deletions[0]=-1;

        char[] str = s.toCharArray();

        /* pushes left paren indices,
         * pops when right paren is found
         * if nothing to pop, must be hanging right paren,
         * store index for later deletion
         * */
        int k=0;
        for(int i=0; i<str.length; i++) {
            if(str[i]=='(') c.push(i);
            else if(str[i]==')') {
                if (!c.isEmpty()) c.pop();
                else {
                    deletions[k++] = i;
                }
            }
        }

        /* catch leftover left parens
         * store for deletion
         * */
        while(!c.isEmpty()) {
            deletions[k++] = c.pop();
        }

        /*
         * perform deletion here
         * */
        System.out.println(Arrays.toString(deletions));
        Arrays.sort(deletions,0,k);
        System.out.println(Arrays.toString(deletions));

        StringBuilder sb = new StringBuilder();
        for(int i=0,j=0; i<str.length; i++) {
            if(i!=deletions[j]) {
                sb.append(str[i]);
            }
            else j++;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
