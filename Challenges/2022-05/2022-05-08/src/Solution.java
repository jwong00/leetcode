import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    /*
    * put first item on stack
    * when iter to next,
    * peek and figure out type:
    * if INTEGER, pop and return
    * if LIST, pop, then place all NESTED INTS in REVERSE order
    * */

    private ArrayList<Integer> flat = new ArrayList<Integer>();
    private int ptr = 0;

    private void flatten(List<NestedInteger> list) {
        for(NestedInteger ni : list) {
            if(ni.isInteger()) flat.add(ni.getInteger());
            else flatten(ni.getList());
        }
    }
    //just initialize our stack/queue
    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList);

    }

    @Override
    public Integer next() {
        return flat.get(ptr++);
    }

    @Override
    public boolean hasNext() {
        return flat.size() > 0 && ptr < flat.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
