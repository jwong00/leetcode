import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.makesquare(new int[]{1,1,2,2,2}));
    }

    public int sums[];
    public int sideLength;

    public Solution() {
        sums = new int[4];
    }
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length<4) return false;

        int s=0,m=0;
        for(int i=0;i<matchsticks.length;i++) {
            m=Math.max(m,matchsticks[i]);
            s+=matchsticks[i];
        }

        sideLength = s/4;

        if(s%4!=0 || m>s/4) return false;
        Arrays.sort(matchsticks);

        return dfs(matchsticks.length-1,matchsticks);

    }
    public boolean dfs(int i,int[] m) {
        System.out.println(i);
        //return if all matchsticks are same length
        if(i==0) {
            return sideLength == sums[0] &&
                    sideLength == sums[1] &&
                    sideLength == sums[2] &&
                    sideLength == sums[3];
//            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        //try
        for(int j=0;j<4;j++) {
            if(sums[j]+m[i] <= sideLength) {
                sums[j]+=m[i];
                if(dfs(i-1,m)) return true;
            }
            sums[j]-=m[i];
        }

        //fail
        return false;

    }
}
