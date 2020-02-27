public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    public void print() {
        System.out.println("Printing list...");
        printNodes();
    }
    public void printNodes() {
        if(next!=null) {
            System.out.printf("%d ",val);
            next.printNodes();
        }
        else System.out.printf("%d \n",val);
    }
}
