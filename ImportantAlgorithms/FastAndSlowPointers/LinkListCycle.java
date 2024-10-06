class LinkList{
    int value;
    LinkList next;
    LinkList(int value, LinkList next){
        this.value=value;
        this.next=next;
    }
}
public class LinkListCycle{
    // Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
    public static boolean linkListCycle(LinkList start){
        LinkList fast=start;
        LinkList slow=start;
        while(slow!=null && fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                System.out.println(linkListCycleLength(slow));
                return true;
            }
        }
        return false;
    }
    // Given the head of a LinkedList with a cycle, find the length of the cycle.
    public static int linkListCycleLength(LinkList slow){
        LinkList it=slow.next;
        int cycleLength=1;
        while(it!=slow){
            it=it.next;
            cycleLength++;
        }
        return cycleLength;
    }
    // Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
    public static LinkList startOfLinkListCycle(LinkList start,int length){
        LinkList p1=start;
        LinkList p2=start;
        for(int i=0;i<length; i++){
            p2=p2.next;
        }
        System.out.println(p2.value);
        while(p2!=p1){
            p1=p1.next;
            p2=p2.next;
        }
        System.out.println(p2.value);
        return p1;
    }
    public static void main(String [] args){
        LinkList nextNode=null;
        LinkList start=null;
        for(int i=0; i<7; i++){
            LinkList node = new LinkList(i,nextNode);
            nextNode=node;
            start=node;
        }
        start.next.next.next.next.next.next.next=start.next.next.next.next;
        System.out.println(LinkListCycle.linkListCycle(start));
        System.out.println(LinkListCycle.startOfLinkListCycle(start, 3).value);
    }
}