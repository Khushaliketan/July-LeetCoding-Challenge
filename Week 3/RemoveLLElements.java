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
    //METHOD 1: Using two pointers 
    /*
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        if(head.next==null && head.val==val)
            return null;
        while(head!=null && head.val==val){
            head=head.next;
            if(head==null) return null;
        }
        ListNode temp1=head;
        ListNode temp=head.next;
        while(temp!=null){
            if(temp.val==val){
                temp1.next=temp.next;
                temp.next=null;
                temp=temp1.next;
            }
            else{
                temp1=temp1.next;
                temp=temp.next;
            }
        }
        return head;
    }
    */
    
    //METHOD 2: Using just one pointer
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        if(head.next==null && head.val==val)
            return null;
        if(head.next==null && head.val!=val)
            return head;
        while(head!=null && head.val==val){
            head=head.next;
            if(head==null) return null;
        }
        ListNode temp=head; //temp.val!=val since it's checked before
        //temp remains as the previous pointer and temp.next is checked.
        while(temp.next!=null){
            if(temp.next.val==val){
                temp.next=temp.next.next;
                continue;
            }
            temp=temp.next;
        }
        return head;
    }
}
