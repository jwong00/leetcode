import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.splitListToParts(MakeList(new int[]{1,2,3,4,5,6,7,8,9,10}),3)));
    }
    public static ListNode MakeList(int[] array) {
        int n = array.length;
        if(n < 1) return null;
        ListNode cur = new ListNode(array[0]);
        ListNode head = cur;

        for(int i=1;i<n;i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
        return head;
    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;

        ListNode cur = head;
        while(cur!=null) {
            n++;
            cur = cur.next;
        }

        int m = (int) Math.ceil((double) n / k);

        ListNode[] ans = new ListNode[k];
        cur = head;
        for(int i=0;i<k;i++) {


            ans[i] =  cur;
            for(int j=0;j<m-1 && cur!=null;j++,cur=cur.next) {

            }

            if(cur==null) break;

            ListNode next = cur.next;
            cur.next = null;
            cur = next;

        }

        return ans;

    }
}
