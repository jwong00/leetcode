class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canPlaceFlowers(new int[]{1,0,0,0,1},1));
        System.out.println(s.canPlaceFlowers(new int[]{1,0,0,0,0},1));
        System.out.println(s.canPlaceFlowers(new int[]{1,0,0,0,1},2));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {



        int l=0, r=flowerbed.length-1;
        for(int i=0;i<flowerbed.length;i++) {
            if(flowerbed[i]==1) break;
            l++;
        }
        if(l>=2*n) return true;

        for(int i=r;i>=0;i--) {
            if(flowerbed[i]==1) break;
            r--;
        }
        if(flowerbed.length-1-r>=2*n) return true;


        int k = 2 * n + 1;

        int cur = 0;
        int max = 0;

        for(int i=l;i<r;i++) {
            if(flowerbed[i]==0) cur++;
            else {
                max = Math.max(cur,max);
                cur=0;
            }
        }
        max = Math.max(cur,max);

        if(max>=k) return true;
        else return false;
    }
}
