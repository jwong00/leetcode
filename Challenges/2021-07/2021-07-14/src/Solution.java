class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.customSortString("cba","abcd");
    }
    public String customSortString(String order, String str) {
        int[] freq = new int['z'-'a'+1];

        int m = order.length(), n=str.length();

        //count char in str
        for(int i=0;i<n;i++) {
            freq[str.charAt(i)-'a']++;
        }

        StringBuilder buf = new StringBuilder();

        //ordered characters come first
        for(int j=0;j<m;j++) {
            while(freq[order.charAt(j)-'a']>0) {
                buf.append(order.charAt(j));
                freq[order.charAt(j)-'a']--;
            }
        }

        //the rest
        for(int k=0;k<'z'-'a'+1;k++) {
            while(freq[k]>0) {
                buf.append((char) (k+'a'));
                freq[k]--;
            }
        }

        return buf.toString();
    }
}
