import javax.xml.transform.SourceLocator;
import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        int[] prices = {100,80,60,70,60,75,85};
        for(int price : prices) System.out.println(s.next(price));
    }

    Deque<int[]> st;

    public StockSpanner() {
        st = new ArrayDeque<>();
    }

    public int next(int price) {
        int ans = 1;
        while(!st.isEmpty() && st.peek()[0] <= price) ans+=st.pop()[1];
        st.push(new int[]{price,ans});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */