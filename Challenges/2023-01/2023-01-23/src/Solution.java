import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findJudge(3,new int[][]{{1,3},{2,3}}));
        System.out.println(s.findJudge(3,new int[][]{{1,3},{2,3},{3,1}}));
        System.out.println(s.findJudge(1,new int[][]{}));
        System.out.println(s.findJudge(3,new int[][]{{1,2}}));
    }
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1;
        HashSet<Integer> givesTrust = new HashSet<>();

        int[] trustReceived = new int[n+1];
        int mostTrustedIndividual = 0;
        for(int i=0;i<trust.length;i++) {
            givesTrust.add(trust[i][0]);
            trustReceived[trust[i][1]]++;

            //compare currently processed individual
            //against the mostTrustIndividual
            //promote most trusted individual to
            //mostTrustedIndividual
            if(trustReceived[trust[i][1]] > trustReceived[mostTrustedIndividual]) mostTrustedIndividual = trust[i][1];
        }

        return (!givesTrust.contains(mostTrustedIndividual) && trustReceived[mostTrustedIndividual]==n-1) ? mostTrustedIndividual : -1;
    }
}
