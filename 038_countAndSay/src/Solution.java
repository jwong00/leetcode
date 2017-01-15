/**
 * Created by Glamdring on 1/12/2017.
 */
public class Solution {
    //1, 11, 21, 1211, 111221,312211,13112221,1113213211
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(6));
    }
    public String countAndSay(int n) {
        int v=1;
        while(n>1) {
            v=next(v);
            n--;
        }
        return Integer.toString(v);
    }
    public int next(int k) {
        String s = Integer.toString(k);
        int count=1;
        String next="";
        Character c = s.charAt(0); //get first char to start
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i)!=c) { //for new characters, store results, start new count
                next+=count;
                next+=c;
                c=s.charAt(i);
                count=1;
            }
            else { //continue count
                count++;
            }
        }

        next+=count;
        next+=c;

        return Integer.parseInt(next);
    }
}
