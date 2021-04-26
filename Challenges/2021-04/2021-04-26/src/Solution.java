import java.util.TreeSet;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.furthestBuilding(new int[] {4,2,7,6,9,14,12},5,1));
        System.out.println(s.furthestBuilding(new int[] {4,12,2,7,3,18,20,3,19},10,2));
        System.out.println(s.furthestBuilding(new int[] {14,3,19,3},17,0));



    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //max.size()<ladders
        TreeSet<Integer> max = new TreeSet<>();

        //store the total number of bricks-sum(max)
        int remainder=0;

        for(int i=1;i<heights.length;i++) {
            int t = heights[i]-heights[i-1];
            if(t>=0) {
                //there are unused ladders
                if(max.size()<ladders) max.add(heights[i]-heights[i-1]);
                //take back a ladder and use
                else if(!max.isEmpty() && t>max.first())  {
                    remainder+=max.pollFirst();
                    max.add(t);
                }
                //no ladders, use bricks
                else remainder+=t;

            }
            if(remainder>bricks) return i-1;
        }
        return heights.length-1;
    }
}
