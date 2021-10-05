/**
 * Created by Glamdring on 10/7/2016.
 */
public class Solution {
    public static void main(String[] args) {
        ListNode num1 = new ListNode(2);
        num1.next = new ListNode(4);
        num1.next.next = new ListNode(3);

        ListNode num2 = new ListNode(5);
        num2.next = new ListNode(6);
        num2.next.next = new ListNode(4);

        Solution s = new Solution();
        ListNode sum = s.addTwoNumbers(num1,num2);
        s.printNumber(sum);

        num1 = new ListNode(5);
        num2 = new ListNode(5);
        sum = s.addTwoNumbers(num1,num2);
        s.printNumber(sum);

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode sum = new ListNode(0);
        ListNode sumTraverse = sum;

        do {
            //assumes that both LL representation of numbers is non-zero on step 1
            int tempSum = 0;

            if(l1 != null && l2 != null) {
                tempSum = l1.val + l2.val + carry;
                System.out.println("tempsum = "+tempSum);
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l2 != null) {
                tempSum = l2.val + carry;
                l2 = l2.next;
            }
            else if (l1 != null) {
                tempSum = l1.val + carry;
                l1 = l1.next;
            }
            else if (carry > 0 ) {tempSum = carry; }

            sumTraverse.val = tempSum % 10;
            carry = (tempSum - sumTraverse.val) / 10 ;
            if( l1 != null || l2 != null || carry > 0) {
                sumTraverse.next = new ListNode(0);
                sumTraverse = sumTraverse.next;
            }

        } while(l1 != null || l2!=null || carry > 0 );

        return sum;
    }

    public void printNumber(ListNode num) {
        System.out.print(num.val);
        if(num.next == null) {
            System.out.printf("\n");
        }
        else printNumber(num.next);
    }
}
