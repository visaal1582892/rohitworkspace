class LinkedList{
    int value;
    LinkedList next;
    LinkedList(int value){
        this.value = value;
        this.next = null;
    }
}
public class LinkedListCycleLength {
    public static int linkedListCycleLength(LinkedList start){
        LinkedList slow = start;
        LinkedList fast = start;
        int cycleLength = 0;
        do {
            if (fast.next != null) {
                fast = fast.next.next;
            }
            else{
                fast = fast.next;
            }
            if (slow != null && slow.next != null) {
                slow = slow.next;
            }
            cycleLength++;
        }while (fast != slow && fast != null);
        if (fast == slow) {
            return cycleLength;
        }
        if (fast == null) {
            System.out.println("cycle not found");
        }
        return 0;
    }
    public static void main(String[] args) {
        LinkedList start = new LinkedList(1);
        LinkedList mv = start;
        for (int i = 2; i < 7; i++) {
            LinkedList newNode = new LinkedList(i);
            mv.next = newNode;
            mv = newNode;
        }
        mv.next = start.next.next.next;
        System.out.println(LinkedListCycleLength.linkedListCycleLength(start));
    }
}
