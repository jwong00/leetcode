class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.restoreString("codeleet",new int[]{4,5,6,7,0,2,1,3}));
    }
    public String restoreString(String s, int[] indices) {
        if(s==null || s.length()==0 || indices==null || indices.length==0)
            return "";

        char[] c = new char[s.length()];

        for(int i=0;i<indices.length;i++) {
            c[indices[i]] = s.charAt(i);
        }

        return String.valueOf(c);
    }
}
