class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.computeArea(-3,0,3,4,0,-1,9,2));
        System.out.println(s.computeArea(-2,-2,2,2,-2,-2,2,2));
    }
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //area of rectangle 1
        int a1 = Math.abs(ax1-ax2) * Math.abs(ay1-ay2);

        //area of rectangle 2
        int a2 = Math.abs(bx1-bx2) * Math.abs(by1-by2);

        //area of overlap
        if(bx1 >= ax2 || ax1 >= bx2 || ay1 >= by2 || by1 >= ay2) return a1+a2;
        else {
            System.out.println("OVERLAP");
            int l = Math.max(ax1,bx1);
            int r = Math.min(ax2,bx2);
            int t = Math.min(ay2,by2);
            int b = Math.max(ay1,by1);

            return a1+a2-(Math.abs(l-r)*Math.abs(t-b));
        }
    }
}
