// Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.

public class SubListReversal{
    public static CustomList subListReversal(CustomList start, int p, int q){
        CustomList previous=null;
        CustomList current=start;
        int position=0;
        CustomList rlStart=current;
        CustomList beforeStart=null;
        while(current!=null){
            position++;
            if(position==p-1){
                beforeStart=current;
            }
            if(position>=p && position<=q){
                if(position==p){
                    rlStart=current;
                }
                CustomList temp=current.next;
                current.next=previous;
                previous=current;
                current=temp;
                if(position==q){
                    rlStart.next=current;
                }
            }
            else{
                current=current.next;
            }
        }
        if(beforeStart==null){
            start=previous;
        }
        else{
            beforeStart.next=previous;
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
        CustomList output=SubListReversal.subListReversal(start,1,4);
        while(output!=null){
            System.out.print(output.value+" ");
            output=output.next;
        }
    }
}