class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findKthPositive(new int[]{2,3,4,7,11},5));
    }
    public int findKthPositive(int[] arr, int k) {
        //assume sorted, last int is highest
        boolean[] set = new boolean[arr[arr.length-1]+1+k];

        //set true if in arr
        for(int i=0;i<arr.length;i++) {
            set[arr[i]] = true;
        }

        //count k missing ints
        for(int i=1;i<set.length;i++) {
            if(!set[i]) k--;
            if(k==0) return i;
        }

        return -1;

    }
}
