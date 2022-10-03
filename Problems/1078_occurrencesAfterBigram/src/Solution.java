import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] ans = s.findOcurrences("alice is a good girl she is a good student","a","good");
        System.out.println(Arrays.toString(ans));
    }
    public String[] findOcurrences(String text, String first, String second) {
        if(text==null || text.length()==0) return new String[] {};
        String[] words = text.split(" ");
//        System.out.println(Arrays.toString(words));

        if(words.length<3) return new String[]{};

        ArrayList<String> cache = new ArrayList<>();

        boolean flag_first = false, flag_second = false;
        for(int i=2;i<words.length;i++) {
            if(words[i-2].equals(first) && words[i-1].equals(second)) cache.add(words[i]);
        }

        String[] ans = new String[cache.size()];
        for(int i=0;i<cache.size();i++) {
            ans[i] = cache.get(i);
        }
        return ans;
    }
}
