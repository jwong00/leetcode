class Solution {

    public static void main(String[] args) {

        Solution s = new Solution();

        System.out.println(s.isSubsequence("tec","technology"));
        System.out.println(s.isSubsequence("tea","technology"));
    }
    public boolean isSubsequence(String s, String t) {

        if(s.length()==0) return true;

        int s_length = s.length();
        int t_length = t.length();
        int s_index = 0;
        int t_index = 0;
        char[] s_charArray = s.toCharArray();
        char[] t_charArray = t.toCharArray();

        /*
        * return
        * true if all characters in s are found after t_index>t.length
        * false if not all characters in s are found after t_index>t.length
        * */

        while(  s_index < s_length &&
                t_index < t_length        ) {
            if(s_charArray[s_index] == t_charArray[t_index] ) { //character found
                s_index++;
            }
            t_index++;

        }

//        System.out.printf("%d %d\n",s_index,t_index);
        if(s_index < s_length) return false;
        else return true;
    }
}
