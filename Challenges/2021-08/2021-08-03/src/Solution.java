import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.subsetsWithDup(new int[]{-8,-4,-4,0,2,2});
    }
    /*
        -10 <= nums[i]  <= 10
    */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //create list of all nums w/o dupes
        //e.g. {1,2,2} => {1,2}
        //create list of frequencies
        //e.g. {1,2} => {1,1}


        int[] freq_table = new int[21]; //map -10..10 to 0..20
        for(int i=0;i<nums.length;i++) {
            freq_table[nums[i]+10]++;
        }

        System.out.println(Arrays.toString(freq_table));

        List<Integer> keys = new ArrayList<>();

        List<Integer> freq = new ArrayList<>();
        for(int i=0;i<21;i++) {
            if(freq_table[i]>0) {
                keys.add(i-10);
                freq.add(freq_table[i]);
            }
        }

        System.out.println(keys.toString());
        System.out.println(freq.toString());

//        for(int i=0;i<freq.size();i++) {
//            for(int j=0;j<=freq.get(i);j++) {
//                System.out.println(j+" ");
//            }
//            System.out.println("");
//        }

        List<Integer> freq_sets = new ArrayList<Integer>();
        //call func to generate all sets represented by
        //seq of freq
        int[] temp = new int[freq.size()];
        List<List<Integer>> memo = new ArrayList<List<Integer>>();
        dfs(0,temp,freq,memo);

        //iterate over memo, which is a list of lists of frequencies
        //expand the frequencies into the numbers they are frequencies of
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        for(List l : memo) {
            ArrayList<Integer> t = new ArrayList<>();
//            System.out.println(l.toString());
            for(int i=0;i<l.size();i++) {
                int f = (int) l.get(i);
                int k = keys.get(i);
                while (f > 0) {
                    t.add(k);
                    f--;
                }
            }
            answer.add(t);
        }

        System.out.println(answer.toString());

        return answer;
    }

    public void dfs(int i,int[] temp,List<Integer> freq,List<List<Integer>> memo) {
        if(i>=freq.size()) {
//            System.out.println(Arrays.toString(temp));
            ArrayList<Integer> f_list = new ArrayList<>();
            for(int r=0;r<temp.length;r++) {
                f_list.add(temp[r]);
            }
            memo.add(f_list);
            return;
        }
        int t = freq.get(i);
//        System.out.println("T IS: " +t);
        for(int k=0;k<=t;k++) {
            temp[i]=k;
            dfs(i+1,temp,freq,memo);
        }
    }
}
