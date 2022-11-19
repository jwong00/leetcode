class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.makeGood("leEeetcode"));
    }
    public String makeGood(String s) {
        //validation

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<n;i++) {
            if(Character.isUpperCase(s.charAt(i)) ^ Character.isUpperCase(s.charAt(i-1)) &&
                    Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(i-1)))
            {
                i++;
            }
            else {
                sb.append(s.charAt(i-1));
                if(i==n-1)sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
