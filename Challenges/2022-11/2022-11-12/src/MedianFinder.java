import javax.sound.midi.MidiChannel;
import java.util.PriorityQueue;

class MedianFinder {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(55);

        System.out.println(mf.findMedian());
    }

    PriorityQueue<Integer> maxOfLower, minOfUpper;

    public MedianFinder() {
        maxOfLower = new PriorityQueue<>((a,b)->b-a);
        minOfUpper = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(maxOfLower.isEmpty()) {
            maxOfLower.offer(num);
            return;
        }
        if(minOfUpper.isEmpty()) {
            minOfUpper.offer(num);
            return;
        }

        //L < n < U
        //offer to smaller of two sets
        //if equal size, offer to LOWER
        if(maxOfLower.peek() <= num && num <= minOfUpper.peek()) {
            if(maxOfLower.size() <= minOfUpper.size()) maxOfLower.offer(num);
            else minOfUpper.offer(num);

            return;
        }

        if(maxOfLower.peek() <= num && minOfUpper.peek() <= num) {
            minOfUpper.offer(num);
            while(maxOfLower.size() < minOfUpper.size()) maxOfLower.offer(minOfUpper.poll());

            return;
        }

        if(num <= maxOfLower.peek() && num <= minOfUpper.peek()) {
            maxOfLower.offer(num);
            while(maxOfLower.size() > minOfUpper.size()) minOfUpper.offer(maxOfLower.poll());

            return;
        }

        System.out.println("??");

    }

    public double findMedian() {
        if(maxOfLower.isEmpty() && minOfUpper.isEmpty()) return 0.0;

        if(maxOfLower.size()==minOfUpper.size()) return (double) (maxOfLower.peek()+minOfUpper.peek())/2;

        return maxOfLower.size()<minOfUpper.size() ? minOfUpper.peek() : maxOfLower.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
