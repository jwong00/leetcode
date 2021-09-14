import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(1/2);
        System.out.println(s.maxNumberOfBalloons("balon"));
    }

    static final String target = "balloon";

    public int maxNumberOfBalloons(String text) {
        if(text==null || text.length()==0) return 0;

        int[] freq = new int['z'-'a'+1];
        for(int i=0;i<text.length();i++) {
            freq[text.charAt(i)-'a']++;
        }

        System.out.println(Arrays.toString(freq));

        int[] target_chars  = new int['z'-'a'+1];
        for(int i=0;i<target.length();i++) {
            target_chars[target.charAt(i)-'a']++;
        }

//        System.out.println(Arrays.toString(target_chars));

        int min = Integer.MAX_VALUE;

        for(int i=0;i<'z'-'a'+1;i++) {
            if(target_chars[i]>0) min = Math.min(min,freq[i]/target_chars[i]);
        }


        return min;
    }
}
