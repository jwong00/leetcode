import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms==null || rooms.size()==0) return true;

        int maxRooms = rooms.size();
        boolean[] hasKey = new boolean[maxRooms];
        hasKey[0] = true;

        Stack<Integer> keys = new Stack<>();

        //room 0 is only room open at start; store keys found in rm0
        for(int k : rooms.get(0)) {
            keys.push(k);
            hasKey[k] = true;
        }

        //
        while(!keys.isEmpty()) {
            int k = keys.pop();
            hasKey[k] = true;
            for(int key : rooms.get(k)) {
                if(!hasKey[key]) keys.push(key);
            }
        }

        for(int i=0;i<hasKey.length;i++) {
            if(!hasKey[i]) return false;
        }
        return true;

    }
}
