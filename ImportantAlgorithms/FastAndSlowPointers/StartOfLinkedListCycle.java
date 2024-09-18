
class LinkedList{
    int value;
    LinkedList next;
    LinkedList(int value){
        this.value = value;
        this.next = null;
    }
}
public class StartOfLinkedListCycle {
    public static LinkedList startOfLinkedListCycle(LinkedList start){
        LinkedList slow = start;
        LinkedList fast = start;
        int cycleLength = LinkedListCycleLength.linkedListCycleLength(start);
        if (cycleLength == 0) {
            return null;
        }
        for (int i = 0; i < cycleLength; i++) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    public static void main(String[] args) {
        LinkedList start = new LinkedList(1);
        LinkedList mv = start;
        for (int i = 2; i < 7; i++) {
            LinkedList newNode = new LinkedList(i);
            mv.next = newNode;
            mv = newNode;
        }
        mv.next = start.next.next;
        LinkedList cycleStart = StartOfLinkedListCycle.startOfLinkedListCycle(start);
        System.out.println(cycleStart.value);
    }
}
