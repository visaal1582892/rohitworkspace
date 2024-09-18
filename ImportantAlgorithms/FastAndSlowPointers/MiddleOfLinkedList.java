class LinkedList{
    int value;
    LinkedList next;
    LinkedList(int value){
        this.value = value;
        this.next = null;
    }
}
public class MiddleOfLinkedList {
    public static int middleOfLinkedList(LinkedList start){
        LinkedList fast = start;
        LinkedList slow = start;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow && fast != null && fast.next != null);
        return slow.value;
    }
    public static void main(String[] args) {
        LinkedList start = new LinkedList(1);
        LinkedList mv = start;
        for (int i = 2; i < 9; i++) {
            LinkedList newNode = new LinkedList(i);
            mv.next = newNode;
            mv = newNode;
        }
        System.out.println(MiddleOfLinkedList.middleOfLinkedList(start));
    }
}
