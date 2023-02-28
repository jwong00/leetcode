import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.distinctNames(new String[]{"coffee","donuts","time","toffee"}));
    }
    public long distinctNames(String[] ideas) {
        int n = ideas.length;
        HashSet<String> companyNamesOriginal = new HashSet<>(Arrays.asList(ideas));
        HashSet<String> companyNamesNew = new HashSet<>();

        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                //generate new names by swapping first letter
                String a = ideas[i].charAt(0) + ideas[j].substring(1,ideas[j].length());
                String b = ideas[j].charAt(0) + ideas[i].substring(1,ideas[i].length());
                System.out.println(a);
                System.out.println(b);
                //check originals for each of two new names
                //add if appropriate
                if(!companyNamesOriginal.contains(a) && !companyNamesOriginal.contains(b)) {
                    companyNamesNew.add(a + " " + b);
                    companyNamesNew.add(b + " " + a);
                }
            }
        }

        return companyNamesNew.size();


    }
}
