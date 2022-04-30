import java.util.PriorityQueue;

class KthLargest {
    public static void main(String[] args) {
        KthLargest s = new KthLargest(3,new int[]{4,5,8,2});
        System.out.println(heap);
        System.out.println(s.add(3));
        System.out.println(s.add(5));
        System.out.println(s.add(10));
        System.out.println(s.add(9));
        System.out.println(s.add(4));

        s = new KthLargest(2,new int[]{0});
        System.out.println(heap);
        System.out.println(s.add(-1));
        System.out.println(s.add(1));
        System.out.println(s.add(-2));
        System.out.println(s.add(-4));
        System.out.println(s.add(3));

    }


    private static PriorityQueue<Integer> heap;
    private static int _k;

    public KthLargest(int k, int[] nums) {

        heap = new PriorityQueue<>();
        _k = k;

        for(int i=0;i<nums.length;i++) {
            if(i<k) heap.offer(nums[i]);
            else if(nums[i]>heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if(heap.size() < _k) heap.offer(val);
        else if(val>heap.peek()) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
