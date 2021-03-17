import java.util.Arrays;
import java.util.Random;

class Solution {
    double radius;
    double x_center;
    double y_center;
    double theta;

    public static void main(String[] args) {
        Solution s = new Solution(1,0,0);

        System.out.println(Arrays.toString(s.randPoint()));
        System.out.println(Arrays.toString(s.randPoint()));
        System.out.println(Arrays.toString(s.randPoint()));
        System.out.println(Arrays.toString(s.randPoint()));
        System.out.println(Arrays.toString(s.randPoint()));
    }

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        //r = sqrt(x^2+y^2)

        Random g = new Random();

        double r = Math.sqrt(radius*radius*g.nextDouble());
        double t = 2 * Math.PI * g.nextDouble();

        double[] c = new double[2];
        c[0] = r * Math.cos(t) + x_center;
        c[1] = r * Math.sin(t) + y_center;

        return c;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
