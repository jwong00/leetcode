import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numRescueBoats(new int[]{1,2},3));
        System.out.println(s.numRescueBoats(new int[]{3,2,2,1},3));
        System.out.println(s.numRescueBoats(new int[]{3,5,3,4},5));
    }
    public int numRescueBoats(int[] people, int limit) {
        int l=0,r=people.length-1;

        Arrays.sort(people);

        while(people[r]>limit) r--;

        int boats = 0;
        /*
        * Each rescue boat can fit at most 2 people
        * Attempt to select up to 2 people
        * */
        while(l<=r) {
            //both can fit TOGTHER
            if(people[l]+people[r]<=limit) {
                boats++;
                l++;
                r--;
            }
            //too heavy together
            else {
                //send right off by themself
                boats++;
                r--;

            }
        }

        return boats;
    }
}
