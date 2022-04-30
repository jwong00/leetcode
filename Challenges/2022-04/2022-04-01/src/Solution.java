class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[] cache = "hello".toCharArray();
        s.reverseString(cache);
        System.out.println(cache);
    }

    public void reverseString(char[] s) {
        if(s==null || s.length==0) return;

        int i=0,j=s.length-1;
        while(i<j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;

            i++;
            j--;
        }
    }
    public void reverseStringXOR(char[] s) {
        if(s==null || s.length==0) return;

        int i=0,j=s.length-1;
        while(i<j) {
//            char c = s[i];
            s[i] = (char) (s[i]^s[j]);
            s[j] = (char) (s[j]^s[i]);
            s[i] = (char) (s[i]^s[j]);

            i++;
            j--;
        }
    }
}