class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] t = {1,0,8,6,2,5,4,8,3,7};
        int[] r = {2,3,10,5,7,8,9};
        int[] q = {10,9,8,7,6,5,4,3,2,1};

        s.maxArea(t);
        s.maxArea(r);
        s.maxArea(q);
    }
    public int maxArea(int[] height) {
        int curArea = 0;
        int maxArea = 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while(height[leftIndex] == 0) {
            leftIndex++;
        }

        while(rightIndex == 0) {
            rightIndex--;
        }

        maxArea = Math.min(height[leftIndex],height[rightIndex]) * (rightIndex-leftIndex);
        curArea = maxArea;

        //improve left bound

        /*
        * increase index of left bound if
        *
        * leftIndex < rightIndex - 1
        * height[newLeftBound] > height[oldLeftBound]
        *
        * test curArea
        * */

        int oldLeftIndex = leftIndex;
//        int oldRightIndex = rightIndex;
        while(leftIndex<height.length-1) {


                rightIndex = height.length-1;
//                System.out.println("MAXAREA BEFORE UPDATE: "+maxArea);
                while (rightIndex > leftIndex + 1) {
                    curArea = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
                    maxArea = Math.max(maxArea, curArea);
//                    System.out.println("MAXAREA AFTER UPDATE: "+maxArea);

                    rightIndex--;
                }


            leftIndex++;
        }

        //improve right bound
        /*
        * decrease index of right bound if
        *
        * rightIndex > leftIndex + 1
        * height[newRightBound] > height[oldRightBound]
        * */

        System.out.println(maxArea);
        return maxArea;

    }
}
