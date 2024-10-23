// Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head. If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

public class ReverseAllKLengthSubLists{
    public static CustomList reverseAllKLengthSubLists(CustomList start, int k){
        CustomList current=start;
        CustomList previous=null;
        CustomList ls=null;
        CustomList lb=null;
        if(start==null || start.next==null){
            return start;
        }
        int count=0;
        while(current!=null){
            count++;
            if(count==1){
                ls=current;
                lb=previous;
                if(lb!=null){
                }
                if(current.next==null){
                    return start;
                }
            }
            CustomList temp=current.next;
            current.next=previous;
            previous=current;
            current=temp;
            if(count==3 || current==null){
                ls.next=current;
                if(lb==null){
                    start=previous;
                }
                else{
                    lb.next=previous;
                }
                previous=ls;
                count=0;
            }
        }
        return start;
    }
    public static void main(String [] args){
        CustomList start=new CustomList(1);
        CustomList current=start;
        CustomList newNode=new CustomList(2);
        current.next=newNode;
        current=newNode;
        newNode=new CustomList(3);
        current.next=newNode;
        current=newNode;
        newNode=new CustomList(4);
        current.next=newNode;
        current=newNode;
        newNode=new CustomList(5);
        current.next=newNode;
        current=newNode;
        newNode=new CustomList(6);
        current.next=newNode;
        current=newNode;
        newNode=new CustomList(7);
        current.next=newNode;
        current=newNode;
        newNode=new CustomList(8);
        current.next=newNode;
        current=newNode;
        newNode=new CustomList(9);
        current.next=newNode;
        current=newNode;
        newNode=new CustomList(10);
        current.next=newNode;
        current=newNode;
        newNode=new CustomList(11);
        current.next=newNode;
        current=newNode;
        CustomList output=ReverseAllKLengthSubLists.reverseAllKLengthSubLists(start,3);
        while(output!=null){
            System.out.print(output.value+" ");
            output=output.next;
        }
    }
}