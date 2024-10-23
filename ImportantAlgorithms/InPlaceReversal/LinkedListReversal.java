// Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return the new head of the reversed LinkedList.

class CustomList{
    int value;
    CustomList next;
    public CustomList(int value){
        this.value=value;
        this.next=null;
    }
}

public class LinkedListReversal{
    public static CustomList linkedListReversal(CustomList start){
        CustomList previous=null;
        CustomList current=start;
        while(current!=null){
            CustomList temp=current.next;
            current.next=previous;
            previous=current;
            current=temp;
        }
        return previous;
    }
    public static void main(String [] args){
        CustomList start=new CustomList(2);
        CustomList current=start;
        CustomList newNode=new CustomList(4);
        current.next=newNode;
        current=newNode;
        newNode=new CustomList(6);
        current.next=newNode;
        current=newNode;
        newNode=new CustomList(8);
        current.next=newNode;
        current=newNode;
        newNode=new CustomList(10);
        current.next=newNode;
        current=newNode;
        CustomList output=LinkedListReversal.linkedListReversal(start);
        while(output!=null){
            System.out.print(output.value+" ");
            output=output.next;
        }
    }
}