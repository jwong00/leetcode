import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalFruit(new int[]{1,2,1}));
        System.out.println(s.totalFruit(new int[]{0,1,2,2}));
        System.out.println(s.totalFruit(new int[]{1,2,3,2,2}));
    }
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int l = 0, r = 0;
        HashMap<Integer,Integer> basket = new HashMap<>();
        int f_cur = 0, f_max = 0;
        while(l < n && r < n) {
            //extend r and add
            if(basket.size()<2) {
                basket.put(fruits[r],basket.getOrDefault(fruits[r],0)+1);
                f_cur++;
                r++;
            }
            //shrink l and remove
            else {
                int count = basket.get(fruits[l]) - 1;
                f_cur--;
                if(count<=0) basket.remove(fruits[l]);
                else basket.put(fruits[l],count);
                l++;
            }

            f_max = Math.max(f_max,f_cur);
        }

        return f_max;
    }
}
