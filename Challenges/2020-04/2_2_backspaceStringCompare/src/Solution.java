import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.backspaceCompare("abcd","abcde#"));
        System.out.println(s.backspaceCompare("ab#c","ad#c"));
        System.out.println(s.backspaceCompare("ab##","c#d#"));
        System.out.println(s.backspaceCompare("a##c","#a#c"));
        System.out.println(s.backspaceCompare("a#c","b"));
    }
    public boolean backspaceCompare(String S, String T) {
        System.out.println("S: "+S);
        System.out.println("T:" +T);
        Stack r = new Stack();

        for(Character c : S.toCharArray()) {
            if(Character.isAlphabetic(c)) r.push(c);
            else if(!r.isEmpty() && c == '#') r.pop();
        }

        Stack k = new Stack();
        for(Character c: T.toCharArray()) {
            if(Character.isAlphabetic(c)) k.push(c);
            else if(!k.isEmpty() && c == '#') k.pop();
        }

        while(!r.isEmpty() && !k.isEmpty()) {
            if(r.pop() != k.pop()) return false;
            if(r.isEmpty() ^ k.isEmpty()) return false;
        }
        return true;
    }
}
