import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {

            if(m>=n) return head;

            Stack<ListNode> s = new Stack();

            ListNode pre=null; //(m-1)st element
            ListNode post=null; //(n+1)th element

            ListNode cur =head;

            for(int k = 1; cur !=null; k++) {
                if(k==m-1) pre=cur;
                if(k>=m &&  k<=n) {
                    s.push(cur);
                }
                if(k==n+1) post=cur;
                cur=cur.next;
            }

            if(pre!=null) cur=pre;
                /*there were elements before the reversed
                segment, so we start reversing at the segment*/
            else {
                //reversal started with first element of LL
                cur=s.pop();
                head=cur;
            }

            while(!s.empty()) {
                cur.next=s.pop();
                cur=cur.next;
            }

            if(post!=null) cur.next=post;
            else cur.next=null;

            return head;
    }
}