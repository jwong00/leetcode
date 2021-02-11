/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        while(cur != null) {
            //create and initialize copy
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            copy.random = cur.random;
            //insert copy after original
            cur.next = copy;
            //advance beyond the copy
            cur = copy.next;
        }
        Node newHead=head.next;

        /* correct the random pointers */
        cur = head;
        while(cur!=null && cur.next!=null) {
            Node copy = cur.next;
            cur = copy.next;

            if(copy.random!=null) copy.random=copy.random.next;

        }

        /* linearly traverse the list and separate the new and the old elements */
        cur = head;
        while(cur!=null && cur.next != null) {
            Node copy = cur.next;
            cur.next = copy.next;
            if(copy.next!=null) copy.next = copy.next.next;
            cur=cur.next;

        }

        return newHead;
    }
}
