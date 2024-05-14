public class DetectLoop {
    public static void main(String[] args) {
        LinkedListModel list = new LinkedListModel(1);
        ListNode head = list.head;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next;
        boolean hasLoop = detectLoop(head);
        System.out.println("hasLoop = " + hasLoop);
    }

    public static boolean detectLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }


}
