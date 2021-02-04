class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] k = {
                {0,2},
                {1,1},
                {0,4}
        };
        System.out.println(s.stringShift("blah",k));
        int[][] r = {
                {1,3}
        };
        System.out.println(s.stringShift("Gotterdamerung",r));
    }
    public String stringShift(String s, int[][] shift) {
        int netShift=0;

        for(int[] v : shift) {
            if(v[0]==0) netShift-=v[1];
            else netShift+=v[1];
        }
        netShift%=s.length();

        if(netShift==0) return s;
        else if (netShift<0) {
            return s.substring(Math.abs(netShift)) + (s.substring(0,Math.abs(netShift)));
        }
        else if (netShift>0) {
            int rhs = s.length() - Math.abs(netShift);
            return s.substring(rhs)+s.substring(0, rhs);
        }
        return s;
    }
}
