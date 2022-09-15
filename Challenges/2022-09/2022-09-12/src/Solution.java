import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.bagOfTokensScore(new int[]{100},50));
        System.out.println(s.bagOfTokensScore(new int[]{100,200},150));
        System.out.println(s.bagOfTokensScore(new int[]{100,200,300,400},200));
        System.out.println(s.bagOfTokensScore(new int[]{33,41,10,91,47,84,98,34,48,70},43));
    }
    public int bagOfTokensScore(int[] tokens, int power) {
        if(tokens==null || tokens.length==0) return 0;

        Arrays.sort(tokens);
//        System.out.println(Arrays.toString(tokens));

        int l = 0, r = tokens.length-1, score = 0, scoreMax = 0;

        if(power < tokens[l]) return 0;

        while(l<=r) {
            if(power >= tokens[l]) {
                power-=tokens[l++];
                score++;
            }
            else if(score>=1) {
                power+=tokens[r--];
                score--;
            }
            scoreMax = Math.max(scoreMax,score);
        }

        return scoreMax;
    }
}
