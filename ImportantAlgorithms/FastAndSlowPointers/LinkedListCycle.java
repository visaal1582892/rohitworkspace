class LinkedList{
    int value;
    LinkedList next;
    LinkedList(int value){
        this.value = value;
        this.next = null;
    }
}
public class LinkedListCycle {
    public static boolean checkCycle(LinkedList start){
        LinkedList slow = start;
        LinkedList fast = start;
        do {
            // System.out.println(slow.value+" "+fast.value);
            if (slow != null) {
                slow = slow.next;
            }
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            }
            else{
                fast = fast.next;
            }
        }while (fast!=null && fast!=slow);
        if (fast == null) {
            return false;
        }
        if (fast == slow) {
            return true;
        }
        return false;
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
        System.out.println(LinkedListCycle.checkCycle(start));
    }
}
