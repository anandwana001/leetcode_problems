// https://leetcode.com/problems/add-two-numbers/

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

//Example:

//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.

//Solution

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode itr = ans;
        int x=0, y=0;
        int prevCarry=0, carry = 0;
        
        while(l1!=null || l2!=null || prevCarry==1){
            if(l1==null) {
                x=0; 
                if(l2!=null) y = l2.val;
                else y=0;
            }
            else if(l2==null) {
                y = 0; 
                if(l1!=null) x = l1.val;
                else x=0;
            }
            else {
                x = l1.val;
                y = l2.val;
            }
            if(l1==null && l2==null) {
                ListNode node = new ListNode(1);
                itr.next = node;
                itr = node;
                prevCarry =0;
                continue;
            }
            
            
            int data = x+y;
            
            if(data+prevCarry>9){
                data= (data)%10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            
            
            ListNode node = new ListNode((data+prevCarry)%10);
            prevCarry = carry;
            itr.next = node;
            itr = node;
            if(l1 != null) l1 = l1.next;
            if(l2 !=null) l2 = l2.next;
        }
        return ans.next;
    }
}