import static java.lang.Integer.MAX_VALUE;

/**
 * Created by Glamdring on 10/8/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(MAX_VALUE);

        s.reverse(101);
        s.reverse(-10340);
        s.reverse(2948579);
        s.reverse(100);
        s.reverse(s.reverse(1000000003));
        s.reverse(-99911192);
        s.reverse(-111420009);
        s.reverse(-3042);
        s.reverse( 2147483647); //MAX_VALUE
        s.reverse(-2147483648); //MIN_VALUE
        s.reverse(-2147483647);

    }

    public int reverse(int x) {
        int original=x;
        int length=0;
        int reversed=0;
        boolean negative=false;

        if(x==0) return 0;
        if(x<0) {
            x *= -1;
           negative = true;
        }

        //absorb rightmost zeros
        while(x%10==0) {
            x=x/10;
        }
        int y=x; //store int with no rightmost zeros

        while(x!=0) { //get length of this new int
            x=x/10;
            length++;
        }

        if(y%10>0) {
            if(MAX_VALUE/((int)Math.pow(10,length-1)) < (y%10)) {
                //System.out.println("Too big?");
                System.out.println("Reverse of " + original +" is " + reversed+".");
                return 0;
            }

        }
        //reverse
        while(length>=0) {
            reversed+=(y%10)*(int)Math.pow(10,length-1);
            y=y/10;
            length--;
        }
        if(negative) reversed*=-1;

        System.out.println("Reverse of " + original +" is " + reversed+".");

        return reversed;
    }
}
