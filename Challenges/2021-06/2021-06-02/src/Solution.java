class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }

    char[] s1;
    char[] s2;
    char[] s3;

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;

        this.s1 = s1.toCharArray();
        this.s2 = s2.toCharArray();
        this.s3 = s3.toCharArray();

//        int s1_ptr=0,s2_ptr=0;
//        for(int s3_ptr=0;s3_ptr<s3.length();s3_ptr++) {
//            if(s3.charAt(s3_ptr)!=s1.charAt(s1_ptr) &&
//                s3.charAt(s3_ptr)!=s2.charAt(s2_ptr))
//            {
//                System.out.println(s1.charAt(s1_ptr)+" NOT EQUALS "+s3.charAt(s3_ptr));
//                System.out.println(s2.charAt(s2_ptr)+" NOT EQUALS "+s3.charAt(s3_ptr));
//                return false;
//            }
//            if(s3.charAt(s3_ptr)==s1.charAt(s1_ptr)) s1_ptr++;
//            if(s3.charAt(s3_ptr)==s2.charAt(s2_ptr)) s2_ptr++;
//        }
//        return true;

        //dfs
        return dfs(0,0,0);
    }

    public boolean dfs(int i, int j, int k) {
        if(s1[i]!=s3[k] && s2[j] != s3[k]) return false;

        if(s1[i]==s3[k]) return dfs(i+1,j,k+1);
        if(s2[j]==s3[k]) return dfs(i,j+1,k+1);
    }
}