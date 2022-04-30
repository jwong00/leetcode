import java.util.ArrayList;

class Solution {
    public int splitArray(int[] nums, int m) {
        return dfs(nums,m,new ArrayList<>(nums.length),new ArrayList<>(m+1));
    }

    public int dfs(int[] nums, int m, ArrayList<Integer> color, ArrayList<Integer> values) {
        if(color.size()==nums.length) {
            int max = Integer.MIN_VALUE;
            for(int value : values) {
                max = Math.max(max,value);
            }
            return max;
        }

            //iterate over colors
            for(int j=1;j<=m;j++) {
                //clone color and values, pass them to next recursion
                ArrayList<Integer> color_cpy = ((ArrayList<Integer>) color.clone());
                color_cpy.add(j);

                ArrayList<Integer> values_cpy = ((ArrayList<Integer>) values.clone());
                values_cpy.set(j,values.get(j));

                dfs( nums,m, color_cpy, values_cpy );

            }


        return ;
    }
}
