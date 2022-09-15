import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.findOriginalArray(new int[]{1,3,4,2,6,8})));
        System.out.println(Arrays.toString(s.findOriginalArray(new int[]{6,3,0,1})));
    }
    public int[] findOriginalArray(int[] changed) {
        if(changed==null || changed.length%2!=0) return new int[]{};

        HashMap<Integer,Integer> freq = new HashMap<>();

        for(int i=0;i<=changed.length-1;i++) {
            freq.put(changed[i],freq.getOrDefault(changed[i],0)+1);
        }

        Arrays.sort(changed);

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=changed.length-1;i>=0;i--) {
            int hi = changed[i], lo = hi/2;

            if(freq.containsKey(hi) && freq.containsKey(lo)) {

                int min = Math.min(freq.get(hi),freq.get(lo));
                freq.put(hi,freq.get(hi)-min);
                freq.put(lo,freq.get(lo)-min);

                if(freq.get(hi)<=0) freq.remove(hi);
                if(freq.get(lo)<=0) freq.remove(lo);
                while(min-- > 0) ans.add(lo);
            }
//            else return new int[]{};
        }

//        System.out.println(ans);

        int[] originals = new int[ans.size()];

        for(int i=0;i<ans.size();i++) {
            originals[i] = ans.get(i);
        }
        return originals;
    }
}
