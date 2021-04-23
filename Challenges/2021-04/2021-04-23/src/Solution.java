class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.countBinarySubstrings("000111");
    }
    public int countBinarySubstrings(String s) {
        //iterate over every even length sliding window?
        //check if sym
        //if sym, move window to start of second half of cur string
        //ex
        // 000111
        // ^
        // 000111
        //    ^

        int length = s.length();
        if(length<2) return 0;

        int window;

        if(length%2==0) window=length;
        else window=length-1;

        System.out.println("Window size is: "+window);

        for(int k=window;k>0;k-=2) {
            System.out.println("Iterating on window size=="+k);

            for(int i=0;i<=length-k;i++)  {
                System.out.println("Iterating on window starting at "+i);
                for(int m=i,n=i+k-1;m<n;m++,n--) {
                    System.out.println("INDEX: "+m+" "+n);
                    System.out.println("VALUE: "+s.charAt(m)+" "+s.charAt(n));
                    if(s.charAt(m)==s.charAt(n)) break;
                    if(s.charAt(m)==s.charAt(i) || s.charAt(n)==s.charAt(i+k-1)) break;
                    if(m==n-1) //store string in window
                }
            }

        }
        return -1;
    }
}
