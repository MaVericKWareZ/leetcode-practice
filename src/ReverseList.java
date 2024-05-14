public class ReverseList {
    public static void main(String[] args) {
        LinkedListModel list = new LinkedListModel(1);
        ListNode head = list.head;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode reverseList = getReverseList(head);
        System.out.println("reverseList = " + reverseList);
        LinkedListModel.printLinkedList(reverseList);
        System.out.println("reverseList = " + reverseList);
        ListNode reverseRecursive = getReverseListRecursive(head);
        LinkedListModel.printLinkedList(reverseRecursive);

    }

    private static ListNode getReverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = getReverseListRecursive(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    private static ListNode getReverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}
