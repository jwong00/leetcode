// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
    public static void main(String[] args) {
        int[] i = {1,2,3};
        PeekingIterator p = new PeekingIterator(Arrays.stream(i).iterator());
        System.out.println(p.next());
        System.out.println(p.peek());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.hasNext());
    }

    private Iterator<Integer> iter;
    private Integer next = null;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        if(iterator.hasNext()) next = iterator.next();
        iter = iterator;

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(next==null) throw new NoSuchElementException();

        int t = next;
        next = null;
        if(iter.hasNext()) next = iter.next();
        return t;
    }

    @Override
    public boolean hasNext() {
        return next!=null;
    }
}
