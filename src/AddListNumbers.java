public class AddListNumbers {
    public static void main(String[] args) {
        LinkedListModel list = new LinkedListModel(2);
        ListNode head = list.head;
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        ListNode addition = addTwoNumbers(head, head2);

        LinkedListModel.printLinkedList(addition);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.data : 0;
            int digit2 = (l2 != null) ? l2.data : 0;
            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ptr.next = new ListNode(digit);
            ptr = ptr.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ptr = dummy.next;
        dummy.next = null;
        return ptr;
    }
}
