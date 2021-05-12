/*

    1 <= cardPoints.length <= 10^5
    1 <= cardPoints[i] <= 10^4
    1 <= k <= cardPoints.length

*/

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxScore(new int[] {1,2,3,4,5,6,1},3));        //12
        System.out.println(s.maxScore(new int[] {2,2,2},2));                //4
        System.out.println(s.maxScore(new int[] {9,7,7,9,7,7,9},7));        //55
        System.out.println(s.maxScore(new int[] {1,1000,1},1));             //1
        System.out.println(s.maxScore(new int[] {1,79,80,1,1,1,200,1},3));  //202
    }
    public int maxScore(int[] cardPoints, int k) {
        int absoluteMaxScore = 0;

        for(int i=0;i<cardPoints.length;i++) absoluteMaxScore+=cardPoints[i];

        int windowLength = cardPoints.length-k;
        int windowSum = 0;

        for(int i=0;i<windowLength;i++) windowSum+=cardPoints[i];


        int minWindowSum = windowSum;

        for(int i=0;i+windowLength<cardPoints.length;i++) {
            windowSum = windowSum-cardPoints[i]+cardPoints[i+windowLength];
            minWindowSum = Math.min(minWindowSum,windowSum);
        }

        return absoluteMaxScore-minWindowSum;
    }
}
