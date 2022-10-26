import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        ArrayList<String> k = new ArrayList<>();
//        k.add("un");
//        k.add("iq");
//        k.add("ue");
        k.add("aa");
        k.add("bb");
        System.out.println(s.maxLength(k));
    }

    public int maxLength(List<String> arr) {

        //generate all possibilities
        List<String> set = new ArrayList<>();
        set.add("");

        for(String s : arr) {
            int j = set.size();
            for(int i=0;i<j;i++) {
                set.add(set.get(i)+s);
            }
        }

        //find max of all string with unique char
        int max = 0;
        OUTER: for(String s : set) {
            HashSet<Character> charset = new HashSet<>();
            for(char c : s.toCharArray()) {
                if(charset.contains(c)) continue OUTER;
                else charset.add(c);
            }
            max = Math.max(max,charset.size());
        }

        return max;
    }
}
