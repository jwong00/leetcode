import java.util.ArrayDeque;
import java.util.Deque;

class CombinationIterator {
    public static void main(String[] args) {
        CombinationIterator iter = new CombinationIterator("abc",2);
    }

    Deque<String> combinations = new ArrayDeque<>();

    public CombinationIterator(String characters, int combinationLength) {
        int n = characters.length();
        int k = combinationLength;

        System.out.print("1<<n = ");
        System.out.println(Integer.toBinaryString(1<<n));
        //gen bitmasks from 0..0 to 1..1
        for(int bitmask = 0; bitmask < 1 << n; bitmask++) {
            //if k bits are set, it represents a valid combination
            if(Integer.bitCount(bitmask)==k) {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++) {
                    if((bitmask & (1 << n-j-1)) != 0) {
                        sb.append(characters.charAt(j));
                    }
                }
                combinations.push(sb.toString());
            }
        }
    }

    public String next() {
       return combinations.pop();
    }

    public boolean hasNext() {
        return !combinations.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
