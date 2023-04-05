import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.partitionString("abacaba"));
        System.out.println(s.partitionString("ssssss"));
    }
    public int partitionString(String s) {
        HashSet<Character> window = new HashSet<>();

        int l = 0, r = l, n = s.length();

        int count = 0;

        while(r <= n) {

            /*
            * begin a new window when we encounter
            * a previously seen char
            * or when we reach the end of the string
            * */
            if(r==n || window.contains(s.charAt(r))) {
//                System.out.println(s.substring(l,r));
                count++;
                if(r==n) return count;
                window.clear();
                l = r;
            }

            //general condition
            window.add(s.charAt(r));

            r++;
        }

        return count;

    }
}
