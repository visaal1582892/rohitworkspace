// Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.If the total number of nodes in the LinkedList is even, return the second middle node.



public class MiddleOfLinkList{
    public static LinkList middleOfLinkList(LinkList start){
        LinkList fast=start;
        LinkList slow=start;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static void main(String [] args){
        LinkList nextNode=null;
        LinkList start=null;
        for(int i=0; i<7; i++){
            LinkList node = new LinkList(i,nextNode);
            nextNode=node;
            start=node;
        }
        System.out.println(MiddleOfLinkList.middleOfLinkList(start).value);
    }
}