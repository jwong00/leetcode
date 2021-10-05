import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> course1 = new ArrayList<>();

        ArrayList<Integer> r1 = new ArrayList<Integer>();
        ArrayList<Integer> r2 = new ArrayList<Integer>();
        ArrayList<Integer> r3 = new ArrayList<Integer>();

        r1.add(1);
        r1.add(2);
        r1.add(3);

        r2.add(0);
        r2.add(0);
        r2.add(5);

        r3.add(0);
        r3.add(4);
        r3.add(6);

        course1.add(r1);
        course1.add(r2);
        course1.add(r3);

        s.travel(0,0,0, course1);


    }
    public int cutOffTree(List<List<Integer>> forest) {
        return 0;
    }

    public int travel(int posX, int posY, int lastPathLength, List<List<Integer>> forest) {

        for(List<Integer> row: forest )  {
            for(Integer tile : row) {
                System.out.print(tile + " ");
            }
            System.out.print("\n");
        }

        //determine travel direction (find the shortest tree adjacent to current space)
        //basically, pick the next spot (left, below, or right of current) with the lowest non-0, non-1 value
        //remember,
        //0 is non-traversable
        //1 is "grass" which means its traversable or an already-traversed location
        //travel(x,y,lastPathLength+1)

        //when done,
        //return pathLength
        //since this should be the shortest length, it should either
        //be equal to the number of trees if every tree is reachable (not isolated by an island)
        //or less than the number of trees if some are unreachable
        return 0;
    }
}
