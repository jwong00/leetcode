import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.pushDominoes("..LR...LR.."));
        System.out.println(s.pushDominoes("..LR...LR.."));
        System.out.println(s.pushDominoes("..R."));
        System.out.println(s.pushDominoes("..L.."));
        System.out.println(s.pushDominoes("."));
        System.out.println(s.pushDominoes(".L.R."));
        System.out.println(s.pushDominoes(".R...L."));

    }
    public String pushDominoes(String dominoes) {

        int n = dominoes.length();
        if(n==0) return "";

        char[] d = dominoes.toCharArray();

//        System.out.println("Original array: "+ Arrays.toString(d));

        boolean none_pushed = true;
        for(int i=0;i<n;i++) if(d[i]!='.') {
            none_pushed = false;
            break;
        }

        if(none_pushed) return dominoes;


        //get rid of leading/trailing period characters
        int first=0, last=n-1;

        while(d[first]=='.') first++;
        while(d[last]=='.') last--;

        //optimization for later for loop?..
        //n=last;

        if(d[first]=='L') while(first>=0) d[first--]='L';
        if(d[last]=='R') while(last<n) d[last++]='R';


        //find first 'R', return if none found
        int recent = 0;
        while(recent<n && d[recent]!='R') recent++;
        if(recent>=n) return String.valueOf(d);

        //left to right

        for(int i=recent+1;i<n;i++) {
            if(d[i]!='.') {
                if(d[i]=='R') {
                    for (int j = recent + 1; j < i; j++) {
                        d[j] = 'R';
                    }
                }
                if(d[i]=='L') {
                    for(int left = recent+1,right=i-1;left<right;left++,right--) {
                        d[left] = 'R';
                        d[right] = 'L';
                    }
                }

                recent = i;
            }
        }

        return String.valueOf(d);
    }
}
