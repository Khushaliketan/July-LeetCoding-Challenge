/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        //METHOD 1: Without Recursion
        
        if(head==null)      //null condition
            return null;
        Node h=head;    //current node is h
        while(h!=null){     /*Do not put condition as h.next!=null cause there could be a case like: 1 -> null
                                                                                                     |
                                                                                                     2 -> 3 -> null  and compiler wouldn't even get inside the while loop here. */
            if(h.child==null)
                h=h.next;
            else{
                Node childEnd=h.child;     //h.child is the child head node
                
                while(childEnd.next!=null)      //traversing to the end
                    childEnd=childEnd.next;
                
                //connecting child end with h.next
                childEnd.next=h.next;
                if(h.next!=null)    h.next.prev=childEnd;
                
                //connecting child with h
                h.next=h.child;
                h.child.prev=h;
                h.child=null;
            }
        }
        return head;
    }
}
