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

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static void main(String[] args) {
        ListNode t = new ListNode(-10);
        t.next = new ListNode(-3);
        t.next.next = new ListNode(0);
        t.next.next.next = new ListNode(5);
        t.next.next.next.next = new ListNode(9);

        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        Solution s = new Solution();
        TreeNode k = s.sortedListToBST(t);

        q.add(k);

        while(!q.isEmpty()) {
            TreeNode r = q.poll();
            System.out.printf("%d ",r.val);
            if(r.left!=null) q.add(r.left);
            if(r.right!=null) q.add(r.right);
        }
        System.out.printf("\n");

    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ArrayList<ListNode> s = new ArrayList<>();

        ListNode cur = head;

        while(cur!=null) {
            s.add(cur);
            cur=cur.next;
        }

        return center(0,s.size()-1,s);

    }

    public TreeNode center(int l, int r, ArrayList<ListNode> nodes) {

        System.out.println("For call with bounds "+l+" "+r);
        //calculate center
        int mid = l+(r-l)/2;

        if(r<l || l>r ) return null;

        //build center/root
        TreeNode root = new TreeNode(nodes.get(mid).val);
        System.out.println("For call with bounds "+l+" "+r+" center node has val: " +root.val);

        //assign left
        root.left = center(l,mid-1,nodes);

        //assign right
        root.right = center(mid+1,r,nodes);


        return root;

    }
}
