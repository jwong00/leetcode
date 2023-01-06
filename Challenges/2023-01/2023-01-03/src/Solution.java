import java.util.ArrayDeque;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minDeletionSize(new String[]{"cba","daf","ghi"}));
        System.out.println(s.minDeletionSize(new String[]{"a","b"}));
        System.out.println(s.minDeletionSize(new String[]{"zyx","wvu","tsr"}));


    }
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for(int i=0;i<strs[0].length();i++) {
            ArrayDeque<Character> st = new ArrayDeque<>();
            for(int j=0;j<strs.length;j++) {
                if(st.isEmpty() || strs[j].charAt(i)>=st.peek()) st.push(strs[j].charAt(i));
                else {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
